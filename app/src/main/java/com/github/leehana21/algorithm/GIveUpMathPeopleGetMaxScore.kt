package com.github.leehana21.algorithm

import android.util.Log

class GIveUpMathPeopleGetMaxScore {

    fun getExamScore(answers: IntArray): IntArray {
        val giveUpMathPeople: List<IntArray> = listOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )
        val examScore = mutableListOf<Pair<Int, Int>>()
        var correctAnswer = 0
        var giveUpIndex: Int
        for (personIdx in giveUpMathPeople.indices) {
            giveUpIndex = -1
            val lastIdx = giveUpMathPeople[personIdx].lastIndex
            for (i in answers.indices) {
                if (giveUpIndex == lastIdx) {
                    if (answers[i] == giveUpMathPeople[personIdx][giveUpIndex]) {
                        correctAnswer++
                    }
                    giveUpIndex = 0
                    Log.d("getExamScore", "getExamScore: answer ${answers[i]}")
                    Log.d(
                        "getExamScore",
                        "getExamScore: array ${giveUpMathPeople[personIdx][giveUpIndex]}"
                    )
                } else {
                    giveUpIndex++
                    if (answers[i] == giveUpMathPeople[personIdx][giveUpIndex]) {
                        correctAnswer++
                    }
                    Log.d("getExamScore", "getExamScore: answer ${answers[i]}")
                    Log.d(
                        "getExamScore",
                        "getExamScore: array ${giveUpMathPeople[personIdx][giveUpIndex]}"
                    )
                }
                if (answers[i] == giveUpMathPeople[personIdx][giveUpIndex]) {
                    correctAnswer++
                }
            }
            if (correctAnswer != 0) {
                examScore.add(Pair(correctAnswer, personIdx))
                correctAnswer = 0
            }
        }
        val answer = mutableListOf<Int>()
        if (examScore.size != 0) {
            var maxScore = examScore[0].first
            for (i in examScore.indices) {
                if (maxScore < examScore[i].first) {
                    maxScore = examScore[i].first
                }
            }
            //val maxScore = examScore.maxOf { it.first }
            Log.d("getExamScore", "getExamScore: maxScore $maxScore")
            val result = examScore.sortedWith(compareBy({ -it.first }, { it.second }))
            Log.d("getExamScore", "getExamScore: result $result")

            for (i in result.indices) {
                if (maxScore == examScore[i].first) {
                    answer.add(examScore[i].second + 1)
                }
            }
        }
        Log.d("getExamScore", "getExamScore: $answer")
        return answer.toIntArray()
    }

    fun getExamScoreNoLog(answers: IntArray): IntArray {
        val giveUpMathPeople: List<IntArray> = listOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )
        val examScore = mutableListOf<Pair<Int, Int>>()
        var correctAnswer = 0
        var giveUpIndex: Int
        for (personIdx in giveUpMathPeople.indices) {
            giveUpIndex = -1
            val lastIdx = giveUpMathPeople[personIdx].lastIndex
            for (i in answers.indices) {
                if (giveUpIndex == lastIdx) {
                    if (answers[i] == giveUpMathPeople[personIdx][giveUpIndex]) {
                        correctAnswer++
                    }
                    giveUpIndex = 0
                } else {
                    giveUpIndex++
                    if (answers[i] == giveUpMathPeople[personIdx][giveUpIndex]) {
                        correctAnswer++
                    }
                }
                if (answers[i] == giveUpMathPeople[personIdx][giveUpIndex]) {
                    correctAnswer++
                }
            }
            if (correctAnswer != 0) {
                examScore.add(Pair(correctAnswer, personIdx))
                correctAnswer = 0
            }
        }
        val answer = mutableListOf<Int>()
        if (examScore.size != 0) {
            var maxScore = examScore[0].first
            for (i in examScore.indices) {
                if (maxScore < examScore[i].first) {
                    maxScore = examScore[i].first
                }
            }
            //val maxScore = examScore.maxOf { it.first }
            val result = examScore.sortedWith(compareBy({ -it.first }, { it.second }))

            for (i in result.indices) {
                if (maxScore == examScore[i].first) {
                    answer.add(examScore[i].second + 1)
                }
            }
        }
        return answer.toIntArray()
    }
}