package com.sambudisp.mvvmsample.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIs  {

    @FormUrlEncoded
    @POST(" login")
    fun login(
        @Field("email") email : String,
        @Field("password") password : String
    ) : Call<ResponseBody>

    companion object{
        operator fun invoke() : APIs{
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIs::class.java)
        }
    }
}