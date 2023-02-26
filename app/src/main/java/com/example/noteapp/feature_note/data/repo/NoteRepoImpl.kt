package com.example.noteapp.feature_note.data.repo

import com.example.noteapp.feature_note.data.data_source.NoteDao
import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repo.NoteRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepoImpl @Inject constructor(private val dao: NoteDao): NoteRepo {
    override fun allNotes(): Flow<List<Note>> = dao.allNotes()

    override suspend fun addNote(note: Note): Long = dao.addNote(note)

    override suspend fun deleteNote(note: Note): Int = dao.deleteNote(note)

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)
}