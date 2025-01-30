package com.bharti.rentapplication.di

import android.content.Context
import com.bharti.rentapplication.dao.FlatDao
import com.bharti.rentapplication.dao.HouseDao
import com.bharti.rentapplication.dao.PastTenantDao
import com.bharti.rentapplication.dao.PaymentDao
import com.bharti.rentapplication.dao.PersonDao
import com.bharti.rentapplication.dao.TenantDao
import com.bharti.rentapplication.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideHouseDao(appDatabase: AppDatabase): HouseDao {
        return appDatabase.houseDao()
    }

    @Provides
    fun provideFlatDao(appDatabase: AppDatabase): FlatDao {
        return appDatabase.flatDao()
    }

    @Provides
    fun provideTenantDao(appDatabase: AppDatabase): TenantDao {
        return appDatabase.tenantDao()
    }

    @Provides
    fun providePaymentDao(appDatabase: AppDatabase): PaymentDao {
        return appDatabase.paymentDao()
    }

    @Provides
    fun providePersonDao(appDatabase: AppDatabase): PersonDao {
        return appDatabase.personDao()
    }

    @Provides
    fun providePastTenantDao(appDatabase: AppDatabase): PastTenantDao {
        return appDatabase.pastTenantDao()
    }
}