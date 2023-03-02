package com.example.simplecalculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_clear = findViewById<Button>(R.id.button_clear)
        var input = findViewById<TextView>(R.id.input)
        var output = findViewById<TextView>(R.id.output)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        val button_bracket_left = findViewById<Button>(R.id.button_bracket_left)
        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        val button_bracket_right = findViewById<Button>(R.id.button_bracket_right)
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        val button_0 = findViewById<Button>(R.id.button_0)
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        val button_1 = findViewById<Button>(R.id.button_1)
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        val button_2 = findViewById<Button>(R.id.button_2)
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        val button_3 = findViewById<Button>(R.id.button_3)
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        val button_4 = findViewById<Button>(R.id.button_4)
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        val button_5 = findViewById<Button>(R.id.button_5)
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        val button_6 = findViewById<Button>(R.id.button_6)
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        val button_7 = findViewById<Button>(R.id.button_7)
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        val button_8 = findViewById<Button>(R.id.button_8)
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        val button_9 = findViewById<Button>(R.id.button_9)
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        val button_dot = findViewById<Button>(R.id.button_dot)
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        val button_division = findViewById<Button>(R.id.button_division)
        button_division.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        val button_multiply = findViewById<Button>(R.id.button_multiply)
        button_multiply.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }
        val button_subtraction = findViewById<Button>(R.id.button_subtraction)
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        val button_addition = findViewById<Button>(R.id.button_addition)
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }
        val button_equals = findViewById<Button>(R.id.button_equals)
        button_equals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        var input = findViewById<TextView>(R.id.input)
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var input = findViewById<TextView>(R.id.input)
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        var input = findViewById<TextView>(R.id.input)
        var output = findViewById<TextView>(R.id.output)
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

}