package com.example.noteapp.feature_note.presentation.notes_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.use_case.NoteUseCases
import com.example.noteapp.feature_note.domain.utils.NoteOrder
import com.example.noteapp.feature_note.domain.utils.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val notesUseCases: NoteUseCases) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null

    private var notesJob: Job? = null

    init {
        getNotesWithNoteOrder(NoteOrder.Date(OrderType.Descending))
    }

    fun onUserEvent(userEvents: UserEvents) {
        when (userEvents) {
            is UserEvents.NotesOrder -> {
                if (state.value.noteOrder::class == userEvents.noteOrder::class && state.value.noteOrder.orderType == userEvents.noteOrder.orderType) return
                getNotesWithNoteOrder(userEvents.noteOrder)
            }
            is UserEvents.DeleteNote -> {
                viewModelScope.launch {
                    notesUseCases.deleteNote(userEvents.note)
                    recentlyDeletedNote = userEvents.note
                }
            }
            is UserEvents.RestoreNote -> {
                viewModelScope.launch {
                    try {
                        notesUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    } catch (e: Exception) {

                    }
                    recentlyDeletedNote = null
                }
            }
            is UserEvents.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotesWithNoteOrder(noteOrder: NoteOrder) {
        notesJob?.cancel()
        notesJob = notesUseCases.allNotes(noteOrder).onEach {
            _state.value = state.value.copy(
                notes = it,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}