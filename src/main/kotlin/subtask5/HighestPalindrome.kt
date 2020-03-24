package subtask5

class HighestPalindrome {


    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var palindrome = mutableListOf<Char>()
        for (i in digitString.indices){
            palindrome.add(digitString[i])
        }
        var palindrome2 = mutableListOf<Char>()
        palindrome2=MakePalindrome(n, k, palindrome)
        return palindrome2.joinToString("")
    }
}
private fun MakePalindrome(n: Int, k: Int, palindrome: MutableList<Char>): MutableList<Char> {
    var t: Int = n - 1
    var isTrue: Boolean
    var count: Int = 0
    var position: Int = 0
    var max: Int = 0
    var palindrome2 = mutableListOf<Char>('-','1')
    for (i in 0 until n / 2) {
        if (palindrome[i] != palindrome[t - i]) {
            count++
        }
    }
    if (count > k) {
        isTrue = false
    } else {
        for (i in 0 until n / 2) {
            if (palindrome[i] != palindrome[t - i]) {
                if (palindrome[i].toInt() > max) {
                    max = palindrome[i].toInt()
                    position = i
                } else {
                    if (palindrome[t - i].toInt() > max) {
                        max = palindrome[t - i].toInt()
                        position = t - i
                    }
                }
            }
        }

        for (i in 0 until n / 2) {
            if (palindrome[i] != palindrome[t - i] && (i == position || t - i == position)) {
                palindrome[i] = max.toChar()
                palindrome[t - i] = max.toChar()
            } else {
                if (palindrome[i] != palindrome[t - i]) {
                    palindrome[i] = '9'
                    palindrome[t - i] = '9'
                }
            }

        }

        isTrue = true
    }
    return if (!isTrue) {
        palindrome2
    } else {
        palindrome
    }
}

