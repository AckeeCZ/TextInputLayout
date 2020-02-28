package com.example.customtextinputlayout

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cz.ackee.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var inputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputLayout = findViewById(R.id.input_layout)
        findViewById<Button>(R.id.trigger_error).setOnClickListener {
            inputLayout.error = if (inputLayout.error == null) {
                "Error text"
            } else {
                null
            }
        }
        findViewById<Button>(R.id.trigger_hint).setOnClickListener {
            inputLayout.hint = if (inputLayout.hint == null) {
                "Hint"
            } else {
                 null
            }
        }
        findViewById<Button>(R.id.disable).setOnClickListener {
            inputLayout.isEnabled = !inputLayout.isEnabled
        }
    }
}
