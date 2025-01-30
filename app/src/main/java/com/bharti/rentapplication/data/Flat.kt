package com.bharti.rentapplication.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "flats",
    foreignKeys = [
        ForeignKey(
            entity = House::class,
            parentColumns = ["houseId"],
            childColumns = ["houseId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("houseId")]
)
data class Flat(
    @PrimaryKey(autoGenerate = true) val flatId: Int = 0,
    val flatNumber: String,
    val rentAmount: Double,
    val houseId: Int, // Foreign key to link to the House
    var isOccupied: Boolean = false
)