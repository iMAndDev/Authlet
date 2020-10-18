package com.devmaksem.authlet

import android.app.LauncherActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class ListAdapter() :
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

            init {
                itemView.setOnClickListener {
                    /*val clipboard = Context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clipboard = Context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager*/
                    val textToCopy = itemTitle.text
                    //ItemTitle is equal to generated hash

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
        }

        override fun getItemCount(): Int = listOfItems.size

}