
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}


class FoldablePhone(var isFolded: Boolean = false, isScreenLightOn: Boolean = false) : Phone(isScreenLightOn) {

    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        } else {
            println("Cannot switch on. The phone is folded.")
        }
    }
    fun fold() {
        isFolded = true
        switchOff()
        println("The phone is folded.")
    }
    fun unfold() {
        isFolded = false
        println("The phone is unfolded.")
    }
    fun checkFoldStatus() {
        val foldStatus = if (isFolded) "folded" else "unfolded"
        println("The phone is currently $foldStatus.")
    }
}
