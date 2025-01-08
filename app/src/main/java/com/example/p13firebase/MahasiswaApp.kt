package com.example.p13firebase

import android.app.Application
import com.example.p13firebase.di.MahasiswaContainer

class MahasiswaApp: Application() {
    lateinit var container: MahasiswaContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}