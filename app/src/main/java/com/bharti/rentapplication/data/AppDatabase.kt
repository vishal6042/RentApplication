package com.bharti.rentapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.bharti.rentapplication.dao.FlatDao
import com.bharti.rentapplication.dao.HouseDao
import com.bharti.rentapplication.dao.PastTenantDao
import com.bharti.rentapplication.dao.PaymentDao
import com.bharti.rentapplication.dao.PersonDao
import com.bharti.rentapplication.dao.TenantDao
import com.bharti.rentapplication.utils.Converters
import java.time.LocalDate

@Database(
    entities = [House::class, Flat::class, Tenant::class, Payment::class, Person::class, PastTenant::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun houseDao(): HouseDao
    abstract fun flatDao(): FlatDao
    abstract fun tenantDao(): TenantDao
    abstract fun paymentDao(): PaymentDao
    abstract fun personDao(): PersonDao
    abstract fun pastTenantDao(): PastTenantDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}