package com.mzs.myapplication

import android.app.ActivityOptions
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_share_element.*

class ShareElementActivity1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element)
        title = "ShareElementActivity"
        button2.setOnClickListener{
            onBackPressed()
        }
    }

}
