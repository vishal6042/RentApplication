package com.bharti.rentapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bharti.rentapplication.data.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(payment: Payment)

    @Update
    suspend fun update(payment: Payment)

    @Delete
    suspend fun delete(payment: Payment)

    @Query("SELECT * FROM payments WHERE paymentId = :paymentId")
    fun getPayment(paymentId: Int): Flow<Payment>

    @Query("SELECT * FROM payments")
    fun getAllPayments(): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE flatId = :flatId")
    fun getPaymentsByFlatId(flatId: Int): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE personId = :personId")
    fun getPaymentsByPersonId(personId: Int): Flow<List<Payment>>
}