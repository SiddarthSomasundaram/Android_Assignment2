package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var clickCountmap= mutableMapOf<String, Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView=findViewById<TextView>(R.id.clickCountview)
        val clickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameText=findViewById<TextInputLayout>(R.id.nameText)

        clickMeButton.setOnClickListener{
            val userName=userNameText.editText?.text?.toString()
            val maskedUserName=
                if(userName.isNullOrEmpty()) "Anonymous"
                else userName
            val oldclickcount=clickCountmap[maskedUserName]?:0
            val newclickcount=oldclickcount+1

            clickCountmap[maskedUserName]=newclickcount
            //clickCount++
            clickCountDisplayView.text="Hello $maskedUserName, clicked $newclickcount times"
    }
}
}