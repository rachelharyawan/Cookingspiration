package com.application.cookingspiration.model


import com.google.gson.annotations.SerializedName

data class MealXXXXX(
    val id: Int,
    val imageType: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val title: String
)