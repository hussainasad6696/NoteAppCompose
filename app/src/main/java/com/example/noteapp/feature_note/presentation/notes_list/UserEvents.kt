package com.example.noteapp.feature_note.presentation.notes_list

import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.utils.NoteOrder

sealed interface UserEvents {
    data class NotesOrder(val noteOrder: NoteOrder) : UserEvents
    data class DeleteNote(val note: Note) : UserEvents
    object RestoreNote : UserEvents
    object ToggleOrderSection : UserEvents
}
