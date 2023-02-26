package com.example.noteapp.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

sealed interface UserEvent {
    data class EnteredTitle(val title: String) : UserEvent
    data class EnteredContent(val content: String) : UserEvent
    data class ChangeTitleFocus(val focusState: FocusState) : UserEvent
    data class ChangeContentFocus(val focusState: FocusState) : UserEvent
    data class ChangeColor(val color: Int) : UserEvent
    object SaveNote : UserEvent
}