package com.example.kotlin_model.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.kotlin_model.R
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()

            val todoEditFragment = ToDoEditFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content_main, todoEditFragment, todoEditFragment.javaClass.simpleName)
                    .addToBackStack(todoEditFragment.javaClass.simpleName)
                    .commit()

            hindFab()
        }
    }


    override fun onResume() {
        super.onResume()
        val todoListFragment = TodoListFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.content_main, todoListFragment, todoListFragment.javaClass.simpleName)
                .addToBackStack(todoListFragment.javaClass.simpleName)
                .commit()
    }

    open fun hindFab() {
        fab.hide()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
