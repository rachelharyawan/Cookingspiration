package com.application.cookingspiration.model


import com.google.gson.annotations.SerializedName

data class Monday(
    val meals: List<MealX>,
    val nutrients: NutrientsX
)