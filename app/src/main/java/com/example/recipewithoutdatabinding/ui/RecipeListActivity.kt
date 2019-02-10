package com.example.recipewithoutdatabinding.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.LifecycleOwner


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.recipewithoutdatabinding.R
import com.google.android.material.snackbar.Snackbar

class RecipeListActivity : AppCompatActivity(){
  //  private

    private lateinit var viewModel: RecipeListViewModel
    private var errorSnackbar: Snackbar? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        var progressbar : ProgressBar = findViewById(R.id.recipe_list_progressbar)
        viewModel = ViewModelProviders.of(this).get(RecipeListViewModel::class.java)
        var recyclerView : RecyclerView = findViewById(R.id.recipe_list_recyclerview)
        val visibility =viewModel.loadingVisibility
        progressbar.progress = visibility.value?: View.GONE

        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })



    }

    private fun hideError() {
        errorSnackbar?.dismiss()

    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(findViewById(R.id.coodinator_layout), errorMessage,Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()


    }
}