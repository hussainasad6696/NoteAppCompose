package com.example.noteapp.feature_note.domain.use_case

import com.example.noteapp.common.utils.isNullOrBlankOrEmpty
import com.example.noteapp.feature_note.domain.model.InvalidNoteException
import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repo.NoteRepo
import com.example.noteapp.feature_note.domain.utils.NoteOperations

class AddEditNoteUseCase(private val noteRepo: NoteRepo) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note): NoteOperations.NoteAdded {

        if (note.title.isNullOrBlankOrEmpty()) {
            throw InvalidNoteException("Note title is empty.")
        }

        if (note.content.trim().isNullOrBlankOrEmpty()) {
            throw InvalidNoteException("Note content is empty.")
        }

        val noteAdded = noteRepo.addNote(note)
        return NoteOperations.NoteAdded(noteAdded > -1)
    }
}