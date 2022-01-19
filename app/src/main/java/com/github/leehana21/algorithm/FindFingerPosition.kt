package com.github.leehana21.algorithm

import kotlin.math.abs

class FindFingerPosition {
    fun findClickFinger(numbers: IntArray, hand: String): String {
        var answer = ""
        var leftHandPosition = Pair(0, 0)
        var rightHandPosition = Pair(0, 0)
        val middlePositionMap: Map<Int, Pair<Int, Int>> = mapOf(
            2 to Pair(1, 3),
            5 to Pair(1, 2),
            8 to Pair(1, 1),
            0 to Pair(1, 0)
        )
        for (element in numbers) {
            when (element) {
                2, 5, 8, 0 -> {
                    val leftHandDistance =
                        abs(leftHandPosition.first - middlePositionMap[element]!!.first) +
                                abs(leftHandPosition.second - middlePositionMap[element]!!.second)

                    val rightHandDistance =
                        abs(rightHandPosition.first - middlePositionMap[element]!!.first) +
                                abs(rightHandPosition.second - middlePositionMap[element]!!.second)
                    when {
                        leftHandDistance == rightHandDistance -> {
                            if (hand == "right") {
                                rightHandPosition = middlePositionMap[element]!!
                                answer += "R"
                            } else {
                                leftHandPosition = middlePositionMap[element]!!
                                answer += "L"
                            }
                        }
                        leftHandDistance > rightHandDistance -> {
                            rightHandPosition = middlePositionMap[element]!!
                            answer += "R"
                        }
                        else -> {
                            leftHandPosition = middlePositionMap[element]!!
                            answer += "L"
                        }
                    }
                }
                else -> {
                    when (element) {
                        1, 3 -> {
                            if (element % 3 == 0) {
                                rightHandPosition = Pair(0, 3)
                                answer += "R"
                            } else {
                                leftHandPosition = Pair(0, 3)
                                answer += "L"
                            }
                        }
                        4, 6 -> {
                            if (element % 3 == 0) {
                                rightHandPosition = Pair(0, 2)
                                answer += "R"
                            } else {
                                leftHandPosition = Pair(0, 2)
                                answer += "L"
                            }
                        }
                        else -> {
                            if (element % 3 == 0) {
                                rightHandPosition = Pair(0, 1)
                                answer += "R"
                            } else {
                                leftHandPosition = Pair(0, 1)
                                answer += "L"
                            }
                        }
                    }
                }
            }
        }
        return answer
    }
}