package com.example.trainear.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.trainear.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    //val readAllData: LiveData<List<ExerciseWithDirection>>
    val getUpDirections: LiveData<List<UpDirectionWithDirection>>
    val getDirectionWithExercise: LiveData<List<DirectionWithExercise>>

    private val repository: UserRepository

    init {
        val trainearDao = TrainearDatabase.getDatabase(application).TrainearDao()
        repository = UserRepository(trainearDao)
        //readAllData = repository.readAllData
        getUpDirections = repository.getUpDirectionsWithDirections
        getDirectionWithExercise = repository.getDirectionWithExercise
    }

    fun addUser(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExercise(exercise)
        }
    }

    fun getExerciseById(id: Int): LiveData<List<ExerciseWithDirection>> {
        return repository.readAllData(id)
    }
}