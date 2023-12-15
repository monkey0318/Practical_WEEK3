package com.example.practical_week3

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.practical_week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//#2 create a binding object
    lateinit var binding: ActivityMainBinding
//initialise data class
    private var myName2: MyName = MyName("BAIT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //#initialise binding object with activity_main layout
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myNameOne = myName2
//        setContentView(R.layout.activity_main)

//        nickNameEditText = findViewById(R.id.nickNameEditText)
//        nickNameTextView = findViewById(R.id.nickNameText)
//        confirmBtn = findViewById(R.id.confirmBtn)

//        confirmBtn.setOnClickListener { changeNickName(it) }
//        nickNameTextView.setOnClickListener { updateNickName() }

        binding.confirmBtn.setOnClickListener{ changeNickName(it)}
        binding.nickNameText.setOnClickListener{ updateNickName() }
        binding.callBtn.setOnClickListener{ callMe(it) }
    }

    private fun changeNickName(view : View){
        binding.apply{
        if ( !nickNameEditText.text.toString().isBlank() ){
            myNameOne?.nickname = binding.nickNameEditText.text.toString()
            invalidateAll()
            nickNameEditText.visibility = View.GONE
            nickNameText.visibility = View.VISIBLE
            confirmBtn.visibility = View.GONE
        }
    }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickName(){
        binding.apply{
            nickNameEditText.requestFocus()
            nickNameEditText.visibility = View.VISIBLE
            confirmBtn.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nickNameEditText,0)
    }

    private fun callMe(view: View){
        val context = view.context

        val intent = Intent(context,ActivityB::class.java)

        context.startActivity(intent)
    }
}