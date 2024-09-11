fun main() {
    print("Ankara", 27, 31, 82)
    print("Tokyo", 32, 36, 10)
    print("Cape Town", 59, 64, 2)
    print("Guatemala City", 50, 55, 7)
}

fun print(cityName: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
    println("City: $cityName")
    println("Low temperature: $lowTemp, High temperature: $highTemp")
    println("Chance of rain: $chanceOfRain%")
    println()
}