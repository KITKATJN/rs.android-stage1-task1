package subtask4

class StringParser {


    fun getResult(inputString: String): Array<String> {
        var brackets = arrayOf('[',']','<','>','(',')')
        var inputStringOfBrackets =  mutableListOf<Char>()
        var positionOfBrackets = mutableListOf<Int>()
        var result = mutableListOf<String>()
        var endIndex: Int = 0

        for (i in inputString.indices) {
            if(inputString[i] in brackets){
                inputStringOfBrackets.add(inputString[i])
                positionOfBrackets.add(i)
            }
        }



        for (i in 0 until inputStringOfBrackets.size){
            when(inputStringOfBrackets[i]){
                '<' -> {
                    endIndex = findChar(inputStringOfBrackets, '>', i)
                    if (endIndex != -2) result.add(inputString.substring(positionOfBrackets[i] + 1,
                        positionOfBrackets[endIndex]))
                }

                '(' -> {
                    endIndex = findChar(inputStringOfBrackets, ')', i)
                    if(endIndex != -2) result.add(inputString.substring(positionOfBrackets[i] + 1,
                        positionOfBrackets[endIndex]))
                }

                '[' -> {
                    endIndex = findChar(inputStringOfBrackets, ']', i)
                    if (endIndex != -2) result.add(inputString.substring(positionOfBrackets[i] + 1,
                        positionOfBrackets[endIndex]))
                }

            }
        }

        return result.toTypedArray()
    }
}

private fun findChar(charList: MutableList<Char>, charToFind: Char, fromPos: Int): Int{
    var count = 0
    for (j in fromPos until charList.size){

        if(charList[j] == charList[fromPos]) count++

        if(charList[j] == charToFind){
            if(count == 1){
                charList[fromPos] = '*'
                charList[j] = '*'
                return j
            } else count--
        }

    }
    return -2
}




