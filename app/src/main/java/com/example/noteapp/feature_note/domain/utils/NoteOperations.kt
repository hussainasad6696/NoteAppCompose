package com.example.noteapp.feature_note.domain.utils

sealed class NoteOperations(val noteDbOperations: Boolean) {
    data class NoteAdded(val isNoteAdded: Boolean): NoteOperations(isNoteAdded)
    data class NoteDeleted(val isNoteDeleted: Boolean): NoteOperations(isNoteDeleted)
    data class NoteModifier(val isNoteModified: Boolean): NoteOperations(isNoteModified)
}