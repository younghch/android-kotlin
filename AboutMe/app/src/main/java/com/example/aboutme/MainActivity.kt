package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //  https://developer.android.com/topic/libraries/data-binding/
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Younghch")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            // https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter,
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        // Ctrl+G macOS multiple select shorcut on android
        binding.apply{
            myName?.nickname = nicknameEidt.text.toString()
            invalidateAll()
            nicknameEidt.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


//        https://kotlinlang.org/docs/typecasts.html#safe-nullable-cast-operator
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}