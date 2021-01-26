# Recyclerview

### Membuat Model
`Product.kt`

```kotlin
data class Product(val nama: String, val harga: String)
```

### Membuat Adapter
`CustomAdapter.kt`

```kotlin
class CustomAdapter(private val dataSet: ArrayList<Product>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama: TextView = view.findViewById(R.id.nama_barang)
        val harga: TextView = view.findViewById(R.id.harga_barang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_product, parent, false)

        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text = dataSet[position].nama
        holder.harga.text = dataSet[position].harga
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
```

### Membuat layout item
`row_product.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:card_view="http://schemas.android.com/apk/res-auto"
    android:layout_margin="2dp"
    card_view:cardUseCompatPadding="true"
    card_view:layout_constraintCircleRadius="5dp"
    card_view:cardPreventCornerOverlap="true"
    card_view:cardCornerRadius="8dp">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="8dp"
        android:id="@+id/row_body">

        <TextView
            android:id="@+id/nama_barang"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Nama barang"/>
        <TextView
            android:id="@+id/harga_barang"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Rp. 20.000,-"/>
    </LinearLayout>
</androidx.cardview.widget.CardView>
```

### Membuat objek Recyclerview di Activity
`activity_main.xml`
```xml
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/recycler_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

`MainActivity.kt`
```kotlin
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
```