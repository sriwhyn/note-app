package com.sriwahyuni.crud_buku.screenpage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sriwahyuni.crud_buku.R
import com.sriwahyuni.crud_buku.databinding.ActivityTambahDataBukuBinding
import com.sriwahyuni.crud_buku.helper.DbHelper
import com.sriwahyuni.crud_buku.model.ModelBuku

class TambahDataBuku : AppCompatActivity() {
    //binding:secara ringkasuntuk kita deklarasi variabel
    private lateinit var binding: ActivityTambahDataBukuBinding
    private lateinit var db : DbHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTambahDataBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)



        db = DbHelper(this)
        binding.btnTambahData.setOnClickListener{
            val penulis = binding.txtInputPenulis.text.toString()
            val isi = binding.txtInputIsi.text.toString()

            //karena nim --> int jadi kita perlu convert dari string ke int
            //toInt()
            val dataBuku = ModelBuku(0, penulis, isi, "Tereliye" )
            db.insertDataBuku(dataBuku)
            finish();
            Toast.makeText(this,"Berhasil Tambah Data",
                Toast.LENGTH_SHORT).show()
        }

    }
}