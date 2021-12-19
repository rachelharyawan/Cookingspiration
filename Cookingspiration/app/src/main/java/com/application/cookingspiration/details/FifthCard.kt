package com.application.cookingspiration.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

class FifthCard : AppCompatActivity() {

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
    lateinit var fifthdate: TextView
    
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

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

        fifthdate = findViewById(R.id.fifthdate)

        val calendar : Calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val fifth : Date = calendar.getTime()
        val dateFormat : DateFormat = SimpleDateFormat("EEE, MMM d, yyyy")
        val fifthcarddate : String = dateFormat.format(fifth)
        fifthdate.setText(fifthcarddate)

        //Build Retrofit
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        endpointAPI = retrofit.create(APIEndpoint::class.java)
        getMeals()
    }

    override fun onCreateOptionsMenu(menu : Menu?) : Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    private fun getMeals() {
        val call: Call<GenerateMeals> = endpointAPI.getMeals()

        call.enqueue(object: Callback<GenerateMeals> {
            override fun onResponse(call: Call<GenerateMeals>,
                                    response: Response<GenerateMeals>
            ) {
                if (response.body()!= null) {
                    response.body()!!.week.friday.meals[0].title.also { namebreakfastTextView.text = it }
                    response.body()!!.week.friday.meals[1].title.also { namelunchTextView.text = it }
                    response.body()!!.week.friday.meals[2].title.also { namedinnerTextView.text = it }
                    response.body()!!.week.friday.meals[0].sourceUrl.also { sourcebreakfastTextView.text = it }
                    response.body()!!.week.friday.meals[1].sourceUrl.also { sourcelunchTextView.text = it }
                    response.body()!!.week.friday.meals[2].sourceUrl.also { sourcedinnerTextView.text = it }
                    response.body()!!.week.friday.nutrients.calories.also { caloriesTextView.text = it.toString() + "cal"}
                    response.body()!!.week.friday.nutrients.carbohydrates.also { carbohydratesTextView.text = it.toString() + "g" }
                    response.body()!!.week.friday.nutrients.fat.also { fatTextView.text = it.toString() + "g" }
                    response.body()!!.week.friday.nutrients.protein.also { proteinTextView.text = it.toString() + "g" }
                }
            }

            override fun onFailure(call: Call<GenerateMeals>, t: Throwable) {
                namebreakfastTextView.text = t.toString()
            }
        })
    }

    override fun onOptionsItemSelected(item : MenuItem) : Boolean {
        when (item.itemId) {
            R.id.sharebutton -> {
                val title = "Menu for " + fifthdate.text.toString()
                val description1 = "Menu for " + fifthdate.text.toString() +
                        "\n\n" + namebreakfastTextView.text.toString() + " " + sourcebreakfastTextView.text.toString() + " " +
                        "\n" + namelunchTextView.text.toString() + " " + sourcelunchTextView.text.toString() + " " +
                        "\n" + namedinnerTextView.text.toString() + " " + sourcedinnerTextView.text.toString() + " " +
                        "\n\n" + "Calories: " + caloriesTextView.text.toString() + " " +
                        "\n" + "Carbohydrates: " + carbohydratesTextView.text.toString() + " " +
                        "\n" + "Fat: " + fatTextView.text.toString() + " " +
                        "\n" + "Protein: " + proteinTextView.text.toString() + " "
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.type = "text/plain"
                sendIntent.putExtra(Intent.EXTRA_TITLE, title)
                sendIntent.putExtra(Intent.EXTRA_TEXT, description1)
                startActivity(Intent.createChooser(sendIntent, "Share this daily menu planner"))
            }
        }

        return super.onOptionsItemSelected(item)
    }
}