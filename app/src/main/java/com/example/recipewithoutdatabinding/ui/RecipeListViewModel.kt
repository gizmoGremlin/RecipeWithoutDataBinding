package com.example.recipewithoutdatabinding.ui


import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.recipewithoutdatabinding.R
import com.example.recipewithoutdatabinding.RecipeApi
import com.example.recipewithoutdatabinding.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipeListViewModel : BaseViewModel() {
    @Inject
    lateinit var recipeApi: RecipeApi
    val loadingVisibility : MutableLiveData<Int> = MutableLiveData()
    private lateinit var subscription: Disposable
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadRecipes() }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    init {
        loadRecipes()
    }

    private fun loadRecipes() {
        subscription = recipeApi.searchRecipies("deer","c3f86cd2",

                    "4f3347598c67bddaab8183119f5fcc61",
            1,2)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveRecipeListStart() }
            .doOnTerminate { onRetrieveRecipeListFinish() }
            .subscribe(
                { onRetrieveRecipeListSuccess() },
                { onRetrieveRecipeListError() }
            )
    }




    private fun onRetrieveRecipeListSuccess() {

    }

    private fun onRetrieveRecipeListFinish() {
        loadingVisibility.value = View.GONE
        Log.d("viewmodel+++++","finished======")
    }

    private fun onRetrieveRecipeListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value =null
        Log.d("viewmodel+++++","Started======")
    }
    private fun onRetrieveRecipeListError(){

        errorMessage.value =R.string.Error
    }

}
