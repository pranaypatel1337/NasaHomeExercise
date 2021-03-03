package com.nasahome.app.ui.details

sealed class ViewClickState {
    object ButtonPreviousClick : ViewClickState()
    object ButtonNextClick : ViewClickState()
    object ImageViewBackClick : ViewClickState()
    object StateNo : ViewClickState()
}
