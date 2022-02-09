package com.anurag.todocfl

object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(title: String, priority: String) {
        listdata.add(CardInfo(title, priority))
    }

    fun getAllData(): List<CardInfo> {
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }
}