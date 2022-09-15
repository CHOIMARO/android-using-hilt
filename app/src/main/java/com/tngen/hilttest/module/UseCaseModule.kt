package com.tngen.hilttest.module

import com.tngen.hilttest.domain.repository.NoteRepository
import com.tngen.hilttest.domain.HiltUseCase
import com.tngen.hilttest.domain.RetrofitUseCase
import com.tngen.hilttest.domain.repository.HouseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideHiltUseCase(repository: NoteRepository) = HiltUseCase(repository)

    @Singleton
    @Provides
    fun provideRetrofitUseCase(repository: HouseRepository) = RetrofitUseCase(repository)
}