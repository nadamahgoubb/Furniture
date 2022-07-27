package com.example.furniture.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class HomeModel(

    @SerializedName("data") var data: Data? = Data(),
    @SerializedName("message") var message: String? ,
    @SerializedName("status") var status: Boolean? 

)

data class Data(

    @SerializedName("categories") var categories: ArrayList<Categories> = arrayListOf(),
    @SerializedName("offers") var offers: ArrayList<Offers> = arrayListOf(),
    @SerializedName("saves") var saves: ArrayList<String> = arrayListOf(),
    @SerializedName("discounts") var discounts: ArrayList<Discounts> = arrayListOf(),
    @SerializedName("branch_type") var branchType: ArrayList<BranchType> = arrayListOf()

)

data class BranchType(

    @SerializedName("id") var id: Int? ,
    @SerializedName("branch_type_id") var branchTypeId: Int? ,
    @SerializedName("image") var image: String? ,
    @SerializedName("name") var name: String? ,
    @SerializedName("count") var count: Int? 

)

data class Categories(

    @SerializedName("id") var id: Int? ,
    @SerializedName("category_id") var categoryId: Int? ,
    @SerializedName("code") var code: String? ,
    @SerializedName("image") var image: String? ,
    @SerializedName("name") var name: String? ,
    @SerializedName("count") var count: Int? 

)

data class Discounts(

    @SerializedName("id") var id: Int? ,
    @SerializedName("discount_id") var discountId: Int? ,
    @SerializedName("price_before") var priceBefore: Int? ,
    @SerializedName("price_after") var priceAfter: Int? ,
    @SerializedName("percent") var percent: Int? ,
    @SerializedName("product_name") var productName: String? ,
    @SerializedName("product_description") var productDescription: String? ,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("furniture_id") var furnitureId: Int? ,
    @SerializedName("furniture_name") var furnitureName: String? ,
    @SerializedName("furniture_logo") var furnitureLogo: String? ,
    @SerializedName("rate") var rate: Int? ,
    @SerializedName("rate_count") var rateCount: Int? ,
    @SerializedName("model_type") var modelType: String? ,
    @SerializedName("qty_cart") var qtyCart: String? 

)
@Entity(tableName = "offers")

data class Offers(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int? ,
    @SerializedName("offer_id") var offerId: Int? ,
    @SerializedName("name") var name: String? ,
    @SerializedName("price") var price: Int? ,
    @SerializedName("video") var video: String? ,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("furniture_id") var furnitureId: Int? ,
    @SerializedName("furniture_name") var furnitureName: String? ,
    @SerializedName("furniture_logo") var furnitureLogo: String? ,
  //  @SerializedName("products") var products: ArrayList<Products> = arrayListOf(),
    @SerializedName("rate") var rate: Int? ,
    @SerializedName("rate_count") var rateCount: Int? ,
    @SerializedName("model_type") var modelType: String? ,
    @SerializedName("qty_cart") var qtyCart: String? 

)

data class Products(

    @SerializedName("product_id") var productId: Int? ,
    @SerializedName("quantity") var quantity: Int? ,
    @SerializedName("product") var product: String? ,
    @SerializedName("icon") var icon: String? 

)

data class Images(

    @SerializedName("id") var id: Int? ,
    @SerializedName("path_id") var pathId: Int? ,
    @SerializedName("path") var path: String? 

)