package com.github.leehana21.algorithm

import junit.framework.TestCase

class FromDecimalToTernaryAndReverseTest : TestCase() {

    fun testSolution() {
        //given
        val givenDecimal = 45
        val givenDecimal2 = 125
        //when
        val result = FromDecimalToTernaryAndReverse().solution(givenDecimal)
        val result2 = FromDecimalToTernaryAndReverse().solution(givenDecimal2)
        //then
        assertEquals(7,result)
        assertEquals(229,result2)
    }

    fun testDecimalToTernary() {
        //given
        val givenDecimal = 45
        val givenDecimal2 = 125
        //when
        val result = FromDecimalToTernaryAndReverse().decimalToTernary(givenDecimal)
        val result2 = FromDecimalToTernaryAndReverse().decimalToTernary(givenDecimal2)
        //then
        assertEquals(1200,result)
        assertEquals(11122,result2)
    }

    fun testReverseTernary() {
        //given
        val givenTernary = 1200
        val givenTernary2 = 11122
        //when
        val result = FromDecimalToTernaryAndReverse().reverseTernary(givenTernary.toLong())
        val result2 = FromDecimalToTernaryAndReverse().reverseTernary(givenTernary2.toLong())
        //then
        val expect = "0021".toInt(3)
        assertEquals(expect,result)
        val expect2 = "22111".toInt(3)
        assertEquals(expect2,result2)
    }
}