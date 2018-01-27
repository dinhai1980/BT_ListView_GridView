package com.example.vudinhai.bt_listview_gridview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.mygridview.*
import kotlinx.android.synthetic.main.mylistview.*

class MainActivity : AppCompatActivity() {

    val VIEW_MODE_LIST : Int = 1
    val VIEW_MODE_GRID : Int = 0

    var currentMode : Int = 0
    lateinit var arrayList : MutableList<Product>

    lateinit var subList : ViewStub
    lateinit var subGrid : ViewStub

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentMode = 1

        arrayList  = mutableListOf()
        arrayList.add(Product(R.drawable.a01,"Cup Cake", resources.getString(R.string.cup_cake)))
        arrayList.add(Product(R.drawable.a02,"Donut", resources.getString(R.string.donut)))
        arrayList.add(Product(R.drawable.a03,"Eclair", resources.getString(R.string.eclair)))
        arrayList.add(Product(R.drawable.a04,"Froyo", resources.getString(R.string.froyo)))
        arrayList.add(Product(R.drawable.a05,"Ginger bread", resources.getString(R.string.ginger_bread)))
        arrayList.add(Product(R.drawable.a06,"Honey comb", resources.getString(R.string.honey_comb)))
        arrayList.add(Product(R.drawable.a07,"Ice cream sandwich", resources.getString(R.string.ice_cream_sandwich)))
        arrayList.add(Product(R.drawable.a08,"Jelly bean", resources.getString(R.string.jelly_bean)))
        arrayList.add(Product(R.drawable.a09,"Kit kat", resources.getString(R.string.kitkat)))
        arrayList.add(Product(R.drawable.a10,"Lollipop", resources.getString(R.string.lollipop)))
        arrayList.add(Product(R.drawable.a11,"Marshmallow", resources.getString(R.string.marshmallow)))
        arrayList.add(Product(R.drawable.a12,"Nougat", resources.getString(R.string.nougat)))
        arrayList.add(Product(R.drawable.a13,"Oreo", resources.getString(R.string.oreo)))

        subList = findViewById(R.id.viewStubList)
        subGrid = findViewById(R.id.viewStubGrid)

        subList.inflate()
        subGrid.inflate()

//        list.adapter = MyAdapter(this, R.layout.row,arrayList)
//        list.setOnItemClickListener { parent, view, pos, id ->
//        Toast.makeText(this,arrayList[pos].Name, Toast.LENGTH_LONG).show()
//            var intent = Intent(this,DetailActivity::class.java)
//            intent.putExtra("android",arrayList[pos])
//            startActivity(intent)
//
//        }


        switchView()

        setEvent()

    }

    private fun setEvent() {
        listView.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("android",arrayList[i])
            startActivity(intent)
        }

        gridView.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("android",arrayList[i])
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.switchItem ){
            if(VIEW_MODE_LIST == currentMode){
                currentMode = VIEW_MODE_GRID
                item.icon = getDrawable(R.drawable.ic_view_module_black_24dp)

            }else{
                currentMode = VIEW_MODE_LIST
                item.icon = getDrawable(R.drawable.ic_view_list_black_24dp)
            }
            switchView()
        }

        return super.onOptionsItemSelected(item)
    }

    class MyListAdapter(context : Context, objects : MutableList<Product>) : BaseAdapter(){

        var context : Context
        var arrayList : MutableList<Product>

        init{
            this.context = context
            arrayList = objects
        }
        override fun getView(p0: Int, convertView: View?, p2: ViewGroup?): View {
            var view : View
            var viewHolder : ViewHolderList
            if(convertView == null){
                view = LayoutInflater.from(context).inflate(R.layout.row,null)
                viewHolder = ViewHolderList(view)
                view.tag = viewHolder
            }else{
                view = convertView
                viewHolder = view.tag as ViewHolderList
            }

            viewHolder.txtName.text = "hello"

            return view
        }

        override fun getItem(p0: Int): Any {
            return arrayList[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return 10
        }

    }

    fun init() {
        //        var arrayList : MutableList<String> = mutableListOf()
//        arrayList.add("Kotlin")
//        arrayList.add("Android")
//        arrayList.add("Swift")
//        arrayList.add("Objective C")
//        arrayList.add("PHP")
//        arrayList.add("C#")
//        arrayList.add("SQL")
//        list.adapter = ArrayAdapter(this,
//                                    android.R.layout.simple_list_item_1,
//                                    arrayList)

//        var arrayList : MutableList<Product> = mutableListOf()
//
//        list.adapter = MyListAdapter(this,arrayList)
    }

    fun switchView() {

        if(VIEW_MODE_LIST == currentMode) {
            //Display listview
            subList.setVisibility(View.VISIBLE);
            //Hide gridview
            subGrid.setVisibility(View.GONE);
        } else {
            //Hide listview
            subList.setVisibility(View.GONE);
            //Display gridview
            subGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    fun setAdapters() {
        if(currentMode == VIEW_MODE_LIST)
            listView.adapter = ListViewAdapter(this,R.layout.row,arrayList)
        else
            gridView.adapter = GridViewAdapter(this, R.layout.cell,arrayList)
    }


}











