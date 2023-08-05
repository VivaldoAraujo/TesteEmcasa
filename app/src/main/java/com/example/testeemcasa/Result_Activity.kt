package com.example.testeemcasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class Result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvresult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT",0.01f)

        tvresult.text = result.toString()

        var classificacao = "Classificacao: "
        classificacao += if(result < 18.5f){
            "ABAIXO DO PESO"
        }else if(result in 18.5f..24.9f){
            "NORMAL"
        }else if(result in 25f..29.9f){
            "SOBRE PESO"
        }else if (result in 30f..39.9f){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }
        tvClassificacao.text = classificacao
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}