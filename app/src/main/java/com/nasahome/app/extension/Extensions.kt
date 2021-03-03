package com.nasahome.app.extension

import android.content.Context
import android.content.res.AssetManager
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*

/**
 * Read json file from asset
 **/
fun AssetManager.readDataFromAsset(fileName: String): String {
    return open(fileName).bufferedReader().use {
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
/**
 * Extension Function for initializing [MutableLiveData] with some initial value
 * @param data is the initial value
 * */
fun <T> MutableLiveData<T>.initWith(data: T): MutableLiveData<T> = this.apply {
    value = data
}