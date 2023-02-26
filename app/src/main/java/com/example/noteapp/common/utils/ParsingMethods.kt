package com.example.noteapp.common.utils

fun String?.isNullOrBlankOrEmpty(): Boolean {
    return this == null || this.isBlank() || this.isEmpty()
}