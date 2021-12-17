package com.application.cookingspiration.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.application.cookingspiration.R
import com.application.cookingspiration.model.APIEndpoint
import com.application.cookingspiration.model.GenerateMeals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class FirstCard : AppCompatActivity() {

    lateinit var endpointAPI: APIEndpoint
    lateinit var namebreakfastTextView: TextView
    lateinit var sourcebreakfastTextView: TextView
    lateinit var namelunchTextView: TextView
    lateinit var sourcelunchTextView: TextView
    lateinit var namedinnerTextView: TextView
    lateinit var sourcedinnerTextView: TextView
    lateinit var caloriesTextView: TextView
    lateinit var carbohydratesTextView: TextView
    lateinit var fatTextView: TextView
    lateinit var proteinTextView: TextView
    lateinit var firstdate: TextView

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        namebreakfastTextView = findViewById(R.id.namebreakfast)
        sourcebreakfastTextView = findViewById(R.id.sourcebreakfast)
        namelunchTextView = findViewById(R.id.namelunch)
        sourcelunchTextView = findViewById(R.id.sourcelunch)
        namedinnerTextView = findViewById(R.id.namedinner)
        sourcedinnerTextView = findViewById(R.id.sourcedinner)
        caloriesTextView = findViewById(R.id.calories)
        carbohydratesTextView = findViewById(R.id.carbohydrates)
        fatTextView = findViewById(R.id.fat)
        proteinTextView = findViewById(R.id.protein)

        firstdate = findViewById(R.id.firstdate)

        val calendar : Calendar = Calendar.getInstance()
        val first : Date = calendar.getTime()
        val dateFormat : DateFormat = SimpleDateFormat("EEE, MMM d, yyyy")
        val firstcarddate : String = dateFormat.format(first)
        firstdate.setText(firstcarddate)

        //Build Retrofit
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        endpointAPI = retrofit.create(APIEndpoint::class.java)
        getMeals()
    }

    private fun getMeals() {
        val call: Call<GenerateMeals> = endpointAPI.getMeals()

        call.enqueue(object: Callback<GenerateMeals> {
            override fun onResponse(call: Call<GenerateMeals>,
                                    response: Response<GenerateMeals>
            ) {
                if (response.body()!= null) {
                    response.body()!!.week.monday.meals[0].title.also { namebreakfastTextView.text = it }
                    response.body()!!.week.monday.meals[1].title.also { namelunchTextView.text = it }
                    response.body()!!.week.monday.meals[2].title.also { namedinnerTextView.text = it }
                    response.body()!!.week.monday.meals[0].sourceUrl.also { sourcebreakfastTextView.text = it }
                    response.body()!!.week.monday.meals[1].sourceUrl.also { sourcelunchTextView.text = it }
                    response.body()!!.week.monday.meals[2].sourceUrl.also { sourcedinnerTextView.text = it }
                    response.body()!!.week.monday.nutrients.calories.also { caloriesTextView.text = it.toString() + "cal"}
                    response.body()!!.week.monday.nutrients.carbohydrates.also { carbohydratesTextView.text = it.toString() + "g" }
                    response.body()!!.week.monday.nutrients.fat.also { fatTextView.text = it.toString() + "g" }
                    response.body()!!.week.monday.nutrients.protein.also { proteinTextView.text = it.toString() + "g" }
                }
            }

            override fun onFailure(call: Call<GenerateMeals>, t: Throwable) {
                namebreakfastTextView.text = t.toString()
            }
        })
    }
}