package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.CourseModel

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var summary: String? = null,
    var cover: String? = null,
    var isFavorite: Boolean? = null,
    var price: String? = null,
    var title: String? = null,
    var becamePublishedAt: String? = null,
    var description: String? = null,
) {
    fun mapDomain() = CourseModel(
        id, summary, cover, isFavorite, price, title, becamePublishedAt, description
    )
}
