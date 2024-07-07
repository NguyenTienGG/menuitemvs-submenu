package com.example.b202

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b202.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Game"

        registerForContextMenu(binding.txtContext)

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //add (int groupId, int itemId, int order, CharSequence title)
        menuInflater.inflate(R.menu.game_menu,menu )
        menu?.add(1,1,3,"Red")
        menu?.add(1,2,2,"Green")
        menu?.add(1,3,1,"Black")


        //sub menu
        var subMenu = menu?.addSubMenu("Gender")
        subMenu?.add(2,21,1,"Male")?.setChecked(true)
        subMenu?.add(2,22,2,"Female")
        subMenu?.setGroupCheckable(2,true,true)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> binding.txtOption.setTextColor(Color.RED)
            2 -> binding.txtOption.setTextColor(Color.GREEN)
            3 -> binding.txtOption.setTextColor(Color.BLACK)


            21-> {binding.txtOption.setText("Male")}
            22-> {binding.txtOption.setText("Felame")}


        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3,31,1,"Red")
        menu?.add(3,32,2,"Green")
        menu?.add(3,33,3,"Black")
        menu?.setHeaderTitle("Select Color")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            31 -> binding.txtContext.setTextColor(Color.RED)
            32 -> binding.txtContext.setTextColor(Color.GREEN)
            33 -> binding.txtContext.setTextColor(Color.BLACK)
        }
        return super.onContextItemSelected(item)
    }

}