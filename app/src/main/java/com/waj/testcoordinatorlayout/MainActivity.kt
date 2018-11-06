package com.waj.testcoordinatorlayout

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    var cx = 0F
    var cy = 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN->{
                    cx = event.rawX
                    cy = event.rawY
                }
                MotionEvent.ACTION_MOVE->{
                    val x = event.rawX-cx
                    val y = event.rawY-cy
                    v.left += x.toInt()
                    v.right += x.toInt()
                    v.top += y.toInt()
                    v.bottom += y.toInt()

                    cx = event.rawX
                    cy = event.rawY
                }
            }

            return@setOnTouchListener true
        }
    }
}
