package com.example.daggerexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerexample.models.Product
import com.example.daggerexample.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productsLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}