package com.example.recipewithoutdatabinding.injection.module

import com.example.recipewithoutdatabinding.RecipeApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val baseUrl = "https://api.edamam.com/"
// Provides all network dependances
@Module

@Suppress("unused")
object NetworkModule{

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRecpieApi(retrofit: Retrofit):RecipeApi{
        return retrofit.create(RecipeApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface():Retrofit{
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttppClient = OkHttpClient.Builder().addInterceptor(logger)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttppClient.build()).build()

    }


}


