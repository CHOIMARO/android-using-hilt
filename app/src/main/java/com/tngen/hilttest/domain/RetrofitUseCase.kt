package com.tngen.hilttest.domain

import android.util.Log
import com.tngen.hilttest.data.repository.HouseRepositoryImpl
import com.tngen.hilttest.domain.repository.HouseRepository
import javax.inject.Inject

class RetrofitUseCase
@Inject constructor(
    private val houseRepository: HouseRepository
){
    suspend fun execute(){
        Log.d("RetrofitUseCase","${houseRepository.getHouse().items.count()}" )
    }
}