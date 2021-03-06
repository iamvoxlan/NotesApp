package com.voxlan.mynotesapp.helper

import android.database.Cursor
import com.voxlan.mynotesapp.db.DatabaseContract
import com.voxlan.mynotesapp.entity.Note

object MappingHelper {
    fun mapCursorToArrayList(notesCursor: Cursor): ArrayList<Note>{
        val notesList = ArrayList<Note>()
        notesCursor.moveToFirst()
        while(notesCursor.moveToNext()){
            val id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
            val title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
            val description= notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
            val date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
            notesList.add(Note(id, title, description, date))
        }

        return notesList
    }
}