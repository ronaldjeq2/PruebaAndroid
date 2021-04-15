package com.example.prueba.Domain.service;

import com.example.prueba.Data.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyApiService {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> postLogin(
            @Field("user") String username,
            @Field("password") String password
    );

}
