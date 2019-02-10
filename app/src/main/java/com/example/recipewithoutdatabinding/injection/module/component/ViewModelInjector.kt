package com.example.recipewithoutdatabinding.injection.module.component

import com.example.recipewithoutdatabinding.injection.module.NetworkModule
import com.example.recipewithoutdatabinding.ui.RecipeListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(recipeListViewMode : RecipeListViewModel)


    @Component.Builder
    interface Builder {
        fun build() : ViewModelInjector

        fun NetworkModule(networkModule : NetworkModule): Builder
    }
}
