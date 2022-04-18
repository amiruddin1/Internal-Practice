package com.dp.demosqlite

data class Student constructor(var name:String, var age:Int){
    var id:Int = 0;
    constructor(id:Int,name: String,age:Int) :this(name,age)
    {
        this.id = id
    }
}