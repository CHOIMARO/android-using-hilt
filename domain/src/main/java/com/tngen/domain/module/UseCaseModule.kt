package com.tngen.domain.module

import com.tngen.domain.HiltUseCase
import com.tngen.domain.RetrofitUseCase
import com.tngen.domain.repository.HouseRepository
import com.tngen.domain.repository.NoteRepository
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