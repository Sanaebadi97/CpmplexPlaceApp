package info.sanaebadi.data.networking.base

import info.sanaebadi.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class AbstractService<S> {
    private var service: S
    private var serviceType: Class<S>

    constructor(
        serviceType: Class<S>
    ) {
        this.serviceType = serviceType
        service = createService(BuildConfig.API_BASE_URL)
    }

    constructor(
        serviceType: Class<S>, baseUrl: String
    ) {
        this.serviceType = serviceType
        service = createService(baseUrl)
    }

    fun setBaseUrl(baseUrl: String) {
        service = createService(baseUrl)
    }


    private fun createService(baseUrl: String): S {

        val client = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT_MIL_SECS, TimeUnit.SECONDS)
            .build()
        val retrofitBuilder = Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
        return retrofitBuilder.client(client).build().create(serviceType)
    }


    companion object {
        private const val AUTHORIZATION_KEY = "Authorization"
        private const val TIME_OUT_MIL_SECS = 60L
    }
}