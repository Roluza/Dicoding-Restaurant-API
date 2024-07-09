package com.example.kotabandung

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTourAdapter(private val listTours: ArrayList<Tours>) : RecyclerView.Adapter<ListTourAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var imgPhoto: ImageView = itemView.findViewById(R.id.photoTour)
        private var tvName: TextView = itemView.findViewById(R.id.nameTour)

        fun bind(tours: Tours){
            imgPhoto.setImageResource(tours.photo)
            tvName.text = tours.name

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("Tours", tours)
                itemView.context.startActivity(intent)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tour, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTours[position])
    }

    override fun getItemCount(): Int = listTours.size

}