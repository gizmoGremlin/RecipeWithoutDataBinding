package com.example.recipewithoutdatabinding.base

import androidx.lifecycle.ViewModel
import com.example.recipewithoutdatabinding.injection.module.NetworkModule
import com.example.recipewithoutdatabinding.injection.module.component.DaggerViewModelInjector
import com.example.recipewithoutdatabinding.injection.module.component.ViewModelInjector
import com.example.recipewithoutdatabinding.ui.RecipeListViewModel

abstract class BaseViewModel:ViewModel(){

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .NetworkModule(NetworkModule)
        .build()


    init {
        inject()
    }

    private fun inject() {
        when (this){
            is RecipeListViewModel -> injector.inject(this)
        }
    }
}