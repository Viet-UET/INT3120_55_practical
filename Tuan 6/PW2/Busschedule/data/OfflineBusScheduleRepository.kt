package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

data class OfflineBusScheduleRepository(private val busScheduleDoa : BusScheduleDoa) : BusScheduleRepository{
    override fun getALlBusSchedules(): Flow<List<BusSchedule>> {
        return busScheduleDoa.getAllBusSchedules()
    }

    override fun getBusStopSchedule(stopName: String): Flow<BusSchedule> {
        return busScheduleDoa.getBusStopSchedule(stopName)
    }

}
