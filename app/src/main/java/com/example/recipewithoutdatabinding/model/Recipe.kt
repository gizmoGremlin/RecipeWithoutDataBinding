package com.example.recipewithoutdatabinding.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



    @Entity(tableName = "recipe_data")
    data class RecipeData(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val recipeDataId: Int,
        val count: Int,
        val from: Int,
        val hits: List<Hit>,
        val more: Boolean,
        val params: Params,
        val q: String,
        val to: Int
    )

    data class Params(
        val app_id: List<String>,
        val app_key: List<String>,
        val from: List<String>,
        val q: List<String>,
        val sane: List<Any>,
        val to: List<String>
    )

    @Entity(tableName = "hits")
    data class Hit(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "hits") val hitId: Int,
        val bookmarked: Boolean,
        val bought: Boolean,
        val recipe: Recipe
    )

    @Entity(tableName = "recipe")
    data class Recipe(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val recipeId: Int,
        val calories: Double,
        val cautions: List<Any>,
        val dietLabels: List<Any>,
        val digest: List<Digest>,
        val healthLabels: List<String>,
        val image: String,
        val ingredientLines: List<String>,
        val ingredients: List<Ingredient>,
        val label: String,
        val shareAs: String,
        val source: String,
        val totalDaily: TotalDaily,
        val totalNutrients: TotalNutrients,
        val totalTime: Double,
        val totalWeight: Double,
        val uri: String,
        val url: String,
        val yield: Double
    )


data class TotalNutrients(
    val CA: CA,
    val CHOCDF: CHOCDF,
    val CHOLE: CHOLE,
    val ENERC_KCAL: ENERCKCAL,
    val FAMS: FAMS,
    val FAPU: FAPU,
    val FASAT: FASAT,
    val FAT: FAT,
    val FE: FE,
    val FIBTG: FIBTG,
    val FOLDFE: FOLDFE,
    val FOLFD: FOLFD,
    val K: K,
    val MG: MG,
    val NA: NA,
    val NIA: NIA,
    val P: P,
    val PROCNT: PROCNT,
    val RIBF: RIBF,
    val SUGAR: SUGAR,
    // val SUGAR.added: SUGARadded,
    val THIA: THIA,
    val TOCPHA: TOCPHA,
    val VITA_RAE: VITARAE,
    val VITB12: VITB12,
    val VITB6A: VITB6A,
    val VITC: VITC,
    val VITK1: VITK1,
    val ZN: ZN
)

data class P(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class VITB6A(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class CHOLE(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FE(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FOLFD(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class ENERCKCAL(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class SUGARadded(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class PROCNT(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class CA(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class CHOCDF(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FAT(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class NIA(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class VITB12(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FAPU(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FASAT(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class ZN(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class VITK1(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class NA(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FAMS(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class K(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class MG(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FIBTG(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class VITC(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class RIBF(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class TOCPHA(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class FOLDFE(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class THIA(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class SUGAR(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class VITARAE(
    val label: String,
    val quantity: Double,
    val unit: String
)

data class Digest(
    val daily: Double,
    val hasRDI: Boolean,
    val label: String,
    val schemaOrgTag: Any,
    val sub: List<Sub>,
    val tag: String,
    val total: Double,
    val unit: String
)

data class Sub(
    val daily: Double,
    val hasRDI: Boolean,
    val label: String,
    val schemaOrgTag: Any,
    val tag: String,
    val total: Double,
    val unit: String
)

data class Ingredient(
    val text: String,
    val weight: Double
)

data class TotalDaily(
    val CA: CA,
    val CHOCDF: CHOCDF,
    val CHOLE: CHOLE,
    val ENERC_KCAL: ENERCKCAL,
    val FASAT: FASAT,
    val FAT: FAT,
    val FE: FE,
    val FIBTG: FIBTG,
    val FOLDFE: FOLDFE,
    val K: K,
    val MG: MG,
    val NA: NA,
    val NIA: NIA,
    val P: P,
    val PROCNT: PROCNT,
    val RIBF: RIBF,
    val THIA: THIA,
    val TOCPHA: TOCPHA,
    val VITA_RAE: VITARAE,
    val VITB12: VITB12,
    val VITB6A: VITB6A,
    val VITC: VITC,
    val VITK1: VITK1,
    val ZN: ZN )
