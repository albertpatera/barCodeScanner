package com.example.scankitdemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

class InsertActivity : Activity() {
    private lateinit var alert : AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        alert = AlertDialog.Builder(this).create()

    }

    public fun getExcelFileClick(view: View) {
        alert.setMessage("here")
        alert.show()
    }
}