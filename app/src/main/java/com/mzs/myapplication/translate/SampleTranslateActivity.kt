package com.mzs.myapplication.translate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.util.Log
import android.view.View

import kotlinx.android.synthetic.main.activity_sample_translate.*
import com.mzs.myapplication.R
import android.graphics.Rect
import android.os.Build
import android.transition.TransitionSet.ORDERING_TOGETHER
import android.transition.Visibility.MODE_IN
import android.view.Gravity
import android.view.animation.AccelerateDecelerateInterpolator


class SampleTranslateActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        val TAG = SampleTranslateActivity::class.java.name
    }
    lateinit var view:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_translate)
        root_view.setOnClickListener(this)
        btn_change_bounds.setOnClickListener(this)
        btn_change_clip_bounds.setOnClickListener(this)
        btn_change_scroll.setOnClickListener(this)
        button.setOnClickListener(this)
    }

    var i: Int = 0
    @SuppressLint("NewApi")
    override fun onClick(v: View?) {
        when (v!!.id) {
            //点击底部布局 各种
            R.id.root_view -> {
                i++
                when (i % 2) {
                    0 -> {
                        val transitionSet = TransitionSet()
                        transitionSet.addTransition(Fade())
                        transitionSet.addTransition(Slide())
                        transitionSet.ordering = ORDERING_TOGETHER
                        transitionSet.duration = 2000
                        TransitionManager.beginDelayedTransition(root_view, transitionSet)
                        Log.i(TAG, "Fade+Slide 淡出淡入效果跟幻灯片效果")
                    }
                    1 -> {
                        val translation =  Slide().apply {
                            duration = 2000
                            interpolator = AccelerateDecelerateInterpolator()
                            slideEdge = Gravity.TOP
                        }
                        TransitionManager.beginDelayedTransition(root_view, translation)
//                        TransitionManager.go(Scene.getSceneForLayout(root_view,))
                        Log.i(TAG, "Slide幻灯片Slide")
                    }
//                    2 -> {
//                        TransitionManager.beginDelayedTransition(root_view, Explode())
//                        Log.i(TAG, "Explode爆炸 从屏幕中间向四周抛开")
//                    }
//                    3 -> {
//                        TransitionManager.beginDelayedTransition(root_view, AutoTransition())
//                        Log.i(TAG, "AutoTransition-- 其实里面实现的也是淡出淡入效果")
//                    }
                }
                toggleVisibility(view_text,view_blue, view1_red, view_yellow)
            }
            //点击按钮
            R.id.btn_change_bounds -> {
            TransitionInflater.from(this).inflateTransition(R.transition.fade_transtion)
                TransitionManager.beginDelayedTransition(root_view, ChangeBounds())
                var lp = view1_red.layoutParams
                if (lp.height == 500) {
                    lp.height = 200
                } else {
                    lp.height = 500
                }
                view1_red.layoutParams = lp
            }
            //剪切的
            R.id.btn_change_clip_bounds -> {
                TransitionManager.beginDelayedTransition(root_view, ChangeClipBounds())
                val r = Rect(20, 20, 100, 100)
                if (r == view1_red.clipBounds) {
                    view1_red.clipBounds = null
                } else {
                    view1_red.clipBounds = r
                }
            }
            //内部滑动
            R.id.btn_change_scroll -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    val t = ChangeScroll()
                    TransitionManager.beginDelayedTransition(root_view, t)
                }
                if(view_text.scrollX == -50 && view_text.scrollY == -50){
                    view_text.scrollTo(0,0)
                }else{
                    view_text.scrollTo(-50,-50)
                }
            }
            R.id.button->{
             val intent = Intent(this,TransitionActivity1::class.java)
             startActivity(intent)
            }
        }
    }

    /**
     * 显示隐藏布局
     */
    private fun toggleVisibility(vararg views: View?) {
        for (view in views) {
            view!!.visibility =
                if (view!!.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
        }
    }

}
