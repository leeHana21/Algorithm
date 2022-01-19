package com.github.leehana21.algorithm

import junit.framework.TestCase
import org.junit.Test

class ScalarProductTest : TestCase() {

    @Test
    fun testCalculateScalarProduct() {
        //given
        val givenData = intArrayOf(1, 2, 3, 4, 5)
        val givenData2 = intArrayOf(1, 2, 3, 4, 5)
        //when
        val result = ScalarProduct().calculateScalarProduct(givenData, givenData2)
        //then
       assertEquals(55,result)
    }
}