package com.example.furniture.data.entity

import com.google.gson.annotations.SerializedName

data class HomeModel(

    @SerializedName("data") var data: Data? = Data(),
    @SerializedName("message") var message: String? = null,
    @SerializedName("status") var status: Boolean? = null

)

data class Data(

    @SerializedName("categories") var categories: ArrayList<Categories> = arrayListOf(),
    @SerializedName("offers") var offers: ArrayList<Offers> = arrayListOf(),
    @SerializedName("saves") var saves: ArrayList<String> = arrayListOf(),
    @SerializedName("discounts") var discounts: ArrayList<Discounts> = arrayListOf(),
    @SerializedName("branch_type") var branchType: ArrayList<BranchType> = arrayListOf()

)

data class BranchType(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("branch_type_id") var branchTypeId: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("count") var count: Int? = null

)

data class Categories(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("category_id") var categoryId: Int? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("count") var count: Int? = null

)

data class Discounts(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("discount_id") var discountId: Int? = null,
    @SerializedName("price_before") var priceBefore: Int? = null,
    @SerializedName("price_after") var priceAfter: Int? = null,
    @SerializedName("percent") var percent: Int? = null,
    @SerializedName("product_name") var productName: String? = null,
    @SerializedName("product_description") var productDescription: String? = null,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("furniture_id") var furnitureId: Int? = null,
    @SerializedName("furniture_name") var furnitureName: String? = null,
    @SerializedName("furniture_logo") var furnitureLogo: String? = null,
    @SerializedName("rate") var rate: Int? = null,
    @SerializedName("rate_count") var rateCount: Int? = null,
    @SerializedName("model_type") var modelType: String? = null,
    @SerializedName("qty_cart") var qtyCart: String? = null

)

data class Offers(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("offer_id") var offerId: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("video") var video: String? = null,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("furniture_id") var furnitureId: Int? = null,
    @SerializedName("furniture_name") var furnitureName: String? = null,
    @SerializedName("furniture_logo") var furnitureLogo: String? = null,
    @SerializedName("products") var products: ArrayList<Products> = arrayListOf(),
    @SerializedName("rate") var rate: Int? = null,
    @SerializedName("rate_count") var rateCount: Int? = null,
    @SerializedName("model_type") var modelType: String? = null,
    @SerializedName("qty_cart") var qtyCart: String? = null

)

data class Products(

    @SerializedName("product_id") var productId: Int? = null,
    @SerializedName("quantity") var quantity: Int? = null,
    @SerializedName("product") var product: String? = null,
    @SerializedName("icon") var icon: String? = null

)

data class Images(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("path_id") var pathId: Int? = null,
    @SerializedName("path") var path: String? = null

)