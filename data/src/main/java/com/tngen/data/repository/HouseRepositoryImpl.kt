package com.tngen.data.repository

import com.tngen.domain.model.HouseModel
import com.tngen.domain.repository.HouseRepository
import com.tngen.data.service.HouseService
import javax.inject.Inject
/**
 * */
class HouseRepositoryImpl @Inject constructor(
    private val houseService: HouseService
) : HouseRepository {
    override suspend fun getHouse() : HouseModel {
        val response = houseService.getHouseList()
        return if(response.isSuccessful) response.body() as HouseModel else HouseModel(ArrayList())
    }
}