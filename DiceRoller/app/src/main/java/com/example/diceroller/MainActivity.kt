package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImageView = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById<Button>(R.id.roll_button)

//      https://kotlinlang.org/docs/fun-interfaces.html,  kotlin provides a fast way to implement functional interface
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val diceNumber: Int = Random().nextInt(6)+1
        val diceUri = "@drawable/dice_$diceNumber"
        val diceImageResource: Int = resources.getIdentifier(diceUri, null, packageName)
        diceImageView.setImageResource(diceImageResource)
    }
}