package com.example.apiapp.network

import com.example.apiapp.data.Volume
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//  'https://books.googleapis.com/books/v1/volumes?q=warbreaker&maxResults=10&printType=BOOKS'

const val BASE_URL = "https://books.googleapis.com/books/v1/"
const val QUERY_PARAM = "q"
const val MAX_RESULTS = "maxResults"
const val PRINT_TYPE = "printType"

val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//used for outlines where I have the idea but not know how to do it and their is no objects of interface
interface BookApiService {
    @GET("volumes") // todo verify question mark presence
    suspend fun getBooks(
        @Query(QUERY_PARAM)
        query: String,
        @Query(MAX_RESULTS)
        results: String,
        @Query(PRINT_TYPE)
        type: String,
    ): Volume
}

object BookApi{
    val retrofitService: BookApiService by lazy{
        retrofit.create(BookApiService::class.java   )
    }
}