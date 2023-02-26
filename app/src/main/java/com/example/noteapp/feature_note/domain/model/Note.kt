package com.example.noteapp.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Color.Black,Color.Blue,Color.Cyan,Color.DarkGray,Color.Magenta,Color.Red,Color.Green)
    }
}

class InvalidNoteException(message: String): Exception(message)