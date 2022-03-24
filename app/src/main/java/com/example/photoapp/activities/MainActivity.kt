package com.example.photoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.photoapp.R
import com.example.photoapp.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val galleryFragment = GalleryFragment()
    private val photoFragment = PhotoFragment()
    private val settingsFragment = SettingsFragment()
    private lateinit var photoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<GalleryFragment>(R.id.main__fragment_container)
            }
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main__bottom_nav)
        bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.ic_menu__photo -> {
                    replaceFragment(photoFragment)
                    true
                }
                R.id.ic_menu__gallery -> {
                    replaceFragment(galleryFragment)
                    true
                }
                R.id.ic_menu_settings -> {
                    replaceFragment(settingsFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.main__fragment_container, fragment)
            }
        }
}