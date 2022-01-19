package com.github.leehana21.algorithm

import android.util.Log
import kotlin.math.pow

class FromDecimalToTernaryAndReverse {
    companion object {
        const val TAG = "FromDecimalToTernaryAndReverse"
    }

    fun solution(n: Int): Int {
        val decimalToTernary = decimalToTernary(n)
        return reverseTernary(decimalToTernary)
    }

    fun decimalToTernary(decimalNum: Int): Long {
        var n = decimalNum
        var ret: Long = 0
        var factor: Long = 1
        while (n > 0) {
            ret += n % 3 * factor
            n /= 3
            factor *= 10
        }
        return ret
    }

    fun reverseTernary(ternaryNum: Long): Int {
        val ternaryArray = ternaryNum.toString().toCharArray()
        val reverseArray = CharArray(ternaryArray.size)
        for (i in ternaryArray.indices) {
            reverseArray[i] = ternaryArray[ternaryArray.lastIndex - i]
        }
        return String(reverseArray).toInt(3)
    }

    fun ternaryToDecimal(ternaryNum: Long): Int {
        var n = ternaryNum.toInt()
        return if (n != 0) {
            var decimalNumber = 0
            var i = 0
            var remainder: Int

            while (n != 0) {
                remainder = n % 10
                n /= 10

                decimalNumber += (remainder *
                        3.0.pow(i.toDouble())).toInt()
                ++i
            }
            decimalNumber
        } else 0
    }
}