package com.example.p13firebase.repository

import com.example.p13firebase.model.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)

    suspend fun deleteMhs(mahasiswa: Mahasiswa)

    suspend fun updateMhs(mahasiswa: Mahasiswa)

    fun getAllMhs(): Flow<List<Mahasiswa>>

    fun getMhs(nim: String): Flow<Mahasiswa>
}