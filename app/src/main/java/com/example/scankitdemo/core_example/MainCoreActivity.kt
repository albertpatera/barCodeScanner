package com.example.scankitdemo.core
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
//import com.example.scankitdemo.R
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.scankitdemo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainCoreActivity : AppCompatActivity() {
    private lateinit var insertPieciesTextEdit : EditText
    private lateinit var insertPieciesTextView : TextView
    private lateinit var options : com.example.scankitdemo.core.FileOperation
    private lateinit var appBarConfiguration: AppBarConfiguration
    @SuppressLint("CutPasteId")
   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main_core)
        setContentView(R.layout.activity_inseert)
        //return
        insertPieciesTextEdit = findViewById(R.id.enterPiecesTextEdit)
        insertPieciesTextView = findViewById(R.id.enterPiecesTextEdit)

        val navController = findNavController(R.id.nav_host_fragment_content_inseert)
        appBarConfiguration = AppBarConfiguration(navController.graph)
       // val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_fragment_container_view_id) as NavHostFragment
        //val navController = navHostFragment.navController
        /*val navHostFragment =
           fragmentManager.findFragmentById(R.id.blankFragment) as NavHostFragment
        setupActionBarWithNavController(navHostFragment)*/

        //insertPieciesTextEdit.requestFocus()
        //insertPieciesTextEdit.setSelection(0)
        options = com.example.scankitdemo.core.FileOperation();
        var alertDialog = AlertDialog.Builder(this).create()

        try {
            findNavController(R.id.nav_host_fragment_content_inseert).navigate(R.id.action_FirstFragment_to_SecondFragment)
        } catch (e: Exception) {
            alertDialog.setMessage(e.message)
            alertDialog.show()
        }

        var alert = AlertDialog.Builder(this).create()
        insertPieciesTextEdit.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Toast.makeText(this@MainCoreActivity, "super", Toast.LENGTH_SHORT).show()
                options.loadData(this@MainCoreActivity, insertPieciesTextView!!.text.toString().take(s.count() -1), "/null");
                Toast.makeText(this@MainCoreActivity, "loaded data" + insertPieciesTextView.text.toString(), Toast.LENGTH_LONG).show()
               // alert.setMessage(insertPieciesTextView!!.text.toString().take(s.count() -1));
                //alert.show()
            }
        })

    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inseert)
        //setSupportActionBar(findViewById(R.id.toolbar))
        options = FileOperation()
        val navController = findNavController(R.id.nav_host_fragment_content_inseert)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_inseert)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}