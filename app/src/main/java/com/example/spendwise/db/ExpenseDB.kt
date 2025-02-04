package com.example.spendwise.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.spendwise.db.ExpenseDA0
import androidx.room.TypeConverters
import com.example.spendwise.DateConverter

@Database(entities = [Expense::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDA0

    companion object {
        // Volatile annotation makes the instance visible to all threads
        @Volatile
        private var INSTANCE: ExpenseDatabase? = null

        // Method to get the database instance
        fun getDatabase(context: Context): ExpenseDatabase {
            // If the instance is not null, return it; otherwise, create a new one
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expense_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
