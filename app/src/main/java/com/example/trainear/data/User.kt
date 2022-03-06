 package com.example.trainear.data

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize


 /*******************Направления***************/
 @Entity
 data class UpDirection (
     @PrimaryKey(autoGenerate = true)
     val upDirectionId: Int,
     val name: String
 )

 @Parcelize
 @Entity
 data class Direction (
     @PrimaryKey(autoGenerate = true)
     val directionId: Int,
     val name: String,
     val parentUpDirectionId: Int
 ): Parcelable

 data class UpDirectionWithDirection (
     @Embedded val upDirection: UpDirection,
     @Relation(
         parentColumn = "upDirectionId",
         entityColumn = "parentUpDirectionId"
     )
     val direction: List<Direction>
 )

 /*******************Упражнения и направления***************/
 @Parcelize
 @Entity
 data class Exercise (
     @PrimaryKey(autoGenerate = true)
     val exerciseId: Int,
     val name: String,
     val image: String,
     val about: String,
     val workload_image: String,
     val important_points: String
 ): Parcelable

 @Entity(primaryKeys = ["directionId", "exerciseId"])
 data class DirectionExerciseCrossRef (
     val exerciseId: Int,
     val directionId: Int
 )

 data class ExerciseWithDirection (
     @Embedded val exercise: Exercise,
     @Relation(
         parentColumn = "exerciseId",
         entityColumn = "directionId",
         associateBy = Junction(DirectionExerciseCrossRef::class)
     )
     val directions: List<Direction>
 )

 data class DirectionWithExercise (
     @Embedded val exercise: Direction,
     @Relation(
         parentColumn = "directionId",
         entityColumn = "exerciseId",
         associateBy = Junction(DirectionExerciseCrossRef::class)
     )
     val directions: List<Exercise>
 )

 /*******************Тренировка с тегом***************/
 @Entity
 data class Workout (
     @PrimaryKey(autoGenerate = true)
     val id: Int,
     val name: String,
     val levelOfDifficulty: Int
 )
 @Entity
 data class TagsForWorkouts (
     @PrimaryKey(autoGenerate = true)
     val id: Int,
     val name: String
 )

 @Entity(primaryKeys = ["workoutId", "tagsForWorkoutsId"])
 data class TagWorkoutCrossRef (
     val workoutId: Int,
     val tagsForWorkoutsId: Int
 )

 data class WorkoutWithTags (
     @Embedded val workout: Workout,
     @Relation(
         parentColumn = "workoutId",
         entityColumn = "tagsForWorkoutsId",
         associateBy = Junction(TagWorkoutCrossRef::class)
     )
     val tags: List<TagsForWorkouts>
 )

 data class TagWithWorkouts (
     @Embedded val tag: TagsForWorkouts,
     @Relation(
         parentColumn = "tagsForWorkoutsId",
         entityColumn = "workoutId",
         associateBy = Junction(TagWorkoutCrossRef::class)
     )
     val workouts: List<Workout>
 )

 /*******************Уровень завершенности***************/
 @Entity
 data class CompleteLevel (
     @PrimaryKey(autoGenerate = true)
     val id: Int,
     val name: String
 )


 /*******************Неделя***************/
 @Entity
 data class Week (
     @PrimaryKey(autoGenerate = true)
     val id: Int,
     val workoutId: Int,
     val completeLevelId: Int
 )

 data class WorkoutWithWeek (
     @Embedded val workout: Workout,
     @Relation(
         parentColumn = "id",
         entityColumn = "workoutId"
     )
     val week: List<Week>
 )

 data class CompleteLevelWithWeek (
     @Embedded val completeLevel: CompleteLevel,
     @Relation(
         parentColumn = "id",
         entityColumn = "completeLevelId"
     )
     val week: List<Week>
 )

 /*******************День***************/
 @Entity
 data class WorkoutDay (
     @PrimaryKey(autoGenerate = true)
     val id: Int,
     val workoutWeekId: Int,
     val completeLevelId: Int
 )

 data class WeekWithWorkoutDay (
     @Embedded val week: Week,
     @Relation(
         parentColumn = "id",
         entityColumn = "workoutWeekId"
     )
     val workoutDay: List<WorkoutDay>
 )

 data class CompleteLevelWithWorkoutDay (
     @Embedded val completeLevel: CompleteLevel,
     @Relation(
         parentColumn = "id",
         entityColumn = "completeLevelId"
     )
     val workoutDay: List<WorkoutDay>
 )

 /*******************Детализация упражнения в тренировочном дне***************/
 @Entity(primaryKeys = ["workoutDayId", "exerciseId", "id"])
 data class WorkoutDayExerciseCrossRef (
     val id: Int,
     val workoutDayId: Int,
     val exerciseId: Int,
     val completeLevelId: Int
 )

 data class WorkoutDayWithExercise (
     @Embedded val workoutDay: WorkoutDay,
     @Relation(
         parentColumn = "workoutDayId",
         entityColumn = "exerciseId",
         associateBy = Junction(WorkoutDayExerciseCrossRef::class)
     )
     val exercise: List<Exercise>
 )

 data class ExerciseWithWorkoutDay (
     @Embedded val exercise: Exercise,
     @Relation(
         parentColumn = "exerciseId",
         entityColumn = "workoutDayId",
         associateBy = Junction(WorkoutDayExerciseCrossRef::class)
     )
     val workoutDay: List<WorkoutDay>
 )

 data class CompleteLevelWithWorkoutDayExercise (
     @Embedded val completeLevel: CompleteLevel,
     @Relation(
         parentColumn = "id",
         entityColumn = "completeLevelId"
     )
     val workoutDayExercise: List<WorkoutDayExerciseCrossRef>
 )

 /*******************Подходы***************/
@Entity
 data class Set (
     @PrimaryKey(autoGenerate = true)
     val id: Int,
     val workoutDayExerciseId: Int,
     val weight: Int,
     val repNumber: Int
 )

 data class WorkoutDayExerciseWithSet (
     @Embedded val workoutDayExercise: WorkoutDayExerciseCrossRef,
     @Relation(
         parentColumn = "id",
         entityColumn = "workoutDayExerciseId"
     )
     val set: List<Set>
 )