package com.example.scankitdemo.core

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.scankitdemo.DefinedActivity
import com.example.scankitdemo.DisPlayActivity
import com.example.scankitdemo.MainActivity
import com.example.scankitdemo.MainActivity.Companion.REQUEST_CODE_SCAN_ONE
import com.example.scankitdemo.R
import com.example.scankitdemo.action.*
import com.huawei.hms.hmsscankit.ScanUtil
import com.huawei.hms.hmsscankit.WriterException
import com.huawei.hms.ml.scan.HmsBuildBitmapOption
import com.huawei.hms.ml.scan.HmsScan
//import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions
//import kotlinx.android.synthetic.main.data_single_item.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class TenpActivity : Activity() {
    private lateinit var demoActivity : DisPlayActivity
    private lateinit var options : FileOperation
    private lateinit var tv : TextView
    companion object {
        const val BITMAP = 0x22
        const val REQUEST_CODE_PHOTO = 0x33
        const val BitmapSave = 2
        const val TAG = "MainActivity"
        const val REQUEST_CODE_SCAN_ONE = 0X01
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenp)
        options = FileOperation()
        tv = findViewById(R.id.resultView)
        tv.text = "eeeee"

        var alert = AlertDialog.Builder(this).create()
        //return

        try {

            //options.loadData(this, "Error" + tv.text + "++", "/test.int.txt")

            try {
               // startActivity(Intent(this@TenpActivity, MainActivity::class.java))
            } catch (e : Exception) {
                alert.setMessage(e.message)
                alert.show()
            }

            //startActivity(Intent(this@TenpActivity, com.example.scankitdemokotlin.MainActivity::class.java))
        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        try {
            //demoActivity = DisPlayActivity()
            ScanUtil.startScan(this, REQUEST_CODE_SCAN_ONE, null);
           // alert.setMessage(tv.text.toString())
            //alert.show()


           // var hms = HmsScan()
            val obj: HmsScan = intent.getParcelableExtra(ScanUtil.RESULT)!!
            try {
                alert.setMessage("eee")
                alert.show()
                //valueFillIn(obj)
            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            }

            try {
                options.loadData(this, obj.toString(), "/null")
            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            }
            return
            //alert.setMessage(hms.getOriginalValue())
            alert.show()

            return
            //demoActivity.valueFillIn(hms)


        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }

    }

    fun newViewBtnClick(view: View?) {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            BITMAP)
    }

    fun saveImageBitmapBtnClick(view: View) {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            BitmapSave)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setMessage("eee")
        alertDialog.show()
        if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            return
        }
        if (requestCode == TenpActivity.BITMAP) {
            // Call the system album.
            val pickIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            this@TenpActivity.startActivityForResult(pickIntent, REQUEST_CODE_PHOTO)
        }


        if (requestCode == TenpActivity.BitmapSave) {
            // Insert the QR to the system album.
            alertDialog.setMessage("External storage")
            alertDialog.show()
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                alertDialog.setMessage("Permission: " + permissions[0] + "was " + grantResults[0])
                alertDialog.show()
                val content = "TEST QR"
                val type = HmsScan.QRCODE_SCAN_TYPE
                val width = 400
                val height = 400
                val options = HmsBuildBitmapOption.Creator().setBitmapBackgroundColor(Color.RED).setBitmapColor(
                    Color.BLUE).setBitmapMargin(3).create()
                try {
                    // If the HmsBuildBitmapOption object is not constructed, set options to null.
                    val qrBitmap = ScanUtil.buildBitmap(content, type, width, height, options)
                    //saveToGallery(applicationContext,qrBitmap,"HuaweiScanKitAlbum")
                    saveToGallery(applicationContext,qrBitmap,"HuaweiScanKitAlbum")
                    Toast.makeText(applicationContext,"QR Code is created",Toast.LENGTH_LONG).show()
                } catch (e: WriterException) {
                    alertDialog.setMessage("buildBitmap")
                    alertDialog.show()
                }

            } else {
                alertDialog.setMessage("prolem")
                alertDialog.show()
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //Receive result
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK || data == null) {
            return
        }
        if (requestCode == MainActivity.REQUEST_CODE_SCAN_ONE) {
            val hmsScan: HmsScan? = data.getParcelableExtra(DefinedActivity.SCAN_RESULT)
            if (hmsScan != null && !TextUtils.isEmpty(hmsScan.getOriginalValue())) {
                Toast.makeText(this@TenpActivity, hmsScan.getOriginalValue(), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun saveToGallery(context: Context, bitmap: Bitmap, albumName: String) {
        val filename = "${System.currentTimeMillis()}.png"
        val write: (OutputStream) -> Boolean = {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
                put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DCIM}/$albumName")
            }

            context.contentResolver.let {
                it.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)?.let { uri ->
                    it.openOutputStream(uri)?.let(write)
                }
            }
        } else {
            val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator + albumName
            val file = File(imagesDir)
            if (!file.exists()) {
                file.mkdir()
            }
            val image = File(imagesDir, filename)
            write(FileOutputStream(image))
        }
    }

    private fun getImagePath(context: Context, data: Intent): String? {
        var imagePath: String? = null
        val uri = data.data
        val currentAPIVersion = Build.VERSION.SDK_INT
        if (currentAPIVersion > Build.VERSION_CODES.KITKAT) {
            imagePath = getImagePath(context, uri)
        }
        return imagePath
    }

    @SuppressLint("Range")
    private fun getImagePath(context: Context, uri: Uri?): String? {
        var path: String? = null
        val cursor = context.contentResolver.query(uri!!, null, null, null, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            }
            cursor.close()
        }
        return path
    }
    /*public fun valueFillIn(hmsScan: HmsScan?) {
        var alertDialog = AlertDialog.Builder(this).create()
        options = FileOperation()

         tv = findViewById(R.id.resultView)

        //tv.text = hmsScan!!.getOriginalValue()

        alertDialog.setMessage("++" + tv.text.toString())
        alertDialog.show()
        try {
            val obj: HmsScan = intent.getParcelableExtra(ScanUtil.RESULT)!!
            try {
                alertDialog.setMessage("here i am ")
                alertDialog.show()
                valueFillIn(obj)

                //startActivity(Intent(this@TenpActivity, com.example.scankitdemokotlin.DisPlayActivity::class.java))
            } catch (e: Exception) {
                alertDialog.setMessage(e.message)
                alertDialog.show()
            }

            options.loadData(this, "Error" + tv.text + "++", "/test.int.txt")
        } catch (e : Exception) {
            alertDialog.setMessage(e.message)
            alertDialog.show()
        }


    }*/
}