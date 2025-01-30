package com.bharti.rentapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true) val personId: Int,
    val name:String,
    val contact: String,
    val email: String?,
    val governmentIdType: GovernmentIdType,
    val governmentId: String
)
