package com.github.leehana21.algorithm

import kotlin.math.abs

class TumbleBugCodingTest {

    fun solution(teamIDs: Array<String>, additional: Array<String>): Array<String> {
        var answer = arrayOf<String>()

        val exceptAlready = additional.toSet() - teamIDs.toSet()

        answer = exceptAlready.toTypedArray()


        return answer
    }

    fun numbers(numbers : IntArray) : Int{
        val majority = numbers.size / 2

        val checkDuplicate = numbers.toList().groupingBy { it
        }.eachCount().filter {
            it.value > majority
        }

        return if(checkDuplicate.isEmpty()){
            -1
        } else {
            checkDuplicate.keys.toIntArray()[0]
        }
    }

    fun solution(N: Int, sequence: IntArray): Int {
        var answer = 0

        for(i in sequence.indices){
            if(i != sequence.lastIndex){
                answer += abs(sequence[i] - sequence[1 + 1])
            }
        }
        return answer
    }
}