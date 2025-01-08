package com.example.p13firebase.di

import com.example.p13firebase.repository.NetworkRepositoryMhs
import com.example.p13firebase.repository.RepositoryMhs
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer{
    val repositoryMhs: RepositoryMhs
}

class MahasiswaContainer : AppContainer {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repositoryMhs: RepositoryMhs by lazy {
        NetworkRepositoryMhs(firestore)
    }
}