package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "nim") var nim: String,
    @ColumnInfo(name = "gender") var gender: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0
)