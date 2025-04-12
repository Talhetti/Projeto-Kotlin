package com.github.alvaro.projetobloconotas.TELAS

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.alvaro.projetobloconotas.R
import android.view.View

class ViewNoteActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var notasAdapter: NotasAdapter
    private val notasList = mutableListOf<String>() // Lista de notas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_nota)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        notasAdapter = NotasAdapter(notasList)
        recyclerView.adapter = notasAdapter

        // Recupera a lista de notas da intent
        val listaNotas = intent.getStringArrayListExtra("notas") ?: ArrayList()
        notasList.addAll(listaNotas)
        notasAdapter.notifyDataSetChanged()

        findViewById<View>(R.id.meuBotao).setOnClickListener {
            // Passa as notas atuais para a próxima tela
            val intent = Intent(this, EditNoteActivity::class.java)
            intent.putStringArrayListExtra("notas", ArrayList(notasList))
            startActivity(intent)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val novaNota = data?.getStringExtra("nota")
            novaNota?.let {
                notasList.add(it)
                notasAdapter.notifyDataSetChanged()
            }
        }
    }
}
