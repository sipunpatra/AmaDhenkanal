package com.dhenkanal.amadhenkanal.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dhenkanal.amadhenkanal.repository.MainRepository
import com.dhenkanal.amadhenkanal.viewModel.MainViewModel

class MainViewModelFactory(private val repository: MainRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}