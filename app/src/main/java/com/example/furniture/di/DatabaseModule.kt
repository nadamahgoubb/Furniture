package com.example.furniture.di

import android.app.Application
import androidx.room.Room
import com.example.furniture.data.local.AppDatabase
import com.example.furniture.data.remote.RoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME

        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    internal fun provideDao(appDatabase: AppDatabase): RoomDao {
        return appDatabase.getRoomDao()
    }
}
