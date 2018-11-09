package com.waj.testcoordinatorlayout

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

class TouchMoveView(context: Context?, attrs: AttributeSet?) : TextView(context, attrs) {
    var cx = 0F
    var cy = 0F

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when(event.action){
                MotionEvent.ACTION_DOWN->{
                    cx = event.rawX
                    cy = event.rawY
                    return true
                }
                MotionEvent.ACTION_MOVE->{
                    val x = event.rawX-cx
                    val y = event.rawY-cy
                    left += x.toInt()
                    right += x.toInt()
                    top += y.toInt()
                    bottom += y.toInt()

                    cx = event.rawX
                    cy = event.rawY
                    return true
                }
                else->false
            }
        }
        return false
    }
}