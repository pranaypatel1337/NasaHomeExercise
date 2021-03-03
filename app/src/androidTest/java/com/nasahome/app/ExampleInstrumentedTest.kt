package com.nasahome.app

import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nasahome.app.model.PhotoDetailsItem
import com.nasahome.app.viewmodel.PhotosViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private val appContext: NasaApp = ApplicationProvider.getApplicationContext()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        assertEquals("com.nasahome.app", appContext.packageName)
    }

    @Test
    fun getPhoto_List_Prepared() {
        val photosViewModel = PhotosViewModel(appContext)
        assert(photosViewModel.photosList.isNotEmpty())
    }
}