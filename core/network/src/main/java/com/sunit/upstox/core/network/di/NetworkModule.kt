package com.sunit.upstox.core.network.di

import com.sunit.upstox.core.network.BuildConfig
import com.sunit.upstox.core.network.retrofit.UpstoxApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://56c70a06e06e498fbf06437e72fa7258.api.mockbin.io/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun provideJsonSerializer(): Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        json: Json,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideUpstoxApi(
        retrofit: Retrofit
    ): UpstoxApi {
        return retrofit.create(UpstoxApi::class.java)
    }
}
