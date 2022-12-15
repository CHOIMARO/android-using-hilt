package com.tngen.data.repository

import com.tngen.data.db.dao.NoteDAO
import com.tngen.domain.entity.NoteEntity
import com.tngen.domain.repository.NoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDAO: NoteDAO,
    private val ioDispatcher: CoroutineDispatcher
) : NoteRepository {
    override suspend fun getNote() : NoteEntity {
        return withContext(ioDispatcher) {
            if(noteDAO.getNote().isNotEmpty()) {
                noteDAO.getNote()[0]
            }else {
                NoteEntity(
                    id = 0,
                    title = "empty",
                    description = "empty"
                )
            }
        }
    }
    override suspend fun saveNote(note : NoteEntity) {
        withContext(Dispatchers.IO) {
            noteDAO.insert(note)
        }
    }
}