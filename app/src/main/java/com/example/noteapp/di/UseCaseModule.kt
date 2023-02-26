package com.example.noteapp.di

import com.example.noteapp.feature_note.domain.repo.NoteRepo
import com.example.noteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun noteUseCases(noteRepo: NoteRepo): NoteUseCases {
        return NoteUseCases(
            allNotes = GetAllNotesUseCase(noteRepo),
            deleteNote = DeleteNoteUseCase(noteRepo),
            addNote = AddEditNoteUseCase(noteRepo),
            noteByIdUseCase = GetNoteByIdUseCase(noteRepo)
        )
    }
}