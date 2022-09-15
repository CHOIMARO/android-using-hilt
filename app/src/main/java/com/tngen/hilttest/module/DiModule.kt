package com.tngen.hilttest.module

import android.content.Context
import androidx.room.Room
import com.tngen.hilttest.data.db.NoteDatabase
import com.tngen.hilttest.data.db.dao.NoteDAO
import com.tngen.hilttest.data.repository.NoteRepositoryImpl
import com.tngen.hilttest.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiModule {
    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context) : NoteDatabase {
        return Room
            .databaseBuilder(
                context,
                NoteDatabase::class.java,
                NoteDatabase.DATABASE_NAME
            ).build()
    }

    @Singleton
    @Provides
    fun provideNoteDAO(noteDB:NoteDatabase) : NoteDAO {
        return noteDB.noteDao()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDAO: NoteDAO
    ) : NoteRepository {
        return NoteRepositoryImpl(noteDAO)
    }
}