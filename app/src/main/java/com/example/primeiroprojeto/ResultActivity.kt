package com.example.primeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()


         var classificacao = if (result < 18.5) {
            "ABAIXO DO PESO"
        } else if (result in 18.5..24.9){
             "NORMAL"
        } else if (result > 25 && result <=29.9){
            "SOBREPESO"
        } else if (result > 30 && result <= 39.9){
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}