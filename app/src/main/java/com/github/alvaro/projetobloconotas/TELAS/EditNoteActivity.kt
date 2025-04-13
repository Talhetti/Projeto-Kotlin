package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.alvaro.projetobloconotas.R
import com.github.alvaro.projetobloconotas.data.AppDatabase
import com.github.alvaro.projetobloconotas.data.Nota
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class EditNoteActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_nota)

        db = AppDatabase.getDatabase(applicationContext)

        val inputNota = findViewById<EditText>(R.id.inputNota)
        val buttonOk = findViewById<Button>(R.id.button2)

        // Recupera a nota a ser editada, se for o caso
        val idNota = intent.getIntExtra("notaId", -1)
        if (idNota != -1) {
            lifecycleScope.launch {
                val nota = db.notaDao().getNotaById(idNota)
                if (nota != null) {
                    inputNota.setText(nota.conteudo)
                }
            }
        }

        buttonOk.setOnClickListener {
            val textoNota = inputNota.text.toString()
            if (textoNota.isNotBlank()) {
                val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

                lifecycleScope.launch {
                    if (idNota != -1) {
                        // Atualiza a nota existente
                        val nota = Nota(id = idNota, titulo = "Título da Nota", conteudo = textoNota, dataCriacao = dataAtual, dataUltimaModificacao = dataAtual)
                        db.notaDao().update(nota)
                    } else {
                        // Cria uma nova nota
                        val novaNota = Nota(titulo = "Título da Nota", conteudo = textoNota, dataCriacao = dataAtual, dataUltimaModificacao = dataAtual)
                        db.notaDao().insert(novaNota)
                    }

                    // Redireciona para a tela de visualização de notas
                    val intent = Intent(this@EditNoteActivity, ViewNoteActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
