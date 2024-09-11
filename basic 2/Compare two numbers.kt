fun main(){
    var  timeSpentYesterday: Int = 300
    var  timeSpentToday : Int = 200
    println(compareNum(timeSpentToday,timeSpentYesterday))
}
fun compareNum( timeSpentToday: Int , timeSpentYesterday : Int ) : Boolean {
    if( timeSpentToday > timeSpentYesterday ){
        return true
    }else{
        return false
    }
}