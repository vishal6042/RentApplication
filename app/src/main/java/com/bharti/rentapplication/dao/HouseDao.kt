package com.bharti.rentapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bharti.rentapplication.data.House
import kotlinx.coroutines.flow.Flow

@Dao
interface HouseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(house: House)

    @Update
    suspend fun update(house: House)

    @Delete
    suspend fun delete(house: House)

    @Query("SELECT * FROM houses WHERE houseId = :houseId")
    fun getHouse(houseId: Int): Flow<House>

    @Query("SELECT * FROM houses")
    fun getAllHouses(): Flow<List<House>>
}