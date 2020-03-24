package subtask1

class HappyArray {


    fun convertToHappy(sadArray: IntArray): IntArray {
        var happyList = sadArray.toMutableList()
        if (happyList.size < 3) {
            return sadArray
        } else {
            var isHappy: Boolean = false
            var hCount: Int = 2

            while (!isHappy) {
                hCount = 2
                for (i in 1 until happyList.size - 1) {

                    if ((happyList[i - 1] + happyList[i + 1]) < happyList[i]) {
                        happyList.removeAt(i)
                        break
                    }
                    hCount++
                }

                if (hCount == happyList.size) {
                    isHappy = true
                }
            }


            return happyList.toIntArray()
        }
    }
}






