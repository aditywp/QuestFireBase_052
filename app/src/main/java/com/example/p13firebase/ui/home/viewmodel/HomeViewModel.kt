package com.example.p13firebase.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p13firebase.model.Mahasiswa
import com.example.p13firebase.repository.RepositoryMhs
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repositoryMhs: RepositoryMhs
) : ViewModel() {
    var mhsUiState: HomeuiState by mutableStateOf((HomeuiState.Loading))
        private set

    init {
        getMhs()
    }

    fun getMhs(){
        viewModelScope.launch {
            repositoryMhs.getAllMhs()
                .onStart {
                    mhsUiState = HomeuiState.Loading
                }
                .catch {
                    mhsUiState = HomeuiState.Error(e = it)
                }
                .collect{
                    mhsUiState = if (it.isEmpty()) {
                        HomeuiState.Error(Exception("Belum ada data mahasiswa"))
                    } else {
                        HomeuiState.Success(it)
                    }
                }
        }
    }

    fun deleteMhs(mahasiswa: Mahasiswa){
        viewModelScope.launch {
            try {
                repositoryMhs.deleteMhs(mahasiswa)
            } catch (e: Exception){
                mhsUiState = HomeuiState.Error(e)
            }
        }
    }
}


sealed class HomeuiState{
    object Loading : HomeuiState()

    data class Success(val data: List<Mahasiswa>) : HomeuiState()

    data class Error(val e: Throwable) : HomeuiState()
}