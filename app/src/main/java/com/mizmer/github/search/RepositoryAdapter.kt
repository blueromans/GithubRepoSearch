package com.mizmer.github.search

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class RepositoryAdapter(private val context: Context,
                    private val dataSource: ArrayList<Item>?) : BaseAdapter() {

     val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return dataSource!!.size
    }

    //2
    override fun getItem(position: Int): Item? {
        return dataSource?.get(position)
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    //4
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_repository, parent, false)
        val usernameTextView = rowView.findViewById(R.id.repository_list_username) as TextView
        val nameTextView = rowView.findViewById(R.id.repository_list_name) as TextView
        val thumbnailImageView = rowView.findViewById(R.id.repository_list_thumbnail) as ImageView
        val repo = getItem(position) as Item
        usernameTextView.text = repo.owner.login
        nameTextView.text = repo.name

        Picasso.get().load(repo.owner.avatar_url).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)
        return rowView
    }
}