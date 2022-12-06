package com.tngen.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate= true)
    var id : Long = 0,

    @ColumnInfo(name = "Title")
    var title: String,

    @ColumnInfo(name = "Description")
    var description: String
)