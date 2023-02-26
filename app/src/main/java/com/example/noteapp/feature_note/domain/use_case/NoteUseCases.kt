package com.example.noteapp.feature_note.domain.use_case

data class NoteUseCases(
    val allNotes: GetAllNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNote: AddEditNoteUseCase,
    val noteByIdUseCase: GetNoteByIdUseCase
)