package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    lateinit var enter_amount: EditText
    lateinit var show_conversion: TextView

    val rs_to_usd: Double = 0.0135
    val rs_to_gbp: Double = 0.0098
    val rs_to_eur: Double = 0.012
    val rs_to_yen: Double = 1.49
    val rs_to_cad: Double = 0.017
    val rs_to_aed: Double = 0.05

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usd_button: Button = findViewById(R.id.convert_to_usd)
        val gbp_button: Button = findViewById(R.id.convert_to_gbp)
        val eur_button: Button = findViewById(R.id.convert_to_eur)
        val yen_button: Button = findViewById(R.id.convert_to_yen)
        val cad_button: Button = findViewById(R.id.convert_to_cad)
        val aed_button: Button = findViewById(R.id.convert_to_aed)

        usd_button.setOnClickListener {
            convert_money("$", rs_to_usd)
        }
        gbp_button.setOnClickListener {
            convert_money("£", rs_to_gbp)
        }
        eur_button.setOnClickListener {
            convert_money("€", rs_to_eur)
        }
        yen_button.setOnClickListener {
            convert_money("¥", rs_to_yen)
        }
        cad_button.setOnClickListener {
            convert_money("CAN$ ", rs_to_cad)
        }
        aed_button.setOnClickListener {
            convert_money("AED ", rs_to_aed)
        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }

    fun convert_money(symbol: String, conversion_rate: Double){
        enter_amount = findViewById(R.id.enter_amount)
        show_conversion = findViewById(R.id.show_conversion)

        try {
            var current_money: Double = enter_amount.editableText.toString().toDouble()
            var amount: Double = (current_money * conversion_rate).round(2)
            show_conversion.setText("Amount: ${symbol}${amount}")
        } catch (e: Exception) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            show_conversion.setText("")
        }
    }
}


