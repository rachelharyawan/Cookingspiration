package com.application.cookingspiration.model

import com.application.cookingspiration.model.GenerateMeals
import retrofit2.Call
import retrofit2.http.GET

interface APIEndpoint {

    @GET("mealplanner/generate?timeFrame=week&apiKey=3489fcd6d1e94e9ba4caab87078c4302")
    fun getMeals(): Call<GenerateMeals>
}