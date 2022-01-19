package com.github.leehana21.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val testCode = FromDecimalToTernaryAndReverse()

        testCode.solution(45)
        testCode.solution(125)
    }
}