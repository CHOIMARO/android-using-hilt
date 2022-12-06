package com.tngen.domain.repository

import com.tngen.domain.model.HouseModel

interface HouseRepository {
    suspend fun getHouse() : HouseModel
}