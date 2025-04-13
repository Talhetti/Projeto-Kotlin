package com.github.alvaro.projetobloconotas.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotaDao {
    @Insert
    suspend fun insert(nota: Nota)

    @Update
    suspend fun update(nota: Nota)

    @Delete
    suspend fun delete(nota: Nota)

    @Query("SELECT * FROM notas")
    suspend fun getAllNotas(): List<Nota>

    @Query("SELECT * FROM notas WHERE id = :id")
    suspend fun getNotaById(id: Int): Nota?
}