package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.persistence.daos

import androidx.room.*
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.Student
import io.reactivex.Flowable

@Dao
interface StudentDao {
    @Query("SELECT * from students")
    fun getAll(): Flowable<List<Student>>

    @Query("SELECT * FROM students WHERE id = :id ")
    fun getById(id: String): Flowable<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("UPDATE students SET name =:studentName, nim =:studentNim, gender =:studentGen WHERE id =:studentId")
    fun update(studentId: Long, studentName: String, studentNim: String, studentGen: String)
}