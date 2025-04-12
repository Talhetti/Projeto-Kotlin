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

        val inputNota = findViewById<EditText>(R.id.inputNota)
        val buttonOk = findViewById<Button>(R.id.button2)

        // Recupera as notas anteriores da intent (caso existam)
        val notasAnteriores = intent.getStringArrayListExtra("notas") ?: ArrayList()

        buttonOk.setOnClickListener {
            val textoNota = inputNota.text.toString()
            if (textoNota.isNotBlank()) {
                notasAnteriores.add(textoNota)

                // Envia a lista de notas atualizada para a ViewNoteActivity
                val intent = Intent(this, ViewNoteActivity::class.java)
                intent.putStringArrayListExtra("notas", notasAnteriores)
                startActivity(intent)
            }
        }
    }
}
