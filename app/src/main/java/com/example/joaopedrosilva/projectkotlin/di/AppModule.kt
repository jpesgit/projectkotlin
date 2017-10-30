package com.example.joaopedrosilva.projectkotlin.di

import android.arch.persistence.room.Room
import android.content.Context
import com.example.joaopedrosilva.projectkotlin.data.AppDatabase
import dagger.Module
import dagger.Provides

/**
 * Created by joaopedrosilva on 30/10/17.
 */
@Module
class AppModule(private val context: Context) {

    @Provides
    fun providesAppContext() = context

    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-todo-db").build()

    @Provides
    fun providesToDoDao(database: AppDatabase) = database.taskDao()
}