package com.example.furniture.data.remote

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RoomDao {
/*    //WishListDao
    @Query("SELECT * FROM ProductDetails")
    fun loadProducts(): LiveData<List<DataX>>

    @Query("SELECT * FROM ProductDetails")
    fun loadProductss(): List<DataX>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductFav(product: DataX): Long

    @Delete
    suspend fun deleteProductFav(product: DataX?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateProduct(product: DataX?)

    @Query("SELECT * FROM ProductDetails WHERE name = :name")
    fun fetchById(name: String?): DataX?

    @Query("DELETE FROM ProductDetails")
    suspend fun deleteAll()

    //cart
    @Query("SELECT * FROM CartTable")
    fun loadDataInCart(): LiveData<List<CartDataEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insertInCart(product: CartDataEntity): Long

    @Delete
    suspend fun deleteFromCart(product: CartDataEntity?)


    @Query("SELECT * FROM CartTable WHERE name = :name")
    fun fetchCartItemById(name: String?): CartDataEntity?

    @Query("DELETE FROM CartTable")
    suspend fun deleteAllCart()*/


}
