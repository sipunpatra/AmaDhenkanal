package com.dhenkanal.amadhenkanal.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhenkanal.amadhenkanal.model.StoryItem
import com.dhenkanal.amadhenkanal.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel(){
    private val _stories = MutableLiveData<List<StoryItem>>()
    val stories: LiveData<List<StoryItem>> get() = _stories

    fun fetchStories() {
        viewModelScope.launch {
            try {
                val response = repository.getStories()
                _stories.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}