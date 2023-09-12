package com.example.scankitdemo.core
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.scankitdemo.MainActivity
import com.example.scankitdemo.R
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Workbook
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths



class FinalRenderActivity : AppCompatActivity() {
    private var editTextExcel: EditText? = null

    private val filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/output87888.xls")
  //  private val src_file_path = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/stacks.xls")

    //var filePath = File(Environment.getExternalStorageDirectory().toString() + "/output.xls")
      //  get() = fieldFdFfinal
    var filePath = File(Environment.getExternalStorageDirectory().toString() + "Download/Seznam zásob na skladě  Sklad p.xls")
       // get() = field

    // private val filePath = File(getExternalFilesDir(null).toString() + "/Demo.xls")
    private lateinit var alert : AlertDialog
    private lateinit var option : FileOperation

    private lateinit var btnUpload : ImageButton
    private lateinit var data : Data
    private lateinit var leaveManualy : TextView

    var workbook: Workbook = HSSFWorkbook()
    var fileOutputStream = FileOutputStream(filePathRender)
    var tv = TextView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_render)
        option = com.example.scankitdemo.core.FileOperation()
        btnUpload = findViewById(R.id.upload_to_server)
        alert = AlertDialog.Builder(this).create()
        data = Data()
        leaveManualy = findViewById(R.id.leave_manualy)

        //startActivity(Intent(this, FormActivity::class.java))
        try {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ), PackageManager.PERMISSION_GRANTED
            ) } catch (e : Exception) {
                alert.setMessage(e.message)

            //}
            //}

        }
        //editTextExcel = fFuploaindViewById(R.id.editText)
        try {
            //val excel : WriteExcel = WriteExcel()
           // excel.writeExcel(this)
        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
return
        try {
           // option.loadCSVdatam(this, "/output.xls")
            Toast.makeText(this, "compklete", Toast.LENGTH_LONG).show()
        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }

        //return

        btnUpload.setOnClickListener {
            try {
                //alert = AlertDialog.Builder()
                try {
                   // return@setOnClickListener
                //    data.getDataFromCSV(this, workbook)
                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }
                //return@setOnClickListener
                //data.uploadToServerSMB(this, intent, this)

            } catch (e : Exception) {
                alert.setMessage(e.message)
                alert.show()
            }
        }

        leaveManualy.setOnClickListener {
            var activityBack = Intent(this, FinalRenderActivity::class.java)
            data.alertCancelOrExit(this, activityBack)

        }

        try {
           // startActivity(Intent(this, ScannerActivity::class.java))
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE),
            requestCode)
        //
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }



    fun buttonCreateExcel(view: View?) {
        // alert.setMessage("crezt")
        //alert.show()
        val headers = arrayOf("PLU")
        var rows = mutableListOf("12", "777")

        val workbook: Workbook = HSSFWorkbook()
        var fileOutputStream = FileOutputStream(filePath)
        var tv = TextView(this)


      //  var outputFileData = File(getExternalFilesDir(null), "/null.csv").readText()
        option.loadData(this, "úppp", "/Demo3.xls");
        //var data = outputFileData.split("\n")



        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet: HSSFSheet = hssfWorkbook.createSheet("Custom Sheet")
        val hssfRow: HSSFRow = hssfSheet.createRow(0)
        val hssfCell: HSSFCell = hssfRow.createCell(0)
        hssfCell.setCellValue(editTextExcel!!.text.toString())
        var rowCount = 0;
        try {
            if (!filePath.exists()) {
                filePath.createNewFile()
                alert.setMessage("ffdf")
                alert.show()
            } else {
                alert.setMessage("exists")
                alert.show()
            }
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

                    hssfWorkbook.write(fileOutputStream)
                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }

                // hssfWorkbook.write(headers[rn])
                if (fileOutputStream != null) {
                    //fileOutputStream.flush()
                    //fileOutputStream.close()
                }
            }

            for (rn in rows.indices) {
                val r: Row = hssfSheet.createRow(++rowCount)
                // val header: Row = sheet.createRow(0)
                // r.createCell(0).setCellValue("PLU")
                //r.createCell(1).setCellValue("KS")
                //r.createCell(2).setCellValue("Header3")

                 r.createCell(0).setCellValue("12804")
                 r.createCell(1).setCellValue("10")
                //r.createCell(3).setCellValue("Header4")
                // alert.setMessage(tv.text.toString())
                //alert.show()
                try {

                    hssfWorkbook.write(fileOutputStream)
                } catch (e : Exception) {
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






        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
    }

    fun buttonRender(view: View) {
        alert.setMessage("rrr")
        alert.show()
        // return

        //return
        val headers = arrayOf("PLU")
        var rows = mutableListOf("12", "777", "a", "b")

        val workbook: Workbook = HSSFWorkbook()
        var fileOutputStream = FileOutputStream(filePathRender)
        var tv = TextView(this)


        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet: HSSFSheet = hssfWorkbook.createSheet("Custom Sheet")
        val hssfRow: HSSFRow = hssfSheet.createRow(0)
        val hssfCell: HSSFCell = hssfRow.createCell(0)
        hssfCell.setCellValue("rrr")
        var rowCount = 0;
        try {
            if (!filePath.exists()) {
                filePath.createNewFile()
                alert.setMessage("ffdf")
                alert.show()
            } else {
                alert.setMessage("exists")
                alert.show()
            }

            //val bufferedReader = BufferedReader(File(Environment.getExternalStorageDirectory().toString(), "/null.csv"));
            val bufferedReader = Files.newBufferedReader(
                Paths.get(
                    Environment.getExternalStorageDirectory().toString() + "/Download//output.csv"
                )
            );

            var csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)

            var del = "name, 2012, 2017".split(",").toTypedArray()
            try {
                var row = hssfSheet.createRow(del.count())
                var cell = row.createCell(1)
                for (pol in csvParser) {
                    tv.text = tv.text.toString() + del.contentToString() + pol.get(0) + "\n"
                    cell?.setCellValue(tv.text.toString() + del.contentToString() + pol.get(0))
                }
            } catch (e : Exception) {
                alert.setMessage(e.message)
                alert.show()
            }

            alert.setMessage(tv.text.toString())
            alert.show()

            for (rn in rows.indices) {
                //val r: Row = hssfSheet.createRow(++rowCount)
                var del = "name, 2012, 2017".split(",").toTypedArray()
                try {
                    var row = hssfSheet.createRow(del.count())
                    var cell = row.createCell(1)
                    for (pol in csvParser) {
                        tv.text = tv.text.toString() + del.contentToString() + pol.get(0) + "\n"
                        cell?.setCellValue(tv.text.toString() + del.contentToString() + pol.get(0))
                    }
                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }
                // val header: Row = sheet.createRow(0)
                // r.createCell(0).setCellValue("PLU")
                //r.createCell(1).setCellValue("KS")
                //r.createCell(2).setCellValue("Header3")

                //val cell: Cell = r.createCell(++columnCount)



                // tv.text = tv.text.toString() +  r.createCell(0).setCellValue("12804")
                //tv.text = tv.text.toString() +  r.createCell(1).setCellValue("10")
                //r.createCell(3).setCellValue("Header4")
                // alert.setMessage(tv.text)
                //alert.show()
                hssfWorkbook.write(fileOutputStream)

                // hssfWorkbook.write(headers[rn])
                if (fileOutputStream != null) {
                    // fileOutputStream.flush()
                    //fileOutputStream.close()
                }
            }
            try {
                val fileOut = FileOutputStream(filePath)
                workbook.write(fileOut)
                fileOut.close()
                //Toast.makeText(applicationContext, "super je to tady :)))", Toast.LENGTH_LONG).show()

            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            }
            //alert.setMessage(tv.text.toString(ú + "ahoj")
            //alert.show()
            //var del = tv.text.split(';')
//        alert.setMessage(del.contentToString())
            alert.show()

            //for (pol_ in csvParser)
            return

            /*for (rn in headers.indices) {
                val r: Row = hssfSheet.createRow(++rowCount)
                // val header: Row = sheet.createRow(0)
                tv.text = tv.text.toString() +  r.createCell(0).setCellValue("PLU")
                tv.text = tv.text.toString() + r.createCell(1).setCellValue("KS")
                //r.createCell(2).setCellValue("Header3")
               // tv.text = tv.text.toString() + r.createCell(0).setCellValue("12804")
               // tv.text = tv.text.toString() + r.createCell(1).setCellValue("10")

                r.createCell(0).setCellValue("PLU")
                r.createCell(1).setCellValue("KS")
                //r.createCell(3).setCellValue("Header4")

                // hssfWorkbook.write(fileOutputStream)

                // hssfWorkbook.write(headers[rn])
                if (fileOutputStream != null) {
                    //fileOutputStream.flush()
                    //fileOutputStream.close()
                }
            }*/
            // var columnCount = 0;
        }
        catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
    }


    override fun onBackPressed() {
        var activityBack = Intent(this, MainActivity::class.java)
        //data.alertCancelOrExit(this, activityBack)
        try {
            data.alertShow(this)
        } catch (e : Exception){
            alert.setMessage(e.message)

        }
    }


}