package com.example.nv

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

data class Event(
    val title: String,
    val description: String?,
    val daypart: Daypart,
    val durationInMinutes: Int
)


fun main() {
    val events: MutableList<Event> = mutableListOf()

    events.add(Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0))
    events.add(Event(title = "Eat breakfast", description = null, daypart = Daypart.MORNING, durationInMinutes = 15))
    events.add(Event(title = "Learn about Kotlin", description = null, daypart = Daypart.AFTERNOON, durationInMinutes = 30))
    events.add(Event(title = "Practice Compose", description = null, daypart = Daypart.AFTERNOON, durationInMinutes = 60))
    events.add(Event(title = "Watch latest DevBytes video", description = null, daypart = Daypart.AFTERNOON, durationInMinutes = 10))
    events.add(Event(title = "Check out latest Android Jetpack library", description = null, daypart = Daypart.EVENING, durationInMinutes = 45))

    val morningEvents = events.filter { it.daypart == Daypart.MORNING }.size
    val afternoonEvents = events.filter { it.daypart == Daypart.AFTERNOON }.size
    val eveningEvents = events.filter { it.daypart == Daypart.EVENING }.size

    println("Morning: $morningEvents events")
    println("Afternoon: $afternoonEvents events")
    println("Evening: $eveningEvents events")
}