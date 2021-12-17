package com.application.cookingspiration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.application.cookingspiration.details.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var firstdate: TextView
    lateinit var seconddate: TextView
    lateinit var thirddate: TextView
    lateinit var fourthdate: TextView
    lateinit var fifthdate: TextView
    lateinit var sixthdate: TextView
    lateinit var seventhdate: TextView
    lateinit var date: TextView

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstcard: CardView = findViewById(R.id.firstcard)
        firstcard.setOnClickListener {
            val intent = Intent(this, FirstCard::class.java)
            startActivity(intent)
        }

        val secondcard: CardView = findViewById(R.id.secondcard)
        secondcard.setOnClickListener {
            val intent = Intent(this, SecondCard::class.java)
            startActivity(intent)
        }

        val thirdcard: CardView = findViewById(R.id.thirdcard)
        thirdcard.setOnClickListener {
            val intent = Intent (this, ThirdCard::class.java)
            startActivity(intent)
        }

        val fourthcard: CardView = findViewById(R.id.fourthcard)
        fourthcard.setOnClickListener {
            val intent = Intent (this, FourthCard::class.java)
            startActivity(intent)
        }

        val fifthcard: CardView = findViewById(R.id.fifthcard)
        fifthcard.setOnClickListener {
            val intent = Intent (this, FifthCard::class.java)
            startActivity(intent)
        }

        val sixthcard: CardView = findViewById(R.id.sixthcard)
        sixthcard.setOnClickListener {
            val intent = Intent (this, SixthCard::class.java)
            startActivity(intent)
        }

        val seventhcard: CardView = findViewById(R.id.seventhcard)
        seventhcard.setOnClickListener {
            val intent = Intent (this, SeventhCard::class.java)
            startActivity(intent)
        }

        firstdate = findViewById(R.id.firstdate)
        seconddate = findViewById(R.id.seconddate)
        thirddate = findViewById(R.id.thirddate)
        fourthdate = findViewById(R.id.fourthdate)
        fifthdate = findViewById(R.id.fifthdate)
        sixthdate = findViewById(R.id.sixthdate)
        seventhdate = findViewById(R.id.seventhdate)
        date = findViewById(R.id.date)

        val calendar : Calendar = Calendar.getInstance()
        val first : Date = calendar.getTime()

        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val second : Date = calendar.getTime()

        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val third : Date = calendar.getTime()

        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val fourth : Date = calendar.getTime()

        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val fifth : Date = calendar.getTime()

        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val sixth : Date = calendar.getTime()

        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val seventh : Date = calendar.getTime()

        val dateFormat : DateFormat = SimpleDateFormat("EEE, MMM d, yyyy")

        val firstcarddate : String = dateFormat.format(first)
        val secondcarddate : String = dateFormat.format(second)
        val thirdcarddate : String = dateFormat.format(third)
        val fourthcarddate : String = dateFormat.format(fourth)
        val fifthcarddate : String = dateFormat.format(fifth)
        val sixthcarddate : String = dateFormat.format(sixth)
        val seventhcarddate : String = dateFormat.format(seventh)

        firstdate.setText(firstcarddate)
        seconddate.setText(secondcarddate)
        thirddate.setText(thirdcarddate)
        fourthdate.setText(fourthcarddate)
        fifthdate.setText(fifthcarddate)
        sixthdate.setText(sixthcarddate)
        seventhdate.setText(seventhcarddate)
        date.setText(firstcarddate + " - " + seventhcarddate)

    }

}