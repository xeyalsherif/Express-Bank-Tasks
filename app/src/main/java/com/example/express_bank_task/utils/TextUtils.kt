package com.example.express_bank_task.utils

import android.content.res.Resources
import android.text.Spannable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.DisplayMetrics

object TextUtils {

    fun getUnderlinedText(text: String): Spannable {
        val spannable: Spannable = SpannableString(text)
        spannable.setSpan(
            UnderlineSpan(),
            0,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }

    fun convertDpToPixel(dp: Float): Float {
        return dp * (Resources.getSystem()
            .displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

}