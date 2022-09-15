package com.tngen.hilttest.domain.repository

import com.tngen.hilttest.data.db.dao.NoteDAO
import com.tngen.hilttest.data.entity.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface NoteRepository {
    suspend fun getNote() : NoteEntity
    suspend fun saveNote(note : NoteEntity)
}