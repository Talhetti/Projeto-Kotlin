package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.github.alvaro.projetobloconotas.R

class EditNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_nota)

        // Referência ao EditText onde o usuário digita a nota
        val inputNota = findViewById<EditText>(R.id.inputNota)
        val buttonOk = findViewById<Button>(R.id.button2)

        buttonOk.setOnClickListener {
            val textoNota = inputNota.text.toString()

            val intent = Intent(this, ViewNoteActivity::class.java)
            intent.putExtra("nota", textoNota) // envia a nota para a próxima tela
            startActivity(intent)
        }
    }
}
