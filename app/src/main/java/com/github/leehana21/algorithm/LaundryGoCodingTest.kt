package com.github.leehana21.algorithm

import android.util.Log

class LaundryGoCodingTest {

    fun aabb(S: String): Int {
        val sToChar = S.toCharArray()
        var recentChar: Char
        var count = 0
        val spellArray = ArrayList<String>()
        val countArray = ArrayList<Int>()

        for (i in sToChar.indices) {
            recentChar = sToChar[i]
            Log.d("??????","$recentChar")
            when (sToChar[i]) {
                'a' -> {
                    if (recentChar == 'b') {
                        spellArray.add("b")
                        countArray.add(count)
                        count = 0
                        ++count
                    } else {
                        ++count
                    }
                }
                'b' -> {
                    if (recentChar == 'a') {
                        spellArray.add("a")
                        countArray.add(count)
                        count = 0
                        ++count
                    } else {
                        ++count
                    }
                }
                else -> {}
            }
        }

        var countAnswer = 0
        val max = countArray.maxOrNull() ?: 0

        for (i in countArray.indices) {
            countAnswer = countAnswer + max - countArray[i]
        }

        return countAnswer
    }

    fun solution(S: String): Int {
        var limitFixing = 0
        var answer = 0
        val changeStrToChar = S.toCharArray()


        for (i in 0..changeStrToChar.size step (3)) {
            for (k in i..i + 2) {
                if (changeStrToChar[k] == 'X') {
                    ++limitFixing
                }
            }
            if (limitFixing > 0) {
                answer++
            }
            limitFixing = 0
        }

        return answer
    }

    fun lateSolution(S: String): Int {
        var limitFixing = 0
        var answer = 0
        val changeStrToChar = S.toCharArray()

        for (i in 0..changeStrToChar.size step (3)) {
            val sliceArray = changeStrToChar.slice(IntRange(i, i + 2))
            for (j in sliceArray.indices) {
                if (sliceArray[j] == 'X') {
                    ++limitFixing
                }
            }
            if (limitFixing > 0) {
                answer++
            }
            limitFixing = 0
        }

        return answer
    }
}
/*package com.codility.mvp

import io.reactivex.disposables.CompositeDisposable

class Presenter(view: ListContract.View, elementsProvider: ElementsProvider, schedulerFacade: SchedulerFacade) {
  val disposables = CompositeDisposable()

  init {
    disposables.add(
        elementsProvider.loadElements()
            .subscribeOn(schedulerFacade.background)
            .observeOn(schedulerFacade.main)
            .subscribe()
    )
  }
}*/