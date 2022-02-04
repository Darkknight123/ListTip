package com.example.listtip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.listtip.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener{calculateTip()}
    }

    fun calculateTip(){
        val stringInTextField =  binding.cost.text.toString()
        val cost = stringInTextField.toDouble()
        val selectId =binding.radioGroup.checkedRadioButtonId

        val tipPercentage = when (selectId){
            R.id.radio1 -> 0.20
            R.id.radio2 -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.rounupSwitch.isChecked
        if (roundUp){
            tip = kotlin.math.ceil(tip)
        }
        val formatedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formatedTip)
    }
}

