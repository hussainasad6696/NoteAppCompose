package com.example.noteapp.feature_note.domain.use_case

import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repo.NoteRepo
import com.example.noteapp.feature_note.domain.utils.NoteOperations

class DeleteNoteUseCase(private val noteRepo: NoteRepo) {
    suspend operator fun invoke(note: Note): NoteOperations.NoteDeleted {
        val deleteNote = noteRepo.deleteNote(note)
        return NoteOperations.NoteDeleted(deleteNote > -1)
    }
}