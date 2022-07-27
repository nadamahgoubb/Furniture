package com.example.furniture.data.local

import androidx.room.TypeConverter
import com.example.furniture.data.entity.Images
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class  Converter {
    @TypeConverter
    fun restoreList(listOfString: String?): List<String?>? {
        return Gson().fromJson(listOfString, object : TypeToken<List<String?>?>() {}.type)
    }

    @TypeConverter
    fun saveList(listOfString: List<String?>?): String? {
        return Gson().toJson(listOfString)
    }
    @TypeConverter
    fun restoreListImages(listOfString: String?): List<Images?>? {
        return Gson().fromJson(listOfString, object : TypeToken<List<Images?>?>() {}.type)
    }

    @TypeConverter
    fun saveListImages(listOfString: List<Images?>?): String? {
        return Gson().toJson(listOfString)
    }
}