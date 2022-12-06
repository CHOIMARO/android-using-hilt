package com.tngen.domain.repository


import com.tngen.domain.entity.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface NoteRepository {
    suspend fun getNote() : NoteEntity
    suspend fun saveNote(note : NoteEntity)
}