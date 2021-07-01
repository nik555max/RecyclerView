package com.nikhil.anand.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listItem = generateDummyList(300)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = ListAdapter(listItem)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
//
//        val recyclerView = RecyclerView(this)
//        recyclerView.adapter = ListAdapter(listItem)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
    }

    /*
    *   This method will generate dummy data for our recycler view
     */

    private fun generateDummyList(size: Int): List<ListItem> {
        val list = ArrayList<ListItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_profile
                else -> R.drawable.ic_bank
            }
            val item = ListItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}