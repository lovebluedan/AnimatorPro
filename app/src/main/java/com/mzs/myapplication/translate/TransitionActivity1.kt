package com.mzs.myapplication.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater
import com.mzs.myapplication.R
import kotlinx.android.synthetic.main.activity_transition1.*

class TransitionActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition1)
        val fade = TransitionInflater.from(this).inflateTransition(R.transition.fade_transtion)
        window.enterTransition = fade
        window.exitTransition = TransitionInflater.from(this).inflateTransition(R.transition.explore_transtion)
        button2.setOnClickListener{
            finish()
        }
    }
}
