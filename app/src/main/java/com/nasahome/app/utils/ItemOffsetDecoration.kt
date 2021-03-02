package com.nasahome.app.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetDecoration(val offset: Int) : RecyclerView.ItemDecoration() {
    constructor(
        @NonNull context: Context,
        @DimenRes itemOffset: Int
    ) : this(context.resources.getDimensionPixelOffset(itemOffset))

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(offset, offset, offset, offset)
    }
}