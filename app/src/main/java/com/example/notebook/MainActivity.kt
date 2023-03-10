package com.example.notebook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val currentFragment=supportFragmentManager.findFragmentById(R.id.fragment_container)
            if(currentFragment==null)
            {
               val fragment=NootListFragment.newInstance()
               supportFragmentManager.beginTransaction().
               add(R.id.fragment_container,fragment).commit()
            }
        }
}