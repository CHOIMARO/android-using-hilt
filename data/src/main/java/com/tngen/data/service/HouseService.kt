package com.tngen.data.service

import com.tngen.domain.model.HouseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HouseService {
    @GET("/v3/511c37d3-79c1-455f-9efb-98b5d594e640")
    suspend fun getHouseList() : Response<HouseModel>
}