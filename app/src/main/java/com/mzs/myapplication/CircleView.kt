package com.mzs.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.mzs.myapplication.Utils.dpToPixel

/**
 * Create by ldr
 * on 2019/12/2 15:48.
 */
class CircleView : View {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val rectF = RectF()

    init {
        paint.run {
            textSize = dpToPixel(50f)
            textAlign = Paint.Align.CENTER
        }
    }

    var radius = dpToPixel(120f)

    var progress: Float = 0f
        set(value) {
            field = value
            invalidate()
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var centerX = width / 2f
        var centerY = height / 2f
        //画弧形进度条
        paint.run {
            color = context.getColor(R.color.colorAccent)
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            strokeWidth = dpToPixel(20f)
        }
        rectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas!!.drawArc(rectF, 135f, progress * 2.7f, false, paint)

        //画百分比的数值
        paint.run {
            color = Color.BLACK
            style = Paint.Style.FILL
        }
        canvas.drawText("${progress.toInt()}%", centerX, centerY+40, paint)
    }

}