package com.tngen.hilttest.domain.repository

import com.tngen.hilttest.data.model.HouseModel

interface HouseRepository {
    suspend fun getHouse() : HouseModel
}