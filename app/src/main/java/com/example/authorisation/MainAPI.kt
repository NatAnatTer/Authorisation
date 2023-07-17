package com.example.authorisation

import retrofit2.http.Body
import retrofit2.http.POST

interface MainAPI {
//    @GET("login")
//   suspend fun getAuthorization(): User

    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): User

}