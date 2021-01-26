package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val dataset = ArrayList<Product>()
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataset.add(Product("Rinso", "15.000"))
        dataset.add(Product("Indomie", "1.200"))
        dataset.add(Product("Kecap", "300"))

        adapter = CustomAdapter(dataset, ::click)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun click(num: Int, product: Product) {
        when(num) {
            1 -> {
                dataset.add(product)
                adapter.notifyDataSetChanged()
            }
            2 -> {
                dataset.remove(product)
                adapter.notifyDataSetChanged()
            }
            else -> Toast.makeText(this.applicationContext, product.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
