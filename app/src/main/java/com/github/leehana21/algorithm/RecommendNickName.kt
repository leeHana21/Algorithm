package com.github.leehana21.algorithm

class RecommendNickName {
    fun checkId(new_id: String): String {
        var answer = new_id.lowercase()

        val level2Regex = Regex("[^a-z0-9-_.]")
        answer = answer.replace(level2Regex, "")

        val level3Regex = Regex("[.]+")
        answer = answer.replace(level3Regex, ".")

        val level4Regex = Regex("^[.]|[.]$")
        answer = answer.replace(level4Regex, "")

        val level5Regex = Regex("^\$")
        answer = answer.replace(level5Regex, "a")

        val level6Regex = Regex("[.]$")
        if (answer.length >= 16) {
            answer = answer.substring(0, 15)
            answer = answer.replace(level6Regex, "")
        }

        if (answer.length <= 2) {
            val checkLastChar = answer.toCharArray()
            val lastChar = checkLastChar[checkLastChar.lastIndex]
            val range = 3 - answer.length
            for (i in 0 until range) {
                answer += lastChar
            }
        }
        return answer
    }
}