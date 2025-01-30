package com.bharti.rentapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bharti.rentapplication.data.PastTenant
import kotlinx.coroutines.flow.Flow

@Dao
interface PastTenantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pastTenant: PastTenant)

    @Update
    suspend fun update(pastTenant: PastTenant)

    @Delete
    suspend fun delete(pastTenant: PastTenant)

    @Query("SELECT * FROM past_tenants WHERE pastTenantId = :pastTenantId")
    fun getPastTenant(pastTenantId: Int): Flow<PastTenant>

    @Query("SELECT * FROM past_tenants")
    fun getAllPastTenants(): Flow<List<PastTenant>>

    @Query("SELECT * FROM past_tenants WHERE flatId = :flatId")
    fun getPastTenantsByFlatId(flatId: Int): Flow<List<PastTenant>>

    @Query("SELECT * FROM past_tenants WHERE personId = :personId")
    fun getPastTenantsByPersonId(personId: Int): Flow<List<PastTenant>>
}