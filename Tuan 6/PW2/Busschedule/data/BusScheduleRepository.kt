package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface BusScheduleRepository {

    fun getALlBusSchedules(): Flow<List<BusSchedule>>

    fun getBusStopSchedule(stopName : String) : Flow<BusSchedule>
}