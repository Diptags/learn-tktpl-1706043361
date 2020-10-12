package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.Post
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.persistence.daos.PostDao

// Fungsi Untuk Database Room
@Database(entities = [Post::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
