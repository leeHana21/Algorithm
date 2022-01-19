package com.github.leehana21.algorithm

import android.util.Log

class RentSportWearStudyTogether {
    fun exerciseLook(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var lostButCanExerciseStudent = 0
        val sortedLost = lost.sorted().toMutableList()
        val sortedReserve = reserve.sorted().toMutableList()
        // 종류 --> 자기 체육복만 가지고 옴 / 체육복 잃어버림 / 여분 챙김 / 여분 챙겼지만 잃어버림

        // -> 빌려줄 수 없는 학생수(자기 체육복만 가지고 옴,체육복 잃어버림,여분 챙겼지만 잃어버림)에 포함

        // 여분 체육복이 있지만 잃어버린 학생 찾기
        val checkValueReserveAndLost: MutableList<Int> = mutableListOf()
        for (i in sortedReserve.indices) {
            if (sortedLost.contains(sortedReserve[i])) {
                checkValueReserveAndLost.add(sortedReserve[i])
                Log.d("exerciseLook", "lost look: ${sortedReserve[i]}")
            }
        }
        Log.d("exerciseLook", "after lost look: $checkValueReserveAndLost")

        for (i in checkValueReserveAndLost.indices) {
            sortedLost.remove(checkValueReserveAndLost[i])
            sortedReserve.remove(checkValueReserveAndLost[i])
            Log.d("exerciseLook", "remove same: sortedLost $sortedLost")
            Log.d("exerciseLook", "remove same: sortedReserve $sortedReserve")
        }
        /// 빌려 줄 수 없지만 체육 수업 들을 수 있는 학생 수(자기 체육복만 있음)
        val cantRentButCanStudyStudent = n - (sortedLost.size + sortedReserve.size)
        // 빌려 줄 수 있고 체육 수업도 들을 수 있는 학생 수
        val canRentAndStudyStudent = sortedReserve.size
        // 전체 학생 수에서 잃어버린 학생 수 빼기(n - lost size) = cannotRent
        // 전체 학생 수에서 빌려줄 수 없는(잃어버렸거나, 하나만 있거나) 학생 수 빼기 cannotRent - reserve size
        var alreadyRented = false
        for (element in sortedLost) {
            if (sortedReserve.contains(element - 1)) {
                alreadyRented = true
                lostButCanExerciseStudent++
                sortedReserve.removeAt(sortedReserve.indexOf(element - 1))
                Log.d("exerciseLook", "rented -1 : sortedReserve $sortedReserve")
            }

            if (sortedReserve.contains(element + 1) && !alreadyRented) {
                lostButCanExerciseStudent++
                sortedReserve.removeAt(sortedReserve.indexOf(element + 1))
                Log.d("exerciseLook", "rented +1: sortedReserve $sortedReserve")
            }
            alreadyRented = false
        }
        answer = cantRentButCanStudyStudent + canRentAndStudyStudent + lostButCanExerciseStudent
        Log.d("exerciseLook", "exerciseLook: answer $answer")
        return answer
    }
}