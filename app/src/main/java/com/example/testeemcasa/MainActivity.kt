package com.example.testeemcasa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtPeso: EditText = findViewById(R.id.edtPeso)
        val edtAltura: EditText = findViewById(R.id.edtAltura)
        val clickButton: Button = findViewById(R.id.clickButtom)

        clickButton.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val peso: Float = edtPeso.text.toString().toFloat()
                val altura: Float = edtAltura.text.toString().toFloat()

                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal

                val intent = Intent(this, Result_Activity::class.java).apply {
                    putExtra("EXTRA_RESULT", result)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}