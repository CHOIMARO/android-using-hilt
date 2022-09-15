package com.tngen.hilttest.data.repository

import com.tngen.hilttest.data.db.dao.NoteDAO
import com.tngen.hilttest.data.entity.NoteEntity
import com.tngen.hilttest.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDAO: NoteDAO
) : NoteRepository {
    override suspend fun getNote() : NoteEntity {
        return withContext(Dispatchers.IO) {
            if(noteDAO.getNote().count() > 0 ) {
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