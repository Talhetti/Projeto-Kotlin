package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.alvaro.projetobloconotas.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val button: View = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ViewNoteActivity::class.java)
            startActivity(intent)
        }
    }
}