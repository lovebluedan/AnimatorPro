package com.mzs.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity

/**
 * Create by ldr
 * on 2019/12/26 10:09.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpWindow()
    }

    private fun setUpWindow() {
        window.let {
            it.sharedElementEnterTransition
            it.sharedElementExitTransition
            it.sharedElementReenterTransition
            it.sharedElementReturnTransition
            it.allowEnterTransitionOverlap = false
            it.allowReturnTransitionOverlap = false
            it.exitTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade_transtion)
            it.enterTransition = Explode().apply {
                duration = 500
            }
            it.reenterTransition = Explode().apply {
                duration = 500
            }
            it.returnTransition = Slide().apply {
                duration = 500
            }
        }
    }
}