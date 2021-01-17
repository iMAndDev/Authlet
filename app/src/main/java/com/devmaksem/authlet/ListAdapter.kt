package com.devmaksem.authlet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listener: (ListItem) -> Unit) :
    RecyclerView.Adapter<ListAdapter.CodeViewHolder>() {
        var listOfItems = ArrayList<ListItem> ()

        fun setItems(newArrayList: ArrayList<ListItem>) {
            listOfItems.clear()
            listOfItems.addAll(newArrayList)
        }

        inner class CodeViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {

            val itemTitle: TextView = itemView.findViewById(R.id.item_title)
            val itemDesc: TextView = itemView.findViewById(R.id.item_description)
            val itemPicture: ImageView = itemView.findViewById(R.id.item_image)
            val delete: ImageView = itemView.findViewById(R.id.delete_item)
            init {
                itemView.setOnClickListener {

                    /*val clip = ClipData.newPlainText("RANDOM UUID",textToCopy)
                    clipboard.setPrimaryClip(clip)*/

                    //Toast.makeText(this,"Copied to clipboard", Toast.LENGTH_LONG).show()
                }
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CodeViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)

            return CodeViewHolder(view, parent.context)
        }

        override fun onBindViewHolder(holder: CodeViewHolder, position: Int) {
            val codeItem = listOfItems[position]

            holder.itemTitle.text = codeItem.title
            holder.itemDesc.text = codeItem.description
            //holder.itemImage = codeItem.image

            holder.itemView.setOnClickListener{
                listener(codeItem)
            }

            holder.delete.setOnClickListener{
                listOfItems.remove(codeItem)
                notifyDataSetChanged()
            }
        }

        override fun getItemCount(): Int = listOfItems.size

}