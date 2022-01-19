package com.github.leehana21.algorithm

class ScalarProduct {
    internal fun calculateScalarProduct(a: IntArray, b: IntArray): Int {
        var answer = 0
        // 프로그래머스 한줄 짜리 정답 코드;;
        // a.zip(b).map { it.first * it.second }.sum()
        for (i in a.indices) {
            answer += (a[i] * b[i])
        }
        return answer
    }
}