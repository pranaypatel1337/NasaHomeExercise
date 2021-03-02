package com.nasahome.app.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

/**
 * Read json file from asset
 **/
fun Context.readDataFromAsset(fileName: String): String {
    return assets.open(fileName).bufferedReader().use {
        it.readText()
    }
}

/**
 * Convert String date to Date object
 */
fun String.toDate(): Date {
return SimpleDateFormat("yyyy-MM-dd",Locale.getDefault()).parse(this)
}

/**
 * Show roast message
 */
fun Fragment.toast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

/**
 * Hide View
 */
fun View.hide() {
    visibility = View.GONE
}

/**
 * To convert date into formatted string date
 */
fun Date.formatDate(): String {
    return SimpleDateFormat("dd MMM, yyyy", Locale.getDefault()).format(this)
}