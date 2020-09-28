package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.Student
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.persistence.daos.StudentDao

@Database(entities = [Student::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}