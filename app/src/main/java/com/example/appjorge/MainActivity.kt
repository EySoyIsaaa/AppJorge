package com.example.appjorge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appjorge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.main_screen_title)

        if (savedInstanceState == null) {
            openInicioFragment()
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_inicio -> {
                    openInicioFragment()
                    true
                }

                R.id.bottom_lista -> {
                    openListaFragment()
                    true
                }

                else -> false
            }
        }
    }

    private fun openInicioFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, InicioFragment())
            .commit()
    }

    private fun openListaFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ListaFragment())
            .commit()
    }
}
