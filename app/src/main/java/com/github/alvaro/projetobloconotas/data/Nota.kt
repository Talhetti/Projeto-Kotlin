package com.github.alvaro.projetobloconotas.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notas")
data class Nota(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "titulo")
    val titulo: String,

    @ColumnInfo(name = "conteudo")
    val conteudo: String,

    @ColumnInfo(name = "dataCriacao")
    val dataCriacao: String,

    @ColumnInfo(name = "dataUltimaModificacao")
    val dataUltimaModificacao: String
)