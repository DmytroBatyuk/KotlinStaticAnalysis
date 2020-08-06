package com.batyuk.dmytro.kotlinstaticanalysis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    //VariableNaming
    //MagicNumber
    val cUSTOM_VALUE = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FunctionTest()

    }

    //FunctionNaming
    //EmptyFunctionBlock
    private fun FunctionTest() {

    }
}//NewLineAtEndOfFile