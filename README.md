# BT_ListView_GridView
Kotlin - Android Studio
KotLin với ListView -- ArrayAdapter

class ListViewAdapter(context: Context?, resource: Int, objects: MutableList<Product>) : ArrayAdapter<Product>(context, resource,  objects) {
    var arrayList : MutableList<Product>
    var layout : Int

    init{

        this.arrayList = objects
        this.layout = resource
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view : View
        var vh : ViewHolderList

        if(convertView == null){
            view  = LayoutInflater.from(context).inflate(layout,null)
            vh = ViewHolderList(view)
            view.tag = vh
        }else{
            view = convertView
            vh = view.tag as ViewHolderList
        }
        vh.txtName.text = arrayList[position].Name
        vh.txtSubName.text = arrayList[position].SubName
        vh.imgName.setImageResource(arrayList[position].ID)
        return view
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}
