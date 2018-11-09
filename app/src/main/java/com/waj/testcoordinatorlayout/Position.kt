package com.waj.testcoordinatorlayout

import android.view.View
import android.view.ViewGroup

object Position{
    fun setPosition(child: View, x: Int, y: Int) {
        val layoutParams = child.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.leftMargin = x
        layoutParams.topMargin = y
        child.layoutParams = layoutParams
    }
}