package com.bharti.rentapplication.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "past_tenants",
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
data class PastTenant(
    @PrimaryKey(autoGenerate = true) val pastTenantId: Int = 0,
    val personId: Int, // Foreign key to the Person table
    val flatId: Int?, // Foreign key to the Flat table
    val moveInDate: LocalDate,
    val moveOutDate: LocalDate
)