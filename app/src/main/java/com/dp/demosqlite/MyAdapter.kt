package com.dp.demosqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.myrecyclestruct.view.*

class MyAdapter (val context: Context, var arr:ArrayList<Student>)
    : RecyclerView.Adapter<MyAdapter.ViewHolder>()

{
    class ViewHolder(var view: View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Student)
        {
            view.txtRecyclerId.setText(p.id.toString())
            view.txtRecyclerName.setText(p.name.toString())
            view.txtRecyclerAge.setText(p.age.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.myrecyclestruct,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arr[position])
    }

    override fun getItemCount(): Int {
        return arr.size
    }
}