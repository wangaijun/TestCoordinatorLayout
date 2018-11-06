package com.waj.testcoordinatorlayout

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View

class MyBehavior<V : View>(context: Context?, attrs: AttributeSet?) :
        android.support.design.widget.CoordinatorLayout.Behavior<V>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        return child.id==R.id.tv && dependency.id == R.id.view
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        if (child.id!=R.id.tv || dependency.id!=R.id.view) {
            return super.onDependentViewChanged(parent, child, dependency)
        }
        else{
            child.left = dependency.left + 300
            child.right = child.left + 200
            child.top = dependency.top + 20
            child.bottom = child.top+200
            return true
        }
    }
}