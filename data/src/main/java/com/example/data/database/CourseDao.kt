package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(course: CourseEntity)
    @Delete
    suspend fun delete(course: CourseEntity)
    @Query("select * from courses")
    fun getAll() : Flow<List<CourseEntity>>
}