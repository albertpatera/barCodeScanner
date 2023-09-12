package com.example.scankitdemo.core

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.TextView
import android.widget.Toast
//import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.scankitdemo.R
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Workbook
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader

class InseertActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var options : com.example.scankitdemo.core.FileOperation
    private lateinit var alert : AlertDialog
   // private var filePath = File(Environment.getExternalStorageDirectory().toString() + "/output.xls")
    private var filePath = File(Environment.getExternalStorageDirectory().toString() + "/output.xls")
    private var filePathCSV = File(Environment.getExternalStorageDirectory().toString() + "/outputData.csv")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inseert)

        //setSupportActionBar(findViewById(R.id.toolbar))
        options = FileOperation()
        alert = AlertDialog.Builder(this).create()
        alert.setMessage("rerr")
        alert.show()
        return
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

    //fun getExcelFileClick(view: View) {}
    fun buttonCreateExcel(view: View) {
       try {

           startActivity(Intent(this, FinalRenderActivity::class.java))
       } catch (e : Exception) {
           alert.setMessage(e.message)
           alert.show()
       }
    }

    fun buttonCreateXLSX(view: View?) {
        // alert.setMessage("crezt")
        //alert.show()

        val bufferedReader =
            BufferedReader(FileReader(filePathCSV));
        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);
       // var tv = TextView(context)
        val headers = arrayOf("PLU")
        var rows = mutableListOf("rrr", "ee")


        alert.setMessage("rrrrdfdf")



        val workbook: Workbook = HSSFWorkbook()
        var fileOutputStream = FileOutputStream(filePath)
        var tv = TextView(this)


        //var outputFileData = File(getExternalFilesDir(null), "/null.csv").readText()
       // option.loadData(this, "úppp", "/Demo3.xls");
        //var data = outputFileData.split("\n")



        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet: HSSFSheet = hssfWorkbook.createSheet("Custom Sheet")
        val hssfRow: HSSFRow = hssfSheet.createRow(0)
        val hssfCell: HSSFCell = hssfRow.createCell(0)
        //hssfCell.setCellValue(editTextExcel!!.text.toString())
        var rowCount = 0;
        try {

            for (rn in headers.indices) {
                val r: Row = hssfSheet.createRow(++rowCount)
                // val header: Row = sheet.createRow(0)
                //tv.text = tv.text.toString() +
                //tv.text = tv.text.toString() +
                //r.createCell(2).setCellValue("Header3")
                //tv.text = tv.text.toString() + r.createCell(0).setCellValue("12804")
                //tv.text = tv.text.toString() + r.createCell(1).setCellValue("10")
                r.createCell(0).setCellValue("PLU")
                r.createCell(1).setCellValue("Stav zásoby")
                //r.createCell(0).setCellValue("20222")
                //r.createCell(1).setCellValue("20")
                //r.createCell(3).setCellValue("Header4")
                try {

                    //
                    // hssfWorkbook.write(fileOutputStream)
                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }

                // hssfWorkbook.write(headers[rn])
                if (fileOutputStream != null) {
                    //fileOutputStream.flush()
                    //fileOutputStream.close()
                }
            }

            var textView = TextView(this)
            for (item in csvParser) {
                val r: Row = hssfSheet.createRow(++rowCount)
                // val header: Row = sheet.createRow(0)
                // r.createCell(0).setCellValue("PLU")
                //r.createCell(1).setCellValue("KS")
                //r.createCell(2).setCellValue("Header3")
                var textView = TextView(this)
                // r.createCell(0).setCellValue(item.get(0))
                //r.createCell(1).setCellValue(item.get(1))
                textView.text =
                    textView.text.toString() + r.createCell(0).setCellValue(item.get(0))
                textView.text =
                    textView.text.toString() + r.createCell(1).setCellValue(item.get(1))

                //return



                Toast.makeText(this, textView.text.toString(), Toast.LENGTH_LONG).show()
                //r.createCell(0).setCellValue("12804")
                //r.createCell(1).setCellValue("10")
                //r.createCell(3).setCellValue("Header4")
                // alert.setMessage(tv.text.toString())
                //alert.show()
                try {

                    hssfWorkbook.write(fileOutputStream)
                    Toast.makeText(this, "successfully rendered", Toast.LENGTH_LONG).show()
                    options.loadCSVdatam(this, "/outputData.csv");
                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }

                // hssfWorkbook.write(headers[rn])
                if (fileOutputStream != null) {
                    // fileOutputStream.flush()
                    //fileOutputStream.close()
                }
            }


            //alert.setMessage(data.toString() + "hbhgh")
            //alert.show()
            for (item in csvParser) {
                for (rn in rows.indices) {
                    val r: Row = hssfSheet.createRow(++rowCount)
                    // val header: Row = sheet.createRow(0)
                    // r.createCell(0).setCellValue("PLU")
                    //r.createCell(1).setCellValue("KS")
                    //r.createCell(2).setCellValue("Header3")


                    // r.createCell(0).setCellValue(item.get(0))
                    //r.createCell(1).setCellValue(item.get(1))
                    textView.text =
                        textView.text.toString() + r.createCell(1).setCellValue(item.get(0) + "RT")
                    textView.text =
                        textView.text.toString() + r.createCell(0).setCellValue(item.get(1) + "RTG")
                    // textView.text = textView.text.toString() + r.createCell(2).setCellValue(textView.text.))
                    r.createCell(2).setCellValue(textView.text.toString())

                }
            }

                alert.setMessage(textView.text.toString())
            alert.show()
                Toast.makeText(this, textView.text.toString(), Toast.LENGTH_LONG).show()
                //r.createCell(0).setCellValue("12804")
                //r.createCell(1).setCellValue("10")
                //r.createCell(3).setCellValue("Header4")
                // alert.setMessage(tv.text.toString())
                //alert.show()
                try {

                    hssfWorkbook.write(fileOutputStream)
                    Toast.makeText(this, "successfully rendered", Toast.LENGTH_LONG).show()

                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }

                // hssfWorkbook.write(headers[rn])
                if (fileOutputStream != null) {
                    // fileOutputStream.flush()
                    //fileOutputStream.close()
                }
           // }






        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
    }
}