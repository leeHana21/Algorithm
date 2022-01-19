package com.github.leehana21.algorithm

class FailureRate {
    fun checkStageFailureRate(N: Int, stages: IntArray): IntArray {
        val stageAndFailureList = mutableListOf<Pair<Double, Int>>()
        var reachedStageButNotClear = 0
        var reachedStageOrClear = 0
        val answer = IntArray(N) { 0 }
        for (stageNumber in 1 until N + 1) {
            for (element in stages) {
                if (stageNumber == element) {
                    reachedStageButNotClear++
                }
                if (stageNumber <= element) {
                    reachedStageOrClear++
                }
            }
            val failure = reachedStageButNotClear.toDouble() / reachedStageOrClear.toDouble()
            stageAndFailureList.add(Pair(failure, stageNumber))
            reachedStageButNotClear = 0
            reachedStageOrClear = 0
        }

        val result = stageAndFailureList.sortedWith(compareBy({ -it.first }, { it.second }))
        for (i in result.indices) {
            answer[i] = result[i].second
        }
        return answer
    }
}