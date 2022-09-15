package com.tngen.hilttest.data.repository

import com.tngen.hilttest.data.model.HouseModel
import com.tngen.hilttest.data.service.HouseService
import com.tngen.hilttest.domain.repository.HouseRepository
import javax.inject.Inject

class HouseRepositoryImpl @Inject constructor(
    private val houseService: HouseService
) : HouseRepository {
    override suspend fun getHouse() : HouseModel {
        val response = houseService.getHouseList()
        return if(response.isSuccessful) response.body() as HouseModel else HouseModel(ArrayList())
    }
}