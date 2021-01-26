package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: ArrayList<Product>, private val onClick: (Int, Product)->Unit) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View, val onClick: (Int, Product) -> Unit) : RecyclerView.ViewHolder(view) {
        val nama: TextView = view.findViewById(R.id.nama_barang)
        val harga: TextView = view.findViewById(R.id.harga_barang)
        val body: LinearLayout = view.findViewById(R.id.row_body)
        val tambahBtn: Button = view.findViewById(R.id.tambahBtn)
        val hapusBtn: Button = view.findViewById(R.id.hapusBtn)

        lateinit var currentProduct: Product

        init {
            body.setOnClickListener { onClick(0, currentProduct)}
            tambahBtn.setOnClickListener { onClick(1, currentProduct)}
            hapusBtn.setOnClickListener { onClick(2, currentProduct)}
        }

        fun current(product: Product) {
            currentProduct = product
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_product, parent, false)

        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.current(dataSet[position])
        holder.nama.text = dataSet[position].nama
        holder.harga.text = dataSet[position].harga
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}