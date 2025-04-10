package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.alvaro.projetobloconotas.R

class EditNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_nota)


        val buttonOk = findViewById<Button>(R.id.button2)

        buttonOk.setOnClickListener {
            val intent = Intent(this, ViewNoteActivity::class.java)
            startActivity(intent)
        }
    }
}