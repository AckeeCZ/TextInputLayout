package com.example.customtextinputlayout

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import cz.ackee.material.textfield.TextInputEditText
import cz.ackee.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var inputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputLayout = TextInputLayout(this)

        val editText = TextInputEditText(this)
        inputLayout.addView(editText, MATCH_PARENT, WRAP_CONTENT)

        with(inputLayout) {
            id = R.id.input_layout
            setPadding(8, 8, 8, 8)
            inputLayout.isErrorEnabled = true
        }

        findViewById<ConstraintLayout>(R.id.main_container)
            .addView(inputLayout, MATCH_PARENT, WRAP_CONTENT)

        findViewById<View>(R.id.main_container).setOnClickListener {
            currentFocus?.clearFocus()
            inputLayout.error = null
            inputLayout.hint = null
            inputLayout.printBoxInfo()
        }
        findViewById<Button>(R.id.trigger_error).setOnClickListener {
            inputLayout.error = "Error text"
        }
        findViewById<Button>(R.id.trigger_hint).setOnClickListener {
            inputLayout.hint = "Hint"
        }
    }

    private fun TextInputLayout.printBoxInfo() {
        Log.d(
            "printBoxInfo",
            "stroke color: $boxStrokeColor mode: $boxBackgroundMode background color: $boxBackgroundColor"
        )
    }
}
