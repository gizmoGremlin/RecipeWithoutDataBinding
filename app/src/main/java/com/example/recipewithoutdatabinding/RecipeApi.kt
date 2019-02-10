package com.example.recipewithoutdatabinding

import androidx.room.Dao
import com.example.recipewithoutdatabinding.model.Hit

import com.example.recipewithoutdatabinding.model.Recipe
import com.example.recipewithoutdatabinding.model.RecipeData
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

val baseUrl = "https://api.edamam.com/"

interface RecipeApi{
    // curl ="https://api.edamam.com/search?q=chicken&app_id=${YOUR_APP_ID}&app_key=${YOUR_APP_KEY}&from=0&to=3&calories=591-722&health=alcohol-free"
    @GET("search")
    fun searchRecipies(@Query("q") searchTerm:String,@Query("app_id") appId:String,
                       @Query("app_key") appKey:String,@Query("from") from:Int,@Query("to") to:Int) :Observable<List<Recipe>>


//    companion object {
//        fun create() : RecipeApi {
//
//            val retrofit = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(baseUrl)
//                .build()
//
//
//            return retrofit.create(RecipeApi::class.java)
//        }
//    }



}
