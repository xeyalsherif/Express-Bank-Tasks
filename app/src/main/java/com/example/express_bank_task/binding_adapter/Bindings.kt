package com.example.express_bank_task.binding_adapter

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.express_bank_task.models.enums.CategoryType
import com.example.express_bank_task.utils.TextUtils

class Bindings {
    companion object {
        @BindingAdapter("setUnderlinedText")
        @JvmStatic
        fun TextView.setUnderlinedText(text: String) {
            this.text = text
            this.setPadding(0, 0, 0, TextUtils.convertDpToPixel(3F).toInt())
            this.text = TextUtils.getUnderlinedText(text)
        }

        @BindingAdapter("customProgressDrawable")
        @JvmStatic
        fun ProgressBar.customProgressDrawable(categoryType: CategoryType) {
            when (categoryType) {
                CategoryType.AIRLINES -> {
                    progressDrawable = ContextCompat.getDrawable(
                        context,
                        CategoryType.AIRLINES.background
                    )
                }
                CategoryType.RENT_A_CAR -> {
                    progressDrawable = ContextCompat.getDrawable(
                        context,
                        CategoryType.RENT_A_CAR.background
                    )
                }
                CategoryType.HOTELS -> {
                    progressDrawable = ContextCompat.getDrawable(
                        context,
                        CategoryType.HOTELS.background
                    )
                }
                CategoryType.TRANSPORT -> {
                    progressDrawable = ContextCompat.getDrawable(
                        context,
                        CategoryType.TRANSPORT.background
                    )
                }
                CategoryType.CARS_AND_VEHICLES -> {
                    progressDrawable = ContextCompat.getDrawable(
                        context,
                        CategoryType.CARS_AND_VEHICLES.background
                    )
                }
                CategoryType.GOVERNMENT_SERVICES -> {
                    progressDrawable = ContextCompat.getDrawable(
                        context,
                        CategoryType.GOVERNMENT_SERVICES.background
                    )
                }
            }
        }

        @BindingAdapter("customSrc")
        @JvmStatic
        fun ImageView.customSrc(categoryType: CategoryType) {
            when (categoryType) {
                CategoryType.AIRLINES -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            CategoryType.AIRLINES.icon
                        )
                    )
                }
                CategoryType.RENT_A_CAR -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            CategoryType.RENT_A_CAR.icon
                        )
                    )
                }
                CategoryType.HOTELS -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            CategoryType.HOTELS.icon
                        )
                    )
                }
                CategoryType.TRANSPORT -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            CategoryType.TRANSPORT.icon
                        )
                    )
                }
                CategoryType.CARS_AND_VEHICLES -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            CategoryType.CARS_AND_VEHICLES.icon
                        )
                    )
                }
                CategoryType.GOVERNMENT_SERVICES -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            CategoryType.GOVERNMENT_SERVICES.icon
                        )
                    )
                }
            }
        }


    }
}