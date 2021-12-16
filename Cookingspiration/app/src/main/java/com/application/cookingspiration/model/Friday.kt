package com.application.cookingspiration.model


import com.google.gson.annotations.SerializedName

data class Friday(
    val meals: List<Meal>,
    val nutrients: Nutrients
)