package info.sanaebadi.data.networking.base

import info.sanaebadi.data.networking.retrofit.PlaceApiRetrofitService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://tapsi.ir/api/v1/"

object ApiServiceClient {

    fun getClient(): PlaceApiRetrofitService {
        val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlaceApiRetrofitService::class.java)


    }

}