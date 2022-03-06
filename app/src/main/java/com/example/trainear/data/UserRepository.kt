package com.example.trainear.data

import androidx.lifecycle.LiveData

class UserRepository(private val trainearDao:TrainearDao) {

    fun readAllData(id: Int): LiveData<List<ExerciseWithDirection>> {
        val exercise: LiveData<List<ExerciseWithDirection>> =  trainearDao.exerciseWithDirection(id)
        return exercise
    }

    val getUpDirectionsWithDirections: LiveData<List<UpDirectionWithDirection>> = trainearDao.getUpDirectionsWithDirections()

    val getDirectionWithExercise: LiveData<List<DirectionWithExercise>> = trainearDao.directionWithExercise()

    suspend fun addExercise(exercise: Exercise) {
        trainearDao.addExercise(exercise)
    }
}