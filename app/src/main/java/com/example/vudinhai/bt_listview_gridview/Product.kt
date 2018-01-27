package com.example.vudinhai.bt_listview_gridview

import java.io.Serializable

/**
 * Created by vudinhai on 12/18/17.
 */
class Product : Serializable {
    private var id : Int = 0
    private var name : String = ""
    private var subName : String = ""

    constructor()

    constructor(id: Int, name: String, subName : String) {
        this.id = id
        this.name = name
        this.subName = subName
    }

    public var ID : Int
        get() {
            return id
        }
        set(value) {
            id = value
        }

    public var Name : String
        get() {
            return name
        }
        set(value) {
            name = value
        }

    public var SubName : String
        get() {
            return subName
        }
        set(value) {
            subName = value
        }

    override fun toString(): String {
        return id.toString() + "\n" + name
    }

}