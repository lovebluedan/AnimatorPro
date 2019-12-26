package com.mzs.myapplication

import android.app.ActivityOptions
import android.os.Bundle
import android.transition.ChangeBounds
import android.view.Window
import kotlinx.android.synthetic.main.activity_share_element.*

class ShareElementActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.sharedElementEnterTransition = ChangeBounds()
        window.sharedElementExitTransition = ChangeBounds()
        window.exitTransition = ChangeBounds()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element2)
        title = "ShareElementActivity"
        button2.setOnClickListener{
            onBackPressed()
        }
    }

}
