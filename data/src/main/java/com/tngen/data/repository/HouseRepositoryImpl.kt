package com.tngen.data.repository

import com.tngen.domain.model.HouseModel
import com.tngen.domain.repository.HouseRepository
import com.tngen.data.service.HouseService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
/**
 * */
class HouseRepositoryImpl @Inject constructor(
    private val houseService: HouseService,
    private val ioDispatcher: CoroutineDispatcher
) : HouseRepository {
    override suspend fun getHouse() : HouseModel = withContext(ioDispatcher) {
        val response = houseService.getHouseList()
        return@withContext if(response.isSuccessful) response.body() as HouseModel else HouseModel(ArrayList())
    }
}