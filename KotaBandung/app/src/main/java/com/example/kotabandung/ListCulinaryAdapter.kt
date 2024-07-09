package com.example.kotabandung

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCulinaryAdapter(private val listCulinary: ArrayList<Culinary>) : RecyclerView.Adapter<ListCulinaryAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var imgPhoto: ImageView = itemView.findViewById(R.id.photoCulinary)
        private var tvName: TextView = itemView.findViewById(R.id.nameCulinary)

        fun bind(culinary: Culinary){
            imgPhoto.setImageResource(culinary.photo)
            tvName.text = culinary.name

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailCulinaryActivity::class.java)
                intent.putExtra("Culinary", culinary)
                itemView.context.startActivity(intent)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_culinary, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listCulinary[position])
    }

    override fun getItemCount(): Int = listCulinary.size
}