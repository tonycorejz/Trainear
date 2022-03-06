package com.example.trainear.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrainearDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExercise(exercise: Exercise)

    @Transaction
    @Query("SELECT * FROM Exercise where exerciseId = :id")
    fun exerciseWithDirection(id: Int): LiveData<List<ExerciseWithDirection>>

    @Transaction
    @Query("SELECT * FROM UpDirection")
    fun getUpDirectionsWithDirections(): LiveData<List<UpDirectionWithDirection>>

    @Transaction
    @Query("SELECT * FROM Direction")
    fun directionWithExercise(): LiveData<List<DirectionWithExercise>>
}