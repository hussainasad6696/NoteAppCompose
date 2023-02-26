package com.example.noteapp.feature_note.domain.repo

import com.example.noteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo {
    fun allNotes(): Flow<List<Note>>
    suspend fun addNote(note: Note): Long
    suspend fun deleteNote(note: Note): Int
    suspend fun getNoteById(id: Int): Note?
}