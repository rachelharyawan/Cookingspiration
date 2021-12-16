package com.application.cookingspiration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.cardview.widget.CardView
import com.application.cookingspiration.details.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mondaycard: CardView = findViewById(R.id.mondaycard)
        mondaycard.setOnClickListener {
            val intent = Intent(this, MondayActivity::class.java)
            startActivity(intent)
        }

        val tuesdaycard: CardView = findViewById(R.id.tuesdaycard)
        tuesdaycard.setOnClickListener {
            val intent = Intent(this, TuesdayActivity::class.java)
            startActivity(intent)
        }

        val wednesdaycard: CardView = findViewById(R.id.wednesdaycard)
        wednesdaycard.setOnClickListener {
            val intent = Intent (this, WednesdayActivity::class.java)
            startActivity(intent)
        }

        val thursdaycard: CardView = findViewById(R.id.thursdaycard)
        thursdaycard.setOnClickListener {
            val intent = Intent (this, ThursdayActivity::class.java)
            startActivity(intent)
        }

        val fridaycard: CardView = findViewById(R.id.fridaycard)
        fridaycard.setOnClickListener {
            val intent = Intent (this, FridayActivity::class.java)
            startActivity(intent)
        }

        val saturdaycard: CardView = findViewById(R.id.saturdaycard)
        saturdaycard.setOnClickListener {
            val intent = Intent (this, SaturdayActivity::class.java)
            startActivity(intent)
        }

        val sundaycard: CardView = findViewById(R.id.sundaycard)
        sundaycard.setOnClickListener {
            val intent = Intent (this, SundayActivity::class.java)
            startActivity(intent)
        }
    }

}