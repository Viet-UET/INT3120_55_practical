package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDoa {

    @Query("SELECT * FROM Schedule WHERE stop_name = :stopName")
    fun getBusStopSchedule(stopName: String) : Flow<BusSchedule>

    @Query("SELECT * FROM Schedule ORDER BY arrival_time")
    fun getAllBusSchedules() : Flow<List<BusSchedule>>
}