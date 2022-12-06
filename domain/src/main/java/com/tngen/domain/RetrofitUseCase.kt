package com.tngen.domain

import android.util.Log
import com.tngen.domain.repository.HouseRepository
import javax.inject.Inject

class RetrofitUseCase
@Inject constructor(
    private val houseRepository: HouseRepository
){ //Retrofit을 사용하여 접속하기, 데이터 가져오기
    suspend fun execute(){
        Log.d("RetrofitUseCase","${houseRepository.getHouse().items.count()}" )
    }
}