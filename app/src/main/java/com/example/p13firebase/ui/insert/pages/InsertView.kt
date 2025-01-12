package com.example.p13firebase.ui.insert.pages

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p13firebase.ui.PenyediaViewModel
import com.example.p13firebase.ui.insert.viewmodel.InsertViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertView (
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
}