package com.example.app_gorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_gorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 20
            }
        }


        binding.btnClean.setOnClickListener {
            println("Felipe1 " + binding.tieTotal.text)
            println("Felipe1 " + binding.tieNumPeople.text)
        }

        binding.btnDone.setOnClickListener{
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumPeople.text

            if (totalTableTemp?.isEmpty() ==true ||
                nPeopleTemp?.isEmpty() == true
                ) {
                    Snackbar
                        .make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                        .show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = nPeopleTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                binding.tvResult.text = "Total with tips: $totalWithTips"
            }

                binding.btnClean.setOnClickListener{
                    binding.tvResult.text = ""
                    binding.tieTotal.setText("")
                    binding.tieNumPeople.setText("")
                    binding.rbOptionThree.isChecked = false
                    binding.rbOptionOne.isChecked = false
                    binding.rbOptionTwo.isChecked = false
                }

        }
    }
}