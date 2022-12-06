package com.tngen.domain

import com.tngen.domain.entity.NoteEntity
import com.tngen.domain.repository.NoteRepository
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