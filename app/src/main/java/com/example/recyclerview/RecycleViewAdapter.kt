package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.find

class RecyclerViewAdapter(private val context: Context):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    val items: MutableList<CharacterData> =mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_character_data_cell,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.charaImage.setImageResource(item.characterImageResource)
        holder.charaNameTextView.text = item.characterName
        holder.codenameTextView.text = item.codeName
        holder.charaDetailTextView.text = item.description

    }

    fun addAll(items: List<CharacterData>){
            this.items.addAll(items)
            notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val charaImage: ImageView=view.findViewById(R.id.characterImageView)
        val charaNameTextView: TextView =view.findViewById(R.id.characterNameTextView)
        val codenameTextView: TextView=view.findViewById(R.id.codenameTextView)
        val charaDetailTextView:TextView=view.findViewById(R.id.descriptionTextView)
    }
}




