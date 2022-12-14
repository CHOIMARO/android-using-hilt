package com.tngen.data.module

import android.content.Context
import androidx.room.Room
import com.tngen.data.db.NoteDatabase
import com.tngen.data.db.dao.NoteDAO
import com.tngen.domain.repository.NoteRepository
import com.tngen.data.repository.NoteRepositoryImpl
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