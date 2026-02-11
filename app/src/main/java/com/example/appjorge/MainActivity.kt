package com.example.appjorge

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appjorge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupDrawer()
        setupBottomNavigation()
        setupMenuCards()
        setupButtons()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.contentMain.toolbar)
        supportActionBar?.title = getString(R.string.main_screen_title)
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.contentMain.toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener { item ->
            val message = when (item.itemId) {
                R.id.nav_inicio -> getString(R.string.drawer_inicio)
                R.id.nav_reportes -> getString(R.string.drawer_reportes)
                R.id.nav_configuracion -> getString(R.string.drawer_configuracion)
                else -> getString(R.string.app_name)
            }
            showToast(getString(R.string.selected_option, message))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setupBottomNavigation() {
        binding.contentMain.bottomNav.setOnItemSelectedListener { item ->
            val label = when (item.itemId) {
                R.id.bottom_home -> getString(R.string.bottom_home)
                R.id.bottom_notificaciones -> getString(R.string.bottom_notificaciones)
                R.id.bottom_perfil -> getString(R.string.bottom_perfil)
                else -> getString(R.string.app_name)
            }
            binding.contentMain.tvSelectedSection.text =
                getString(R.string.selected_option, label)
            true
        }
    }

    private fun setupMenuCards() {
        val options = listOf(
            MenuOption(
                title = getString(R.string.card_menu_1_title),
                description = getString(R.string.card_menu_1_desc)
            ),
            MenuOption(
                title = getString(R.string.card_menu_2_title),
                description = getString(R.string.card_menu_2_desc)
            ),
            MenuOption(
                title = getString(R.string.card_menu_3_title),
                description = getString(R.string.card_menu_3_desc)
            )
        )

        val adapter = MenuOptionAdapter(options) { option ->
            showToast(getString(R.string.selected_option, option.title))
        }

        binding.contentMain.recyclerOptions.layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerOptions.adapter = adapter
    }

    private fun setupButtons() {
        binding.contentMain.btnPrimaryAction.setOnClickListener {
            showToast(getString(R.string.primary_action_message))
        }

        binding.contentMain.btnSecondaryAction.setOnClickListener {
            showToast(getString(R.string.secondary_action_message))
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
