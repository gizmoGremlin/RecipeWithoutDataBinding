package com.example.recipewithoutdatabinding

import org.junit.BeforeClass

abstract class BaseTestCase{

    companion object {
        lateinit var service: RecipeApi

    }

    init {
        @BeforeClass
        service = RecipeApi.create()
    }
    var staticService = service


}