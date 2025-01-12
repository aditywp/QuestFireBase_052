package com.example.p13firebase.ui.insert.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p13firebase.repository.RepositoryMhs

class InsertViewModel (
    private val mhs: RepositoryMhs
): ViewModel() {
}

data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jenisKelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)