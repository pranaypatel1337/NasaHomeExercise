package com.nasahome.app.extension

import android.content.Context
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

fun String.toDate(): Date {
return SimpleDateFormat("yyyy-MM-dd",Locale.getDefault()).parse(this)
}