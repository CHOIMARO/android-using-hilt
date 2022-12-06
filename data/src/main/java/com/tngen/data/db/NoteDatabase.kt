package com.tngen.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tngen.data.db.dao.NoteDAO
import com.tngen.domain.entity.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDAO

    companion object {
        const val DATABASE_NAME = "worryNote.db"
    }
}