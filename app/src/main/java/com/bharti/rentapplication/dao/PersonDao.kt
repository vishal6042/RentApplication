package com.bharti.rentapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bharti.rentapplication.data.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)

    @Update
    suspend fun update(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("SELECT * FROM persons WHERE personId = :personId")
    fun getPerson(personId: Int): Flow<Person>

    @Query("SELECT * FROM persons")
    fun getAllPersons(): Flow<List<Person>>
}