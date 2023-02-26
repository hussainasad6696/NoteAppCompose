package com.example.noteapp.feature_note.domain.use_case

import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repo.NoteRepo
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(private val noteRepo: NoteRepo) {
    suspend operator fun invoke(noteId: Int) : Note? {
        return noteRepo.getNoteById(noteId)
    }
}