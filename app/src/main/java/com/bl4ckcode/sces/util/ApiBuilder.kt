package com.bl4ckcode.sces.util

import com.bl4ckcode.sces.ui.login.network.LoginRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiBuilder {
    companion object {
        fun <T : Any> create(apiClass: Class<T>, withKey: String? = null): T {
            val client = OkHttpClient.Builder()
            val interceptor = HttpLoggingInterceptor()

            interceptor.level = HttpLoggingInterceptor.Level.BODY

            withKey?.let {
                client.addInterceptor(apiKeyHeader(it))
            }

            client.addNetworkInterceptor(interceptor)

            return Retrofit.Builder()
                .baseUrl(LoginRepository.BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(apiClass)
        }

        private fun apiKeyHeader(key: String): Interceptor {
            return Interceptor { chain ->
                val original: Request = chain.request()
                val requestBuilder: Request.Builder = original.newBuilder()
                    .header("Authorization", "Token $key")
                val request: Request = requestBuilder.build()

                chain.proceed(request)
            }
        }
    }
}