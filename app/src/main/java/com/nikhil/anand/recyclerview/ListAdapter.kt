package com.nikhil.anand.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listItem : List<ListItem>) : RecyclerView.Adapter<ListViewHolder>() {
    //This is for inflating the views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false)

        return ListViewHolder(itemView)
    }

    // This method inflate the actual data on the views
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //find the current item by using the position
        val currentItem = listItem[position]

        holder.imageView.setImageResource(currentItem.image)
        holder.textViewOne.text = currentItem.lineOne
        holder.textViewTwo.text = currentItem.lineTwo
    }

    // This fun returns the size of our data list
    override fun getItemCount(): Int {
        return listItem.size
    }
}

/*
*   This view holder class we are using for the caching purpose.
 */
class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val imageView : ImageView = itemView.findViewById(R.id.image_view)
    val textViewOne : TextView = itemView.findViewById(R.id.line_one)
    val textViewTwo : TextView = itemView.findViewById(R.id.line_two)
}