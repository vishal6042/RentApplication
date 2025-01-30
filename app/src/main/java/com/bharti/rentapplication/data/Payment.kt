package com.bharti.rentapplication.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "payments",
    foreignKeys = [
        ForeignKey(
            entity = Flat::class,
            parentColumns = ["flatId"],
            childColumns = ["flatId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Person::class,
            parentColumns = ["personId"],
            childColumns = ["personId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("flatId"), Index("personId")]
)
data class Payment(
    @PrimaryKey(autoGenerate = true) val paymentId: Int = 0,
    val flatId: Int,
    val personId: Int?, // Foreign key to link to the Person (tenant)
    val amount: Double, // Amount in INR
    val paymentDate: LocalDate,
    val paymentMode: PaymentMode, // Enum for payment mode
)
