package com.bharti.rentapplication.utils

import androidx.room.TypeConverter
import com.bharti.rentapplication.data.PaymentMode
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }

    @TypeConverter
    fun fromPaymentMode(value: PaymentMode): String {
        return value.name
    }

    @TypeConverter
    fun toPaymentMode(value: String): PaymentMode {
        return PaymentMode.valueOf(value)
    }
}