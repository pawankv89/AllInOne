package com.pk.allinone.model

class MonthTable {
    var name: String? = null
    var english: String? = null
    var hindi: String? = null
    constructor(name: String, english: String, hindi: String) {
        this.name = name
        this.english = english
        this.hindi = hindi
    }

    override fun toString(): String {
        return "{\"name\":\"${this.name}\",\"english\":\"${this.english}\",\"hindi\":\"${this.hindi}\"}"
    }
}