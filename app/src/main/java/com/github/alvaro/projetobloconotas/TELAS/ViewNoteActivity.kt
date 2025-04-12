package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.alvaro.projetobloconotas.R

class ViewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_nota)

        // Recupera o texto da anotação enviado pela tela anterior
        val notaRecebida = intent.getStringExtra("nota")

        // Referência ao TextView que irá exibir a nota
        val textoNota = findViewById<TextView>(R.id.textoNota)
        textoNota.text = notaRecebida ?: "Nenhuma nota recebida."

        // Botão para editar uma nova nota
        val botaoAdicionarNota: View = findViewById(R.id.meuBotao)
        botaoAdicionarNota.setOnClickListener {
            val intent = Intent(this, EditNoteActivity::class.java)
            startActivity(intent)
        }
    }
}
