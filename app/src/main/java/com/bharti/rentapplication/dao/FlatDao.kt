package com.bharti.rentapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.bharti.rentapplication.data.Flat
import com.bharti.rentapplication.data.FlatDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface FlatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(flat: Flat)

    @Update
    suspend fun update(flat: Flat)

    @Delete
    suspend fun delete(flat: Flat)

    @Query("SELECT * FROM flats WHERE flatId = :flatId")
    fun getFlat(flatId: Int): Flow<Flat>

    @Query("SELECT * FROM flats WHERE houseId = :houseId")
    fun getFlatsByHouseId(houseId: Int): Flow<List<Flat>>

    @Query("SELECT * FROM flats")
    fun getAllFlats(): Flow<List<Flat>>

    @Transaction
    @Query(
        """
        SELECT f.flatNumber, p.name AS ownerName, 
               MAX(p2.paymentDate) AS lastRentDatePaid, 
               CASE 
                   WHEN p2.paymentDate IS NULL THEN NULL 
                   ELSE DATE(p2.paymentDate, '+1 month') 
               END AS nextRentDueDate 
        FROM flats AS f 
        INNER JOIN houses AS h ON f.houseId = h.houseId 
        INNER JOIN persons AS p ON h.ownerId = p.personId
        LEFT JOIN payments AS p2 ON f.flatId = p2.flatId 
        GROUP BY f.flatId
    """
    )
    fun getFlatDetails(): Flow<List<FlatDetails>>
}