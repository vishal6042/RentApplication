package com.bharti.rentapplication.data

import java.time.LocalDate

data class FlatDetails(
    val flatNumber: String,
    val ownerName: String,
    val ownerPic: Int?, // Resource ID for the owner's picture (or a URL if you're loading from the network)
    val nextRentDueDate: LocalDate?,
    val lastRentDatePaid: LocalDate?
)