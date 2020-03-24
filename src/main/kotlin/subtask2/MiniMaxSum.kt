package subtask2

import kotlin.math.max

class MiniMaxSum {


    fun getResult(input: IntArray): IntArray {
        var sumOfElements:Int=input.sum()
        val minElement=input.min()
        val maxElement=input.max()
        return if (minElement!=null && maxElement!=null) {
            val maxSum = sumOfElements - minElement
            val minSum = sumOfElements- maxElement
            intArrayOf(minSum, maxSum)
        }else{
            intArrayOf()
        }
    }
}
