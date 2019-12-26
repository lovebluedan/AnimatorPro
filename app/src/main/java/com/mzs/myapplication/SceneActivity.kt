package com.mzs.myapplication

import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mzs.myapplication.databinding.ActivitySceneBinding

/**
 * Create by ldr
 * on 2019/12/24 13:40.
 */
class SceneActivity : BaseActivity(), View.OnClickListener {

    companion object {
        val TAG = SceneActivity::class.java.name
    }

    lateinit var scene0: Scene
    lateinit var scene1: Scene
    lateinit var scene2: Scene
    lateinit var scene3: Scene

    lateinit var sceneRoot: ViewGroup
    lateinit var mActivityBinding: ActivitySceneBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "场景Scene示例"
        initDataBindView()
        setLayout()
        initScene()
    }

    private fun setLayout() {
        sceneRoot = findViewById(R.id.frame_layout)

    }

    //初始化多个场景
    private fun initScene() {
//        scene0 = Scene.getSceneForLayout(sceneRoot,R.layout.scene_layout0,this)
//        scene1 = Scene.getSceneForLayout(sceneRoot,R.layout.scene_layout1,this)
//        scene2 = Scene.getSceneForLayout(sceneRoot,R.layout.scene_layout2,this)
//        scene3 = Scene.getSceneForLayout(sceneRoot,R.layout.scene_layout3,this)
        scene0 = Scene(
            sceneRoot,
            LayoutInflater.from(this).inflate(R.layout.scene_layout0, sceneRoot, false)
        )
        scene1 = Scene(
            sceneRoot,
            LayoutInflater.from(this).inflate(R.layout.scene_layout1, sceneRoot, false)
        )
        scene2 = Scene(
            sceneRoot,
            LayoutInflater.from(this).inflate(R.layout.scene_layout2, sceneRoot, false)
        )
        scene3 = Scene(
            sceneRoot,
            LayoutInflater.from(this).inflate(R.layout.scene_layout3, sceneRoot, false)
        )
    }

    private fun initDataBindView() {
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_scene)
        mActivityBinding.onClickListener = this
    }

    override fun onClick(v: View?) {
        when (v) {
            mActivityBinding.btnScene1 -> {
                Log.d(TAG, "场景1")
                val transition =
                    TransitionInflater.from(this).inflateTransition(R.transition.explore_transtion)
                TransitionManager.go(scene0, transition)
            }
            mActivityBinding.btnScene2 -> {
                Log.d(TAG, "场景2")
                TransitionManager.go(
                    scene1,
                    TransitionInflater.from(this).inflateTransition(R.transition.slide_transtion)
                )
            }
            mActivityBinding.btnScene3 -> {
                Log.d(TAG, "场景3")
                TransitionManager.go(
                    scene2,
                    TransitionInflater.from(this).inflateTransition(R.transition.slide_transtion)
                )
            }
            mActivityBinding.btnScene4 -> {
                Log.d(TAG, "场景4")
                TransitionManager.go(
                    scene3,
                    TransitionInflater.from(this).inflateTransition(R.transition.explore_transtion)
                )
            }
        }
    }

}