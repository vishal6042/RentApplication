package com.bharti.rentapplication.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "tenants",
    foreignKeys = [
        ForeignKey(
            entity = Flat::class,
            parentColumns = ["flatId"],
            childColumns = ["flatId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Person::class,
            parentColumns = ["personId"],
            childColumns = ["personId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("flatId"), Index("personId")]
)
data class Tenant(
    @PrimaryKey(autoGenerate = true) val tenantId: Int = 0,
    val moveInDate: LocalDate,
    val flatId: Int? = null, // Foreign key to link to the Flat
    val personId: Int // Foreign key to link to the Person (tenant)
)