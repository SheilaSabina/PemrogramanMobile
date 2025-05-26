package com.example.project_uas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load Ground Floor fragment by default
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FloorFragment.newInstance("Ground Floor"))
            .commit()

        // Handle floor button clicks
        binding.btnGround.setOnClickListener {
            loadFloor("Ground Floor")
        }
        binding.btnFirst.setOnClickListener {
            loadFloor("1st Floor")
        }
        binding.btnSecond.setOnClickListener {
            loadFloor("2nd Floor")
        }
        binding.btnThird.setOnClickListener {
            loadFloor("3rd Floor")
        }
    }

    private fun loadFloor(floorName: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FloorFragment.newInstance(floorName))
            .commit()
    }
}