package com.tngen.hilttest.domain

import com.tngen.hilttest.data.entity.NoteEntity
import com.tngen.hilttest.domain.repository.NoteRepository
import javax.inject.Inject

class HiltUseCase @Inject constructor( //내부 DB에 저장하기
    private val repository : NoteRepository
) : UseCase {

    suspend fun getNote() : NoteEntity {
        return repository.getNote()
    }
    suspend fun saveNote(noteEntity: NoteEntity) {
        repository.saveNote(noteEntity)
    }
}