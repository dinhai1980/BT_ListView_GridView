package com.example.vudinhai.bt_listview_gridview

import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by vudinhai on 12/27/17.
 */
class ViewHolderList(item : View) {
    var txtName : TextView = item!!.findViewById(R.id.txtName)
    var txtSubName : TextView = item!!.findViewById(R.id.txtSubName)
    var imgName : ImageView = item!!.findViewById(R.id.imgName)
}