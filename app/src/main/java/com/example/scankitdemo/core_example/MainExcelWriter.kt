package com.example.scankitdemo.core

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.*
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.scankitdemo.MainActivity
import com.example.scankitdemo.R
import kotlinx.coroutines.internal.SynchronizedObject
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


/**
 * Writes the value "TEST" to the cell at the first row and first column of worksheet.
 */
class MainExcelWriter {
    var workbook: Workbook = HSSFWorkbook()
    lateinit var row : Row
   // lateinit var context : Context
    public fun writeToExcelFile(filepath: String, data : String, context: Context, dataPcs : String) {

     /*  var recordsToWrite: List<ItemEntity> = mutableListOf<ItemEntity>(
           ItemEntity("Charles", "Babej", "60"),
           ItemEntity("John", "Doe", "70"),
           ItemEntity("Loreum", "Ipsum", "80")
       )*/
     //  Toast.makeText(context, recordsToWrite.toString(), Toast.LENGTH_SHORT).show()
        //Instantiate Excel workbook:
       // return
       var header = mutableListOf("plu", "kusy")
       var arrayData = mutableListOf(data)
        try {
            //context = Context(this);
            //val xlWb = XSSFWorkbook()
            workbook.createSheet("Ahoj") as HSSFSheet
             //workbook.createRow(rownum++)
            var sheet = workbook.createSheet("Ahoj 2") as HSSFSheet
            var rows = sheet.createRow(arrayData.count())
            var tvPLU = TextView(context)
            var tvPCS = TextView(context)
            //for (head : Any  in header) {
            for (head : Any  in header) {
               /* tv.text =  buildString {
        append(header[0])
        append(tv.text.toString()) // rows.createCell(0).setCellValue("plu")*/
        rows.createCell(0).setCellValue("plu")
        rows.createCell(1).setCellValue("kusy")
                    Toast.makeText(context, head.toString(), Toast.LENGTH_SHORT).show()
        // rows.createCell(2).setCellValue("plu")
        //rows.createCell(0).setCellValue(head[0].toString())
        //rows.createCell(1).setCellValue(header[1])
        }

               // rows.createCell(0).setCellValue("plu")
                //rows.createCell(1).setCellValue("kusy")
               // rows.createCell(2).setCellValue("plu")
                //rows.createCell(0).setCellValue(head[0].toString())
                //rows.createCell(1).setCellValue(header[1])
                //rows.createCell(2).setCellValue(tv.text.toString())

            //}



           // rows.createCell(2).setCellValue(data);
             var counter = sheet.lastRowNum + 1;
            for (data : String in arrayData) {
                counter++

                //rows.lastRow

                //sheet.lastRowNum
           //     rows.rowNum
                val row2: Row = sheet.createRow(counter++)
                var rows1 = sheet.createRow(counter++ +1)
                //rows.createCell(counter++ + 1).setCellValue(data)
                //rows1.createCell(0).setCellValue(data)
                rows1.createCell(0).setCellValue(data)
               // var data = mutableListOf<String>("100,12").toString()
                //rows1.createCell(1).setCellValue(.split().toString())
                 var split : String = data.split(',').toString()
              //  Toast.makeText(context, split, Toast.LENGTH_SHORT).show()
                for (splitData in split) {
                    Toast.makeText(context, split.toString() + "\n", Toast.LENGTH_SHORT).show()
                }

               //  data = "Kotlin TutorialsepTutorial KartsepExamples"
                var delimiter = "sep"

                val parts = data.split(',')
                var cellNum = 0;
                Toast.makeText(context, parts.toString(), Toast.LENGTH_SHORT).show()
               //var cell : Cell = rows1.createCell(11)
                rows1.createCell(3).setCellValue(dataPcs)
                //rows1.createCell(cellNum++).setCellValue(recordsToWrite[counter].toString())
               // cell.setCellValue("tttt")
                //print(parts
            //rows1.createCell(1).setCellValue(.split().toString())
            //var dd = arrayOf(recordsToWrite)
                //Toast.makeText(context, dd.get(0).toString(), Toast.LENGTH_SHORT).show()
                /*for(  datas in dd) {
                    //tvPLU.text = tvPLU.text.toString() + "\n" + datas.firstName
                  //  T//oast.makeText(context, dd.get(1).toString(), Toast.LENGTH_SHORT).show()

                    val cellPLU : Cell = rows1.createCell(counter++)
                   // rows1.createCell(cellPLU.rowIndex+1).setCellValue(datas.firstName)
              //  rows1.createCell(1).setCellValue(.age.toString())
                    //cellPLU.setCellValue(datas.age.toString())
                }*/

                //rows.createCell()

            }



            val outputStream = FileOutputStream(filepath)
            workbook.write(outputStream)

            workbook.close()
            val factory = LayoutInflater.from(context)
            //val view: View = factory.inflate(R.layout.activity_form, null)
            //val PLUtext : TextView = view.findViewById(R.id.)
            alertShow(context, data, null, null)

        } catch (e : Exception) {
          //  Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

        return
        //Instantiate Excel worksheet:
       // return
      //  val xlWs = xlWb.createSheet()

        //Row index specifies the row in the worksheet (starting at 0):
        val rowNumber = 0
        //Cell index specifies the column within the chosen row (starting at 0):
        val columnNumber = 0

        //Write text value to cell located at ROW_NUMBER / COLUMN_NUMBER:
       // xlWs.createRow(rowNumber).createCell(columnNumber).setCellValue("TEST")

        //Write file:

    }

//}

    /**
     * Reads the value from the cell at the first row and first column of worksheet.
     */


    public fun getSaveQuestion() {
        var questionDialog = Data()
      //  questionDialog.alertCancelOrExit()
    }

    public fun createBarcodeDirectory(context: Context) {
        try {


            Files.createDirectories(Paths.get(Environment.getExternalStorageState() + "/Download"))
        } catch (e : Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    public fun alertShow(context: Context, data: String, dataPLU : TextView?, dataPCS : TextView?) {
        val alertadd = AlertDialog.Builder(context, R.style.ThemeAppBarcode)
        val factory = LayoutInflater.from(context)
        val view: View = factory.inflate(R.layout.activity_form, null)
        val displayData = view.findViewById<TextView>(R.id.textViewBar)
        val displayTitle = view.findViewById<TextView>(R.id.enterPocet)
        val enterData = view.findViewById<TextView>(R.id.editTextTextPersonName)
        var buiderDialog = alertadd.create()
        //val data = MainExcelWriter()
        var filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");
        if(!filePathRender.exists()) {
            filePathRender.createNewFile()
        }
        alertadd.setView(view)
        //alertadd.setTitle("zadej počet kusů")
        alertadd.setCancelable(false)
        alertadd.setNegativeButton(
            "           ↺ POKRAČOVAT!"
        ) { dlg, sumthin ->
          /*  if(enterData.text.isEmpty()) {
                Toast.makeText(context, "Invalid code", Toast.LENGTH_LONG).show()
                alertadd.show()

                return@setNegativeButton

            }*/

            var mainCoreExcel = MainExcelWriter()
            //mainCoreExcel.writeToExcelFile(filepath = filePathRender.absolutePath, displayData.text.toString(), context, dataPCS!!.text.toString())
       //     mainCoreExcel.writeToExcelFile(filepath = filePathRender.absolutePath, rawResult!!.text.toString(), this, enterPCS.text.toString())

            //  data.writeToExcelFile(filepath = filePathRender.absolutePath, data = "ss", context = context)
           // ActivityCompat.startActivity(context, Intent(context, DisPlayActivity::class.java), Bundle())
            //try {
            var excelDataWriterPlugin = com.example.scankitdemo.core.writeXls()


            try {
                /*var recordsToWritehjj: List<ItemEntity> = mutableListOf<ItemEntity>(
                    //ItemEntity("Charles", "Babej", "60"),
                    //ItemEntity("John", "Doe", "70"),
                  //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                    ItemEntity(enterData.text.toString(), data, "80")
                )*/
               /* var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                    //ItemEntity("Charles", "Babej", "60"),
                    //ItemEntity("John", "Doe", "70"),
               0     //  ItemEntity("Loreum", "rrrrr", "80"),
                    //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                    ItemEntity(enterData.text.toString(), data, "80")
                )*/
                val intent : Intent = Intent()
                //intent.putExtra("enterPCS", "rčrčrčrčrč".toString())
               //@TODO tady to je bellow
               // excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)
            } catch (e : Exception) {
                //alertadd.setMessage("ttttt")
                //alertadd.show()
                val alert = AlertDialog.Builder(context)
                alert.setMessage(e.message)
                alert.show()
            }
            displayData.visibility = View.VISIBLE
          //  Toast.makeText(context, enterData.text.toString() + "tttt", Toast.LENGTH_SHORT).show()

            var workbook: Workbook = HSSFWorkbook()

            var filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");
            /*if(!filePathRender.exists()) {
                filePathRender.createNewFile()F
                Toast.makeText(context, "file test created", Toast.LENGTH_SHORT).show()
            }*/
            var writer = com.example.scankitdemo.core.writeXls()
            var listDataToInsert: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                ItemEntity(enterData.text.toString().toInt(), data.toInt(), "8000", enterData.text.toString().toInt())
            )
            try {
                writer.appendRows(listDataToInsert, filePathRender.absoluteFile)
                Toast.makeText(context, listDataToInsert.toString(), Toast.LENGTH_LONG).show()
            } catch (e : Exception) {
               // Toast.makeText(context, "rrrrtgrfg", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            } finally {
               // writer.appendRows(listDataToInsert, filePathRender.absoluteFile)
                var continueScanning = Intent(context, MainActivity::class.java)
                //Thread.sleep(10_000)
              //  ActivityCompat.startActivity(context, continueScanning, Bundle())
            }
            var continueScanning = Intent(context, MainActivity::class.java)
            //ActivityCompat.startActivity(context, continueScanning, Bundle())

            return@setNegativeButton



            //tady cac 2
            var file = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls")
            var recordsDataToWriteToExcelPLUKS2: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
            )
            excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS2, filePathRender.absoluteFile)
            //Toast.makeText(context, "writer", Toast.LENGTH_SHORT).show()
            var recordsDataToWriteToExcelPLUKS7: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
            )
            excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS7, filePathRender.absoluteFile)
            var coreStart4 = Intent(context, MainActivity::class.java)



            if(enterData.text.isEmpty()) {
                Toast.makeText(context, "error 0 files", Toast.LENGTH_SHORT).show()
                alertadd.show()
                return@setNegativeButton
            } else {

                ActivityCompat.startActivity(context, coreStart4, Bundle())
            }
           //tttghgehgj return@setNegativeButton
            try {
                //if(file.exists()) {
                    // file.renameTo(File(Environment.getExternalStorageDirectory().toString() + "/Download", "/impO" + getTime("yyyy-MM-dd HH:mm") + ".xls"))
                   // file.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", "/folder_name/output"), "/impO" + System.currentTimeMillis() + ".xls"))
                    var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                        //ItemEntity("Charles", "Babej", "60"),
                        //ItemEntity("John", "Doe", "70"),
                        //  ItemEntity("Loreum", "rrrrr", "80"),
                        //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                        ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
                    )
                    excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)
                    Toast.makeText(context, "super", Toast.LENGTH_SHORT).show()
               // } else {
                    //file.createNewFile()
                    return@setNegativeButton
                    val file2 = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls")
                    file2.createNewFile()
                    val writer = com.example.scankitdemo.core.writeXls()
                    var recordsToWriteInitHeader: List<ItemEntity> = mutableListOf<ItemEntity>(
                        //ItemEntity("Charles", "Babej", "60"),
                        //ItemEntity("John", "Doe", "70"),
                        //  ItemEntity("Loreum", "rrrrr", "80"
                        //),
                        //ItemEntity("id", "plu", "80", 8)
                    )
                    try {

                        writer.appendRows(recordsToWriteInitHeader, file.absoluteFile)
                        // writer.appendRows()
                    } catch (e : Exception) {
                        Toast.makeText(context, "rrrrrr", Toast.LENGTH_SHORT).show()
                    }
               // }

            } catch (e : Exception) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            }
            //tady zac
            return@setNegativeButton
            if (!filePathRender.exists()) {
                filePathRender.createNewFile()
                val writer = com.example.scankitdemo.core.writeXls()
                var recordsToWriteInitHeader: List<ItemEntity> = mutableListOf<ItemEntity>(
                    //ItemEntity("Charles", "Babej", "60"),
                    //ItemEntity("John", "Doe", "70"),
                    //  ItemEntity("Loreum", "rrrrr", "80"
                    //),
                    //ItemEntity("id", "plu", "80", 8)
                )
                var he = mutableListOf("plu", "kusy")
                try {
                    var sheet = workbook.createSheet("Ahoj 2") as HSSFSheet
                    var rows = sheet.createRow(he.count())
                    rows.createCell(0).setCellValue("plu")
                    rows.createCell(1).setCellValue("kusy")
                    try {
                        val fileOut = FileOutputStream(filePathRender)
                        workbook.write(fileOut)
                        fileOut.close()
                    } catch (e: Exception) {
                        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    }
                    writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                    Toast.makeText(context, "file ppending successed", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            } else {
               val writer = com.example.scankitdemo.core.writeXls()
                var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                    //ItemEntity("Charles", "Babej", "60"),
                    //ItemEntity("John", "Doe", "70"),
                    //  ItemEntity("Loreum", "rrrrr", "80"),
                    //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                    ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
                )
                excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)
            }
               // mainCoreExcel.writeToExcelFile(filePathRender.absolutePath, displayData!!.text.toString(), context, enterData!!.text.toString())
            var questionDialogBuilder = Data()
            var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
            )


            //tady zasinam

           /* if(!filePathRender.exists()) {
                filePathRender.createNewFile()
            }*/







           // val intent : Intent = Intent()
            //intent.putExtra("enterPCS", "rčrčrčrčrč".toString())
            //@TODO tady to je bellow
            excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)
            var coreStart = Intent(context, MainActivity::class.java)



            if(enterData.text.isEmpty()) {
                Toast.makeText(context, "error 0 files", Toast.LENGTH_SHORT).show()
                alertadd.show()
                return@setNegativeButton
            } else {

                ActivityCompat.startActivity(context, coreStart, Bundle())
            }
            //ActivityCompat.startActivity(
            //  questionDialogBuilder.uploadToServerSMB(this, intent, Activity())
            //    Toast.makeText(this, "action started", Toast.LENGTH_LONG).show()
            //getDataFromCSV(context)
            return@setNegativeButton
            var UPLOAD_FILES_REQUEST = 0;
            var intent = Intent()
            intent.action = Intent.ACTION_PICK
            //val smbUri = Uri.parse("smb://192.168.0.178")

            val smbUri = Uri.parse("smb://37.205.10.181")
            //val smbUri = Uri.parse("smb://192.168.1.122")
            intent.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
            intent.putExtra("command_type", "upload")

            //intent.putExtra("smb_username", "guest");
            //intent.putExtra("smb_password", "patera");
            //intent.putExtra("command_type", "upload")
            intent.putExtra("smb_username", "root");
            intent.putExtra("smb_password", "okyop3ld");
            //intent.putExtra("smb_username", "albert.patera.root");
            //intent.putExtra("smb_password", "ThingForLife1597@NASka");
//intent.putExtra("smb_domain", "YOURDOMAIN");F

            //return
            intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

            intent.putExtra("progress_title", "Nahrávání souboru...");
            Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
            intent.putExtra("remote_folder", "/proplant");

            try {
                ActivityCompat.startActivityForResult(context as Activity, intent, 1, Bundle());

                var coreStart = Intent(context, MainActivity::class.java)
               // ActivityCompat.startActivity(context, coreStart, Bundle())
            } catch (e : Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
            //} catch (e : Exception) {
              //  alert
            //}


        }
        alertadd.setNeutralButton(
            " ✖" +
                    " UKONČIT TOTO SKENOVÁNÍ! "
        ) { dlg, sumthin ->
            /*if(!filePathRender.exists()) {
                filePathRender.createNewFile()
            }

           */
            val writer = com.example.scankitdemo.core.writeXls()
            var dataToInsert: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
            )
            try {
                writer.appendRows(dataToInsert, filePathRender.absoluteFile)
            } catch (e : Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
            try {

                filePathRender.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", "/folder_name/output"), "/import" + System.currentTimeMillis() + ".xls"))
            } catch (e : Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
           //@TODO funguje filePathRender.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", "/folder_name/output"), "/impO" + System.currentTimeMillis() + ".xls"))

            val navratDoMenuToast = SpannableStringBuilder("NA MOBILU STISTNI TLAČÍTKO ZPĚT PRO NÁVRAT DO MENU")
            navratDoMenuToast.setSpan(RelativeSizeSpan(2.35f), 0, navratDoMenuToast.length, 0)
            navratDoMenuToast.setSpan(BackgroundColorSpan(Color.rgb(245, 93, 66)), 0, navratDoMenuToast.length, 0)

            Toast.makeText(context, navratDoMenuToast, Toast.LENGTH_SHORT).show()

            try {

                val mainSection = MainActivity()
            //   mainSection.deleteFilesAnyway()
            } catch (e : Exception) {
                Toast.makeText(context, "i", Toast.LENGTH_SHORT).show()
            }
            return@setNeutralButton
            if(filePathRender.exists()) {
                filePathRender.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", "/folder_name/output"), "/impO" + System.currentTimeMillis() + ".xls"))

                Toast.makeText(context, "HOTOVO", Toast.LENGTH_SHORT).show()
            }
/*
            if (!filePathRender.exists()) {
                filePathRender.createNewFile()
                val writer = com.example.scankitdemo.core.writeXls()
                var recordsToWriteInitHeader: List<ItemEntity> = mutableListOf<ItemEntity>(
                    //ItemEntity("Charles", "Babej", "60"),
                    //ItemEntity("John", "Doe", "70"),
                    //  ItemEntity("Loreum", "rrrrr", "80"
                    //),
                    ItemEntity("id", "plu", "80", 8)
                )
                var he = mutableListOf("plu", "kusy")
                try {
                    var sheet = workbook.createSheet("Ahoj 2") as HSSFSheet
                    var rows = sheet.createRow(he.count())
                    rows.createCell(0).setCellValue("plu")
                    rows.createCell(1).setCellValue("kusy")
                    try {
                        val fileOut = FileOutputStream(filePathRender)
                        workbook.write(fileOut)
                        fileOut.close()
                    } catch (e: Exception) {
                        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                    }
                    writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                    writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                    Toast.makeText(context, "file ppending successed", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            } else {
                var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                    //ItemEntity("Charles", "Babej", "60"),
                    //ItemEntity("John", "Doe", "70"),
                    //  ItemEntity("Loreum", "rrrrr", "80"),
                    //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                    ItemEntity(enterData.text.toString(), data, "80", enterData.text.toString().toInt())
                )
                //.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)
                //excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)

            }*/
            var excelDataWriterPlugin = com.example.scankitdemo.core.writeXls()
            var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
            )

            excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)




            // intent.action = Intent.ACTION_PICK
            var questionDialogBuilder = Data()
            //  questionDialogBuilder.uploadToServerSMB(this, intent, Activity())
            //    Toast.makeText(this, "action started", Toast.LENGTH_LONG).show()
            //getDataFromCSV(context)
            var UPLOAD_FILES_REQUEST = 0;
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            //val smbUri = Uri.parse("smb://192.168.0.178")

            val smbUri = Uri.parse("smb://37.205.10.181")
            //val smbUri = Uri.parse("smb://192.168.1.122")
            intent.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
            intent.putExtra("command_type", "upload")

            //intent.putExtra("smb_username", "guest");
            //intent.putExtra("smb_password", "patera");
            //intent.putExtra("command_type", "upload")
            intent.putExtra("smb_username", "root");
            intent.putExtra("smb_password", "okyop3ld");
            //intent.putExtra("smb_username", "albert.patera.root");
            //intent.putExtra("smb_password", "ThingForLife1597@NASka");
//intent.putExtra("smb_domain", "YOURDOMAIN");F

            var file = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls")

            try {
                if(file.exists()) {
                   // file.renameTo(File(Environment.getExternalStorageDirectory().toString() + "/Download", "/impO" + getTime("yyyy-MM-dd HH:mm") + ".xls"))
                    file.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", "/folder_name/output"), "/impO" + System.currentTimeMillis() + ".xls"))

                    Toast.makeText(context, "rrrr", Toast.LENGTH_SHORT).show()
                } else {
                    //file.createNewFile()
                    val file2 = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls")
                    file2.createNewFile()
                    val writer = com.example.scankitdemo.core.writeXls()
                    var recordsToWriteInitHeader: List<ItemEntity> = mutableListOf<ItemEntity>(
                        //ItemEntity("Charles", "Babej", "60"),
                        //ItemEntity("John", "Doe", "70"),
                        //  ItemEntity("Loreum", "rrrrr", "80"
                    //),
                        //ItemEntity("id", "plu", "80", 8)
                    )
                    try {

                        writer.appendRows(recordsToWriteInitHeader, file.absoluteFile)
                       // writer.appendRows()
                    } catch (e : Exception) {
                        Toast.makeText(context, "rrrrrr", Toast.LENGTH_SHORT).show()
                    }
                }

            } catch (e : Exception) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            }
           // a
           // return@setPositiveButton
            //return
           // intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

            intent.putExtra("progress_title", "Nahrávání souboru...");
            Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
            intent.putExtra("remote_folder", "/proplant");
            val biggerText = SpannableStringBuilder("DATA ODESLÁNA")
            biggerText.setSpan(RelativeSizeSpan(2.35f), 0, biggerText.length, 0)
            biggerText.setSpan(BackgroundColorSpan(Color.rgb(245, 93, 66)), 0, biggerText.length, 0)

            try {

                ActivityCompat.startActivityForResult(context as Activity, intent, 1, Bundle());
                Toast.makeText(context, biggerText, Toast.LENGTH_SHORT).show()

            } catch (e : Exception) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            }

        }
            //ActivityCompat.startActivityForResult(context as Activity, intent, 1, Bundle());

            /*if(enterData.text.length > 5) {
                Snackbar.make(view, "Invalid code", Snackbar.LENGTH_LONG).show()

                return@setNeutralButton
            }*/
            var mainCoreExcel = MainExcelWriter()
            //mainCoreExcel.writeToExcelFile(filepath = filePathRender.absolutePath, displayData.text.toString(), context, dataPCS!!.text.toString())
            //     mainCoreExcel.writeToExcelFile(filepath = filePathRender.absolutePath, rawResult!!.text.toString(), this, enterPCS.text.toString())

            //  data.writeToExcelFile(filepath = filePathRender.absolutePath, data = "ss", context = context)
            // ActivityCompat.startActivity(context, Intent(context, DisPlayActivity::class.java), Bundle())
            //try {


            var excelDataWriterPlugin = com.example.scankitdemo.core.writeXls()

            try {
                /*var recordsToWritehjj: List<ItemEntity> = mutableListOf<ItemEntity>(
                    //ItemEntity("Charles", "Babej", "60"),
                    //ItemEntity("John", "Doe", "70"),
                  //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                    ItemEntity(enterData.text.toString(), data, "80")
                )*/
                /* var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                     //ItemEntity("Charles", "Babej", "60"),
                     //ItemEntity("John", "Doe", "70"),
                0     //  ItemEntity("Loreum", "rrrrr", "80"),
                     //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                     ItemEntity(enterData.text.toString(), data, "80")
                 )*/


                val intent : Intent = Intent()
                //intent.putExtra("enterPCS", "rčrčrčrčrč".toString())
                //@TODO tady to je bellow
                // excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)
            } catch (e : Exception) {
                //alertadd.setMessage("ttttt")
                //alertadd.show()
                val alert = AlertDialog.Builder(context)
                alert.setMessage(e.message)
                alert.show()
            }
            displayData.visibility = View.VISIBLE
            Toast.makeText(context, enterData.text.toString() + "tttt", Toast.LENGTH_SHORT)
            // mainCoreExcel.writeToExcelFile(filePathRender.absolutePath, displayData!!.text.toString(), context, enterData!!.text.toString())
        displayData.text = "$data"
        displayTitle.text = "ZADEJ POČET \n\r $data"
        //alertadd.setTitle("Zadej počet kusů \n\n $data")

        // buiderDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(35F);
        //buiderDialog.create()
        alertadd.show()
        return
            var questionDialogBuilder = Data()
            var recordsDataToWriteToExcelPLUKS: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"),
                //@TODO tady to funguje ok     ItemEntity("Loreum", "rrrrr", "80"),
                ItemEntity(enterData.text.toString().toInt(), data.toInt(), "80", enterData.text.toString().toInt())
            )
            // val intent : Intent = Intent()
            //intent.putExtra("enterPCS", "rčrčrčrčrč".toString())
            //@TODO tady to je bellow
            //excelDataWriterPlugin.appendRows(recordsDataToWriteToExcelPLUKS, filePathRender.absoluteFile)
            //  questionDialogBuilder.uploadToServerSMB(this, intent, Activity())
            //    Toast.makeText(this, "action started", Toast.LENGTH_LONG).show()
            //getDataFromCSV(context)
            var UPLOAD_FILES_REQUEST = 0;
            //return
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            //val smbUri = Uri.parse("smb://192.168.0.178")

            val smbUri = Uri.parse("smb://37.205.10.181")
            //val smbUri = Uri.parse("smb://192.168.1.122")
            intent.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
            intent.putExtra("command_type", "upload")


            //intent.putExtra("smb_username", "guest");
            //intent.putExtra("smb_password", "patera");
            //intent.putExtra("command_type", "upload")
            intent.putExtra("smb_username", "root");
            intent.putExtra("smb_password", "okyop3ld");
            //intent.putExtra("smb_username", "albert.patera.root");
            //intent.putExtra("smb_password", "ThingForLife1597@NASka");
//intent.putExtra("smb_domain", "YOURDOMAIN");F

            //return
            intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

            intent.putExtra("progress_title", "Nahrávání souboru...");
            Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
            intent.putExtra("remote_folder", "/proplant");

            try {
                ActivityCompat.startActivityForResult(context as Activity, intent, 1, Bundle());

                var coreStart = Intent(context, MainActivity::class.java)
                // ActivityCompat.startActivity(context, coreStart, Bundle())
            } catch (e : Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
            //} catch (e : Exception) {
            //  alert
            //}


      //  }



    }
    fun readFromExcelFile(filepath: String) {
        val inputStream = FileInputStream(filepath)
        //Instantiate Excel workbook using existing file:
        var xlWb = WorkbookFactory.create(inputStream)

        //Row index specifies the row in the worksheet (starting at 0):
        val rowNumber = 0
        //Cell index specifies the column within the chosen row (starting at 0):
        val columnNumber = 0

        //Get reference to first sheet:
        val xlWs = xlWb.getSheetAt(0)
        println(xlWs.getRow(rowNumber).getCell(columnNumber))
    }

  public  fun main(args: MutableList<String>) {
        val filepath = "./test.xlsx"
        //writeToExcelFile(filepath, )
        readFromExcelFile(filepath)
    }

   public fun vibratePhone(context: Context) {
        val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(1600, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(1600)
        }
    }

    public fun getTime(date: String): String? {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        //val formatter = DateTimeFormatter.ofPattern(date)
       // fun main(args: Array<String>) {
            val simpleDate = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = simpleDate.format(Date())
            //println(" Current Date is: " +currentDate)
        //}
       // return LocalDateTime.now().format(formatter)
        return simpleDate.format(Date())
    }
}