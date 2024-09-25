class Song{
    var title = ""
    var artist = ""
    var year = ""
    var replayCount = 0

    fun isPopular(replayCount:Int):Boolean{
        if (replayCount < 1000 ){
            return false
        }else{
            return true
        }
    }

    fun printInfo(){
        println(" $title , do $artist thuc hien , duoc phat hanh vao $year ")
    }

}

fun main(){

}