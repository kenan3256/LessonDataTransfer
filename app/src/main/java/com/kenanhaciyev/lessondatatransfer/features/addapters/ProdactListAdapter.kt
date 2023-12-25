package com.kenanhaciyev.lessondatatransfer.features.addapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kenanhaciyev.lesson03mydatatransfer.model.Prodact
import com.kenanhaciyev.lessondatatransfer.R
import com.kenanhaciyev.lessondatatransfer.databinding.ListItemProductBinding

class ProdactListAdapter(val context:Context, private var datalist:MutableList<Prodact>):BaseAdapter() {
    override fun getCount(): Int {
     return 50 // datalist.count()
    }

    override fun getItem(position: Int): Any {
       return "" //datalist[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var newconvertView = convertView

       var holder:ViewHolder

        if(newconvertView==null){
            var binding: ListItemProductBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item_product,
                parent,
                false

            )
            newconvertView=binding.root
            holder = ViewHolder(binding)
            holder.bind(datalist[position])

            newconvertView?.tag = holder

            return binding.root
        }else{

            holder= newconvertView.tag as ViewHolder


        }
      return newconvertView


    }
    private class ViewHolder(var binding: ListItemProductBinding){

        fun bind(prodact:Prodact){
            binding.prodactCode.id=prodact.id
            binding.prodactName.text=prodact.name
            binding.prodactdescription.text=prodact.description

        }

    }
}