package com.example.furniture.ui.fragment.home

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.furniture.data.entity.Data
import com.example.furniture.data.entity.HomeModel
import com.example.furniture.data.remote.RoomDao
import com.example.furniture.domain.IHomeRepo
import com.example.furniture.domain.showAllHome
import com.example.furniture.util.NetworkConnectivity
import com.example.furniture.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var room: RoomDao,
     var repo: IHomeRepo,
) : ViewModel() {

    private lateinit var context: Context

    var offersList: MutableLiveData<Resource<Data>> = MutableLiveData()
    var offersResponse: Data? = null



    fun setActivity(context: Context) {
        this.context = context
    }


     fun getOffers(): MutableLiveData<Resource<Data>> {
         offersList.postValue(Resource.Loading())
        try {
            if (NetworkConnectivity.hasInternetConnection(context)) {
                viewModelScope.launch {
                    val response = showAllHome(repo)
                    offersList.postValue(response?.let { handleResponse(it) })
                }
            } else {
                offersList.postValue(Resource.Error("No internet connection"))

            }

        } catch (e: Exception) {
            Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
            when (e) {
                is IOException -> offersList.postValue(Resource.Error("Network Failure"))
                else -> offersList.postValue(Resource.Error("Conversion Error"))
            }
        }


        return offersList
    }

    private fun handleResponse(response: Response<HomeModel>): Resource<Data> {
        if (response.isSuccessful) {
            response.body().let { it ->
                if (offersResponse == null) {
                    if (it != null) {
                        offersResponse = it.data
                    }
                }

                return offersResponse?.let { it1 -> Resource.Success(it1) }!!
            }

        } else return Resource.Error(response.message())

    }
}