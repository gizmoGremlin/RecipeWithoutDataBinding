package com.example.recipewithoutdatabinding.ui

import androidx.lifecycle.MutableLiveData
import com.example.recipewithoutdatabinding.base.BaseViewModel
import com.example.recipewithoutdatabinding.model.Hit
import com.example.recipewithoutdatabinding.model.Recipe
import com.example.recipewithoutdatabinding.model.RecipeData


class RecipeViewModel : BaseViewModel(){
    private val recipeLabel = MutableLiveData<String>()
    private val recipeIngredients = MutableLiveData<String>()
   fun bind(recipe: Recipe){
       ///change to hits recipe
       val temp : String =""
       recipe.ingredientLines.forEach { item -> temp.plus(" " +item + ", ") }
      recipeLabel.value = recipe.label
       recipeIngredients.value = temp
    }
    fun getRecipeTitle():MutableLiveData<String>{
        return recipeLabel
    }

    fun getRecipeIngredients():MutableLiveData<String>{
        return recipeIngredients
    }

}