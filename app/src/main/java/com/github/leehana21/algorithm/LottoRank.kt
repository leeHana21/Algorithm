package com.github.leehana21.algorithm

import org.w3c.dom.Text

class LottoRank {
    fun lotto(lottos: IntArray, win_nums: IntArray) {
        val correctAnswerCount = 1
        val ableToChangeCount = 1
        val ableToChangeCheckArray: IntArray = intArrayOf(0, 0, 0, 0, 0, 0)
        val checkCorrectAnswerArray: IntArray = intArrayOf(0, 0, 0, 0, 0, 0)
        val answer: IntArray
        (lottos.indices).forEach { i ->
            (win_nums.indices).forEach { j ->
                when (lottos[i]) {
                    win_nums[j] -> {
                        checkCorrectAnswerArray[i] = correctAnswerCount
                    }
                    0 -> {
                        ableToChangeCheckArray[i] = ableToChangeCount
                    }
                }
            }
        }
        val maxRank = checkRank(checkCorrectAnswerArray.sum() + ableToChangeCheckArray.sum())
        val minRank = checkRank(checkCorrectAnswerArray.sum())
        answer = intArrayOf(maxRank, minRank)
    }

    private fun checkRank(count: Int): Int {
        return when (count) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
    }
}