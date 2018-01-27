package com.example.vudinhai.bt_listview_gridview

import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by vudinhai on 12/27/17.
 */
class ViewHolderGrid(item : View){
    var txt : TextView = item!!.findViewById(R.id.txtname)
    var img : ImageView = item!!.findViewById(R.id.img)
}