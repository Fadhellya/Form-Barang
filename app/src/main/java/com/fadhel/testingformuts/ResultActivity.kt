package com.fadhel.testingformuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    lateinit var kodebarang : TextView
    lateinit var namabarang : TextView
    lateinit var jumlahbarang : TextView
    lateinit var hargabarang : TextView
    lateinit var jenispembayaran : TextView
    lateinit var bonusbarang : TextView
    lateinit var kurir : TextView
    lateinit var tanggalpembayaran : TextView
    lateinit var tagihan : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        kodebarang = findViewById(R.id.txtkodebarang)
        namabarang = findViewById(R.id.txtnamabarang)
        jumlahbarang = findViewById(R.id.txtjumlahbarang)
        hargabarang = findViewById(R.id.txthargabarang)
        jenispembayaran = findViewById(R.id.txtjenispembayaran)
        bonusbarang = findViewById(R.id.txtbonus)
        kurir = findViewById(R.id.txtkurir)
        tanggalpembayaran = findViewById(R.id.txttanggal)
        tagihan = findViewById(R.id.txttagihan)

        val bundle = intent.extras
        if(bundle != null){
            kodebarang.text = "Kode Barang = ${bundle.getString("kodebarang")}"
            namabarang.text = "Nama Barang = ${bundle.getString("namabarang")}"
            jumlahbarang.text ="Jumlah Barang = ${bundle.getString("jumlahbarang")}"
            hargabarang.text = "Harga Barang = ${bundle.getString("hargabarang")}"
            jenispembayaran.text = "Jenis Pembayaran = ${bundle.getString("jenispembayaran")}"
            bonusbarang.text = "Bonus Barang : ${bundle.getString("bonus")}"
            kurir.text="Kurir = ${bundle.getString("kurir")}"
            tanggalpembayaran.text = "Tanggal Pembayaran = ${bundle.getString("tanggalpembayaran")}"
            tagihan.text = "Tagihan Anda : ${bundle.getString("tagihan")}"
        }
    }
}