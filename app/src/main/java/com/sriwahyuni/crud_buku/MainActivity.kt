package com.sriwahyuni.crud_buku

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sriwahyuni.crud_buku.adapter.BukuAdapter
import com.sriwahyuni.crud_buku.databinding.ActivityMainBinding
import com.sriwahyuni.crud_buku.helper.DbHelper
import com.sriwahyuni.crud_buku.screenpage.TambahDataBuku

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db : DbHelper
    private lateinit var bukuAdapter: BukuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this)
        bukuAdapter = BukuAdapter(db.getAllDataBuku(),this)

        binding.rvDataBuku.layoutManager = LinearLayoutManager(this)
        binding.rvDataBuku.adapter = bukuAdapter

        //silahkan buat detail page
        //ketika diklik item nya akan pindah

        binding.btnPageTambah.setOnClickListener{
            val intent = Intent(this, TambahDataBuku::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val newBuku = db.getAllDataBuku()
        bukuAdapter.refreshData(newBuku)

    }
}