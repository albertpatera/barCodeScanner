package com.example.scankitdemo.core

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.scankitdemo.MainActivity
import com.example.scankitdemo.R
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
//import com.google.mlkit.vision.barcode.BarcodeScannerOptions
//import com.google.mlkit.vision.barcode.common.Barcode
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths

class Data {
    private var filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/final_cutz_down.xlsx")

    public fun loadData(context: Context, data : String, fileName: String)  {
        var file = File(Environment.getExternalStorageDirectory().toString() + "/Download", fileName)
        if(file.exists()) {
            //file.appendText(data)

        } else {
            file.createNewFile()
           // file.appendText(data)
        }
    }



    public fun uploadToServerSMB (context: Context, intent: Intent, activity: Activity) {
        try {
            ;
            try {

                //operation.loadData(this, "super;", "/noWhereToRun.txt")
                Toast.makeText(context, "action started", Toast.LENGTH_LONG).show()
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
//intent.putExtra("smb_domain", "YOURDOMAIN");F

                //return
                intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

                intent.putExtra("progress_title", "Nahrávání souboru...");
                Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                intent.putExtra("remote_folder", "/proplant");

                startActivityForResult(activity, intent,1, Bundle() );

                alertShow(activity)


            } catch (e : Exception) {
                //alertDialog.show()
            }
           // return
            // load()
            // load(rawResult!!.text.toString())
            //alertDialog.setMessage("yes")


            //operation.loadData(this, rawResult!!.text.toString(), "/noWhereToRun.txt")
            //startActivity(Intent(this, InseertActivity::class.java));
            var UPLOAD_FILES_REQUEST = 0;
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            //val smbUri = Uri.parse("smb://192.168.0.178")
            //val smbUri = Uri.parse("smb://37.205.10.181")
            val smbUri = Uri.parse("smb://thingsmartcloud")
            //val smbUri = Uri.parse("smb://192.168.1.122")
            intent.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
            intent.putExtra("command_type", "upload")

            //intent.putExtra("smb_username", "guest");
            //intent.putExtra("smb_password", "patera");
            //intent.putExtra("command_type", "upload")
            intent.putExtra("smb_username", "root");
            intent.putExtra("smb_password", "okyop3ld");
//intent.putExtra("smb_domain", "YOURDOMAIN");F

            //return
            intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

            intent.putExtra("progress_title", "Nahrávání souboru...");
            Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()

            //alert.setMessage(Environment.getExternalStorageState() + "     _______storage");
            //alert.show()
            //intent.putExtra("local_file1",  activity?.externalCacheDir.toString() + "/importOut.txt");
            //intent.putExtra("local_file1",  "/sdcard/Android/data/com.example.scankitdemo/files/test.xml");

            //intent.putExtra("local_file1",  Environment.getExternalStorageDirectory().toString() +"/Documents" + "/SimpleBudget.xlsx");
            //intent.putExtra("local_file1",  Environment.getExternalStorageDirectory().toString() + "/Pictures/test.txt");

// Optional initial remote folder (it must exist before upload)
            //intent.putExtra("remote_folder", "/Public/Přenos dat do money");
            //intent.putExtra("remote_folder", "/MyShare");
            intent.putExtra("remote_folder", "/proplant");

            startActivityForResult(activity, intent,1, Bundle() );

            val status = intent.getStringExtra("TRANSFERSTATUS")
            val files = intent.getStringExtra("TRANSFERAMOUNT")
            val size = intent.getStringExtra("TRANSFERSIZE")
            val time = intent.getStringExtra("TRANSFERTIME")

           // Toast.makeText(context, "NAHRAVANI DOKONCENO", Toast.LENGTH_LONG).show()
            alertShow(activity)

        } catch (e : Exception) {
          // alert.setMessage(e.message)
            //alert.show()
        }
    }

    public fun alertShow(context: Context) {
        val alertadd = AlertDialog.Builder(context)
        val factory = LayoutInflater.from(context)
        val view: View = factory.inflate(R.layout.sample, null)
        alertadd.setView(view)
        alertadd.setNeutralButton(
            "OK!"
        ) { dlg, sumthin -> }

        alertadd.show()
    }

    public fun alertCancelOrExit(context: Context, intent: Intent) {
        //val alertadd = androidx.appcompat.app.AlertDialog.Builder(context)
        val alertadd = AlertDialog.Builder(context)
        var builder = alertadd.create()
        val factory = LayoutInflater.from(context)
        val view: View = factory.inflate(R.layout.done_or_not, null)
        //var negative = view.findViewById<AlertDialog>()
       // var negative = view.findViewById<AlertDialog>(android.R.id)
        var okButton = view.findViewById<Button>(R.id.next_button)
        var cancelButtonVar = view.findViewById<Button>(R.id.cancel_button)
       /* val button = builder.getButton(DialogInterface.BUTTON_NEUTRAL)
        //val tvDetail: TextView = view.findViewById(R.id.tv_detail)
       // val btDone: Button = view.findViewById(R.id.bt_done)
        button.setText("OK, pokračovat")
        button.setPadding(0, 0, 20, 0)
        button.setTypeface(null, Typeface.BOLD)
        button.textSize = 35.toFloat()
*/


        alertadd.setView(view)
        alertadd.setNeutralButton(
            "OK!"
        ) { dlg, sumthin ->
            startActivity(context, intent, Bundle())
            startActivity(context, intent, Bundle())

        }

        //alertadd.setNegativeButton(
          //  "ZRUŠIT"
        //) { dlg, sumthin -> dlg.cancel()}
        //builder.create()

        alertadd.show()

        okButton.setOnClickListener {
            //Toast.makeText(context, "presssed next btn ", Toast.LENGTH_LONG).show()
            var backIntent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, Bundle())
        }

        cancelButtonVar.setOnClickListener {
            //Toast.makeText(context, "presssed next btn ", Toast.LENGTH_LONG).show()
            var backIntent = Intent(context, FinalRenderActivity::class.java)
            startActivity(context, intent, Bundle())
        }
    }


    public fun getDataFromCSV(context: Context, workbook : Workbook) {
        var fileOutputStream = FileOutputStream(filePathRender)
        var alert = AlertDialog.Builder(context).create()
        var rows = mutableListOf("er", "e")
        val bufferedReader = Files.newBufferedReader(
            Paths.get(
                Environment.getExternalStorageDirectory().toString() + "/Download//output.csv"
            )
        );
        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet: HSSFSheet = hssfWorkbook.createSheet("Custom Sheet")
        val hssfRow: HSSFRow = hssfSheet.createRow(0)
        val hssfCell: HSSFCell = hssfRow.createCell(0)





        var csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)

        var del = "name, 2012, 4544".split(",").toTypedArray()
        try {
            var row = hssfSheet.createRow(del.count())
            var cell = row.createCell(1)
            var tv = TextView(context)
            for (pol in csvParser) {
                tv.text = tv.text.toString() + del.contentToString() + pol.get(0) + "\n"
                //cell?.setCellValue(tv.text.toString() + del.contentToString() + pol.get(0))
                try {

                    cell?.setCellValue("rtaertae")
                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }
            }
            alert.setMessage(tv.text.toString())
            alert.show()
        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }

       // return
        for (rn in rows.indices) {
            var tv = TextView(context)
            //val r: Row = hssfSheet.createRow(++rowCount)
            var del = "name, 2012, 2017".split(",").toTypedArray()
            try {
                var row = hssfSheet.createRow(del.count())
                var cell = row.createCell(1)
                for (pol in csvParser) {
                    tv.text = tv.text.toString() + del.contentToString() + pol.get(0) + "\n"
                    //cell?.setCellValue(tv.text.toString() + del.contentToString() + pol.get(0))
                    cell?.setCellValue("rrrrrer")
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
        //try {
        return
            val fileOut = FileOutputStream(filePathRender)
            workbook.write(fileOut)
            fileOut.close()
            Toast.makeText(context, "ok,,,", Toast.LENGTH_LONG).show()
            //Toast.makeText(applicationContext, "super je to tady :)))", Toast.LENGTH_LONG).show()

        /*}
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }*/

    }

    public fun excel() {

    }


}