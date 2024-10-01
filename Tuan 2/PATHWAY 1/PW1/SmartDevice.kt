import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice( val name:String , val category:String ){

    open val deviceType  = "unknown"

    open var status = "online"


    open fun turnOn(){
        status = "on"
    }
    open fun turnOff(){
        status = "off"
    }

    open fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName,category = deviceCategory){

    override val deviceType = "Smart Tv"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0 , maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0 , maxValue = 200)


    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Da tang am luong len ${speakerVolume}")
    }

    fun nextChannel(){
        channelNumber++
        println("Da tang kenh len ${channelNumber}")
    }

    override fun turnOn(){
        super.turnOn()
        println( " $name duoc bat. Am luong duoc dat la $speakerVolume . Kenh hien tai la $channelNumber " )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name da tat")
    }

    fun decreaseVolume(){
        speakerVolume--
        println("Da giam am luong xuong ${speakerVolume}")
    }
    fun previousChannel(){
        channelNumber--
        println("Da giam kenh xuong ${channelNumber}")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory:String):
    SmartDevice(name = deviceName , category = deviceCategory){

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness(){
        brightnessLevel++
        println("Brightnesslevel tang len $brightnessLevel")
    }

    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 2
        println("$name turn on .  Do sang la  $brightnessLevel ")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    override val deviceType = "Light"

    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightnesslevel giam xuong $brightnessLevel")
    }

    }

class SmartHome(val smartTvDevice: SmartTvDevice , val smartLightDevice: SmartLightDevice){

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv(){
        smartTvDevice.turnOn()
        deviceTurnOnCount++
    }
    fun turnOffTv(){
        smartTvDevice.turnOff()
        deviceTurnOnCount--
    }
    fun increaseTvVolume() {
        if (smartTvDevice.status == "on")
        smartTvDevice.increaseSpeakerVolume()

    }
    fun changeTvChannelToNext(){
        if (smartTvDevice.status == "on")
        smartTvDevice.nextChannel()
    }
    fun turnOnLight(){
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    fun turnOffLight(){
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    fun increaseLightBrightness(){
        if (smartLightDevice.status =="on")
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevice(){
        turnOffTv()
        turnOffLight()
    }
    fun decreaseTvVolume(){
        if (smartTvDevice.status == "on")
            smartTvDevice.decreaseVolume()
    }
    fun changeTvChannelToPrevious(){
        if (smartTvDevice.status =="on"){
            smartTvDevice.previousChannel()
        }
    }
    fun printSmartTvInfo(){
        println(" name : ${smartTvDevice.name} , category : ${smartTvDevice.category} , status : ${smartTvDevice.status} , deviceType : ${smartTvDevice.deviceType} ")
    }
    fun printSmartLightInfo(){
        println(" name :${smartLightDevice.name} , status : ${smartLightDevice.status} , category: ${smartLightDevice.category} ")
    }
    fun decreaseLightBrightness(){
        if (smartLightDevice.status == "on")
            smartLightDevice.decreaseBrightness()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?,Int>{

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue){
            fieldData = value
        }
    }
}

fun main() {
    var tv1 = SmartTvDevice("Android TV","Entertain")
    var light1 = SmartLightDevice("anhsang","thap sang" )
    var home: SmartHome = SmartHome(tv1,light1)

    home.turnOnTv()
    home.turnOnLight()

    home.printSmartTvInfo()
    home.printSmartLightInfo()

    home.increaseTvVolume()
    home.decreaseTvVolume()

    home.changeTvChannelToNext()
    home.changeTvChannelToPrevious()

    home.increaseLightBrightness()
    home.decreaseLightBrightness()






}