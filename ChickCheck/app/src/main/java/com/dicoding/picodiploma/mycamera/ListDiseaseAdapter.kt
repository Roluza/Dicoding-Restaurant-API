package com.dicoding.picodiploma.mycamera

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ListDiseaseAdapter(private val listDisease: ArrayList<DiseaseResponse>) : RecyclerView.Adapter<ListDiseaseAdapter.ListViewHolder>() {

    fun addData(newData: List<DiseaseResponse>) {
        val startPosition = listDisease.size
        listDisease.addAll(newData)
        listDisease.sortBy { it.Penyakit } // Sort the list by disease name
        notifyItemRangeInserted(startPosition, newData.size) // Notify the adapter that new items were added
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_disease, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDisease.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val disease = listDisease[position]
        // Load image using Glide or Picasso
        Glide.with(holder.itemView.context)
            .load(disease.Foto) // Load URI foto
            .into(holder.imgPhoto)

        // Show disease
        holder.tvName.text = disease.Penyakit

        val shortenedDescription = if (disease.Deskripsi?.length?: 0 > 50) {
            "${disease.Deskripsi?.substring(0, 50)}..."
        } else {
            disease.Deskripsi
        }

        val shortenedGejala = if (disease.Gejala?.length ?: 0 > 50) {
            "${disease.Gejala?.substring(0, 50)}..."
        } else {
            disease.Gejala
        }

        val shortenedPenanganan = if (disease.Penanganan?.length ?: 0 > 50) {
            "${disease.Penanganan?.substring(0, 50)}..."
        } else {
            disease.Penanganan
        }

        // Combine shortened text
        holder.tvDescription.text = "Deskripsi: $shortenedDescription\n\nPenaganan: $shortenedPenanganan\n\nGejala: $shortenedGejala"

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailDisease::class.java)
            intent.putExtra("DISEASE_DATA", disease)
            holder.itemView.context.startActivity(intent)
        }

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tvDiseaseName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

}