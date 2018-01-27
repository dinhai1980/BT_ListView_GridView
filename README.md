##ListView  - GridView - Kotlin

- ArrayAdapter
---
    class ListViewAdapter(context: Context?, resource: Int, objects: MutableList) : ArrayAdapter(context, resource, objects) 
    { 
        var arrayList : MutableList var layout : Int

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

        override fun getCount(): Int{
            return arrayList.size
        }
    }
- ViewHolderList
---
    class ViewHolderList(item : View) {
        var txtName : TextView = item!!.findViewById(R.id.txtName)
        var txtSubName : TextView = item!!.findViewById(R.id.txtSubName)
        var imgName : ImageView = item!!.findViewById(R.id.imgName)
    }
---
