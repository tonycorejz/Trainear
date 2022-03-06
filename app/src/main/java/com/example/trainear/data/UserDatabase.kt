package com.example.trainear.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Exercise::class, Direction::class, UpDirection::class, DirectionExerciseCrossRef::class, Workout::class, TagsForWorkouts::class, TagWorkoutCrossRef::class, CompleteLevel::class, Week::class, WorkoutDay::class, WorkoutDayExerciseCrossRef::class, Set::class], version = 1, exportSchema = true)
abstract class TrainearDatabase: RoomDatabase()  {
    abstract fun TrainearDao(): TrainearDao

    companion object {
        private var INSTANCE: TrainearDatabase? = null

        fun getDatabase(context: Context): TrainearDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TrainearDatabase::class.java,
                    "trainear_database"
                ).createFromAsset("database/new_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}