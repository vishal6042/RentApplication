package com.bharti.rentapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bharti.rentapplication.data.Tenant
import kotlinx.coroutines.flow.Flow

@Dao
interface TenantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tenant: Tenant)

    @Update
    suspend fun update(tenant: Tenant)

    @Delete
    suspend fun delete(tenant: Tenant)

    @Query("SELECT * FROM tenants WHERE tenantId = :tenantId")
    fun getTenant(tenantId: Int): Flow<Tenant>

    @Query("SELECT * FROM tenants")
    fun getAllTenants(): Flow<List<Tenant>>

    @Query("SELECT * FROM tenants WHERE flatId = :flatId")
    fun getTenantsByFlatId(flatId: Int): Flow<List<Tenant>>

    @Query("SELECT * FROM tenants WHERE personId = :personId")
    fun getTenantsByPersonId(personId: Int): Flow<List<Tenant>>
}