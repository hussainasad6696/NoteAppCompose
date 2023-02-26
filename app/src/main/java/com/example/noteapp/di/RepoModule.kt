package com.example.noteapp.di

import com.example.noteapp.feature_note.data.repo.NoteRepoImpl
import com.example.noteapp.feature_note.domain.repo.NoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun noteRepo(noteRepoImpl: NoteRepoImpl): NoteRepo
}