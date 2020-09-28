package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.data.models

import com.google.gson.annotations.SerializedName

data class Repo(
    val id: Long,
    val name: String,
    val description: String,
    val owner: User,
    @field:SerializedName("stargazers_count")
    val stars: Long,
    @field:SerializedName("forks_count")
    val forks: Long
)