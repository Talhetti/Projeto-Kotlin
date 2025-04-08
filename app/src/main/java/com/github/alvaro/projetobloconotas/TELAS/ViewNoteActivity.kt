package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.alvaro.projetobloconotas.R

class ViewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_nota)

        val botaoAdicionarNota: View = findViewById(R.id.meuBotao)
        botaoAdicionarNota.setOnClickListener {
            val intent = Intent(this, EditNoteActivity::class.java)
            startActivity(intent)
        }

    }
}
