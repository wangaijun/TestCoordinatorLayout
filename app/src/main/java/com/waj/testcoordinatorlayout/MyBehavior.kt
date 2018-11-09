package com.waj.testcoordinatorlayout

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup


class MyBehavior<V : View>(context: Context?, attrs: AttributeSet?) :
        android.support.design.widget.CoordinatorLayout.Behavior<V>(context, attrs) {

    private var width:Int = 0

    init {
        val display = context?.resources?.displayMetrics
        display?.let {
            width = it.widthPixels
        }
    }

    override fun layoutDependsOn(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        return child.id==R.id.tv && dependency.id == R.id.view
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        return if (child.id!=R.id.tv || dependency.id!=R.id.view) {
            super.onDependentViewChanged(parent, child, dependency)
        }
        else{
            //根据dependency的位置，设置child的位置
            Position.setPosition(child,width-dependency.left-child.width,dependency.top)

            true
        }
    }
}