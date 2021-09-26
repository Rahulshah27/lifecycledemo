package com.rahul.lifecycleexample

object MinSdk {
    fun getMinSdk(): ArrayList<Int>{
        return arrayListOf(
            1,
            3,4,5,8,9,11,14,16,19,21,23,24,26,28,29,30
        )
    }
    fun getVersion():ArrayList<String>{
        return arrayListOf(
            "1.0",
            "1.5",
            "1.6",
            "2.0",

            "2.2.x",
            "2.3",
            "3.0",
            "4.0.1",
            "4.1.x",

            "4.4",
            "5.0",
            "6.0",
            "7.0",
            "8.0",
            "9.0",
            "10",
            "11",
            "12")
    }
}