package com.nasahome.app.ui.details

/**
 * States for View click
 */
sealed class ViewClickState {
    object ButtonPreviousClick : ViewClickState()
    object ButtonNextClick : ViewClickState()
    object ImageViewBackClick : ViewClickState()
    object StateNone : ViewClickState()
}
