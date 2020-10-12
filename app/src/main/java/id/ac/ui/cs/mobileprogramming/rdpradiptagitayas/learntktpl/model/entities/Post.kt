package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0,
    @ColumnInfo(name = "status") var status: String,
    @ColumnInfo(name = "location") var location: String,
    @ColumnInfo(name = "mood") var mood: String
)