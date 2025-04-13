package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.alvaro.projetobloconotas.R
import com.github.alvaro.projetobloconotas.data.AppDatabase
import com.github.alvaro.projetobloconotas.data.Nota
import kotlinx.coroutines.launch

class ViewNoteActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notasAdapter: NotasAdapter
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_nota)

        db = AppDatabase.getDatabase(applicationContext)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        notasAdapter = NotasAdapter(listOf())
        recyclerView.adapter = notasAdapter

        // Carrega as notas do banco de dados
        lifecycleScope.launch {
            val listaNotas = db.notaDao().getAllNotas()
            notasAdapter = NotasAdapter(listaNotas.map { it.conteudo }) // Mapeia as notas para exibir o conteúdo
            recyclerView.adapter = notasAdapter
        }

        findViewById<View>(R.id.meuBotao).setOnClickListener {
            val intent = Intent(this, EditNoteActivity::class.java)
            startActivity(intent)
        }
    }
}
