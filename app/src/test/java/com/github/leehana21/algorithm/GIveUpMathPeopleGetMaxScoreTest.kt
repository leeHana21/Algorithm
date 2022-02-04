package com.github.leehana21.algorithm

import junit.framework.TestCase

class GIveUpMathPeopleGetMaxScoreTest : TestCase() {

    fun testGetExamScore() {
        //given
        val rnds = (0..1000).random()
        val given = IntArray(rnds){0}
        for(i in given.indices){
         given[i] = (1..5).random()
        }
        //when
        val result = GIveUpMathPeopleGetMaxScore().getExamScore(given)
        //then
        assertEquals(intArrayOf(2,3,1),result)
    }
    //test code
}