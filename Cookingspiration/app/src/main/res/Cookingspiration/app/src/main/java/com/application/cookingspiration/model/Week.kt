package com.application.cookingspiration.model


import com.google.gson.annotations.SerializedName

data class Week(
    val friday: Friday,
    val monday: Monday,
    val saturday: Saturday,
    val sunday: Sunday,
    val thursday: Thursday,
    val tuesday: Tuesday,
    val wednesday: Wednesday
)