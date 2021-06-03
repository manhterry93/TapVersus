package pl.itto.tapversus.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class ActionButton(context: Context, attrs: AttributeSet?) : AppCompatButton(context, attrs) {

    var callBack: (() -> Unit)? = null
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
            callBack?.invoke()
        }
        return super.onTouchEvent(event)
    }
}