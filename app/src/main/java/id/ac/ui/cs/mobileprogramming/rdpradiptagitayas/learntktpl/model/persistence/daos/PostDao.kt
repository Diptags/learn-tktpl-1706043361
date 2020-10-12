package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.persistence.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.Post
import io.reactivex.Flowable

// Data

@Dao
interface PostDao {
    @Query("SELECT * from posts")
    fun getAll(): Flowable<List<Post>>

    @Query("SELECT * FROM posts WHERE id = :id ")
    fun getById(id: String): Flowable<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: Post)

    @Delete
    fun delete(student: Post)
}