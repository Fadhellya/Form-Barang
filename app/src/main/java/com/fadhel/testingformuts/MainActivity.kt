package com.fadhel.testingformuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemClickListener,
    AdapterView.OnItemSelectedListener {
    val kurir = arrayOf<String>("JNE","Sicepat","Shoope Express")
    lateinit var kodebarang : EditText
    lateinit var namabarang : EditText
    lateinit var jumlahbarang : EditText
    lateinit var hargabarang : EditText
    lateinit var jenispembayaran : RadioGroup
    lateinit var payung : CheckBox
    lateinit var kulkas : CheckBox
    lateinit var TV : CheckBox
    lateinit var spinkurir : Spinner
    lateinit var tanggalpembelian : DatePicker
    lateinit var pesan : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kodebarang = findViewById(R.id.editkode)
        namabarang = findViewById(R.id.editnamabarang)
        jumlahbarang = findViewById(R.id.editjumlahbarang)
        hargabarang = findViewById(R.id.edithargabarang)
        jenispembayaran = findViewById(R.id.rgjenispembayaran)
        payung = findViewById(R.id.chkpayung)
        kulkas = findViewById(R.id.chkkulkas)
        TV = findViewById(R.id.chktv)
        spinkurir = findViewById(R.id.spinkurir)
        spinkurir.onItemSelectedListener=this
        pesan = findViewById(R.id.btnpesan)
        val arrayAdapter : ArrayAdapter<*> = ArrayAdapter<Any?>(this,R.layout.spinner_style,kurir)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_style)
        spinkurir.adapter=arrayAdapter
        tanggalpembelian = findViewById(R.id.tanggal)
        val tanggal = Calendar.getInstance()
        val tgl = tanggalpembelian.init(
            tanggal.get(Calendar.YEAR),tanggal.get(Calendar.MONTH),tanggal.get(Calendar.DAY_OF_MONTH)) { tanggal, year, month, day ->
            val month = month + 1
            val tanggaldipilih = "$year - $month - $day"
            Toast.makeText(this, "$tanggaldipilih", Toast.LENGTH_SHORT).show()

            pesan.setOnClickListener {
                val Kodebarang = kodebarang.text
                val Namabarang = namabarang.text
                val Jumlahbarang = jumlahbarang.text.toString().toInt()
                val Hargabarang = hargabarang.text.toString().toDouble()
                val pembayaran = jenispembayaran.checkedRadioButtonId
                val Pembayaran = findViewById<RadioButton>(pembayaran)
                val Payung = payung.isChecked
                val Kulkas = kulkas.isChecked
                val Tv = TV.isChecked
                val tagihan = (Jumlahbarang * Hargabarang)
                val bundle = Bundle()
                bundle.putString("kodebarang", Kodebarang.toString())
                bundle.putString("namabarang", Namabarang.toString())
                bundle.putString("jumlahbarang", Jumlahbarang.toString())
                bundle.putString("hargabarang", Hargabarang.toString())
                bundle.putString("kurir", spinkurir.selectedItem.toString())
                bundle.putString("tanggalpembayaran", tanggaldipilih)
                bundle.putString("jenispembayaran", Pembayaran.text.toString())
                bundle.putString(
                    "bonus", (if (Payung) "\nPayung\n" else "") +
                            (if (Kulkas) "Kulkas\n" else "") +
                            (if (Tv) "TV" else "").toString()
                )
                bundle.putString("tagihan", tagihan.toString())
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val toast : String = p0?.getItemAtPosition(p2).toString()
        Toast.makeText(this,"$toast",Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}