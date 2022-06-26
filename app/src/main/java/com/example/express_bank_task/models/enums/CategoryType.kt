package com.example.express_bank_task.models.enums

import androidx.annotation.DrawableRes
import com.example.express_bank_task.R

enum class CategoryType(
    @DrawableRes val icon: Int,
    @DrawableRes val background: Int,
    @DrawableRes val color: Int
) {
    AIRLINES(
        R.drawable.ic_airlines,
        R.drawable.circular_progress_bar_blue_light,
        R.color.blue_light
    ),
    RENT_A_CAR(
        R.drawable.ic_rent_a_car,
        R.drawable.circular_progress_bar_ping_light,
        R.color.ping_light
    ),
    HOTELS(
        R.drawable.ic_hotel_and_motel,
        R.drawable.circular_progress_bar_ping,
        R.color.ping
    ),
    TRANSPORT(
        R.drawable.ic_transport,
        R.drawable.circular_progress_bar_red,
        R.color.red
    ),
    CARS_AND_VEHICLES(
        R.drawable.ic_cars_and_vehicles,
        R.drawable.circular_progress_bar_blue,
        R.color.blue
    ),
    GOVERNMENT_SERVICES(
        R.drawable.ic_government_services,
        R.drawable.circular_progress_bar_gray,
        R.color.gray
    )
}
