package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.entity.CourseEntity

@Database(
    version = 1,
    entities = [
        CourseEntity::class
    ]
)
abstract class CourseDataBase: RoomDatabase() {
    abstract fun courseDao() : CourseDao
}