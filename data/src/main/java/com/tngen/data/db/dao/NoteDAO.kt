package com.tngen.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tngen.domain.entity.NoteEntity

@Dao
interface NoteDAO {
    @Query("SELECT * FROM Notes")
    fun getNote() : List<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note : NoteEntity) : Long
}