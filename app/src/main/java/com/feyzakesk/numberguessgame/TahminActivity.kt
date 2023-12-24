package com.feyzakesk.numberguessgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.feyzakesk.numberguessgame.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    private var rasgeleSayi = 0
    private var sayac = 5
    lateinit var binding: ActivityTahminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rasgeleSayi= Random.nextInt(101) //0 ile 100 arasında sayı üretecek

        Log.e("Rasgele Sayi ",rasgeleSayi.toString())

        binding.buttonTahmin.setOnClickListener {

            sayac = sayac - 1

            val tahmin = binding.editTextGirdi.toString().toInt()

            if (tahmin==rasgeleSayi){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if (tahmin > rasgeleSayi){
                binding.textViewYardim.text = "Azalt"
                binding.textViewKalanHak.text = "Kalan Hak : $sayac"

            }
            if (tahmin < rasgeleSayi){
                binding.textViewYardim.text = "Arttır"
                binding.textViewKalanHak.text = "Kalan Hak : $sayac"


            }
            if (sayac == 0){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",false)
                finish()
                startActivity(intent)

            }
            binding.editTextGirdi.setText("")


        }
    }
}