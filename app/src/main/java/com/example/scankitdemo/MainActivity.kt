/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.scankitdemo

import android.Manifest
import android.Manifest.permission.*
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.BackgroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import com.example.scankitdemo.core.Data
import com.example.scankitdemo.core.FileOperation
import com.example.scankitdemo.core.ItemEntity
import com.huawei.hms.hmsscankit.ScanUtil
import com.huawei.hms.ml.scan.HmsScan
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class MainActivity : Activity(), OnRequestPermissionsResultCallback {
    private lateinit var options : FileOperation
    var workbook: Workbook = HSSFWorkbook()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var fileToCreate = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");
        if(!fileToCreate.exists()) {
            fileToCreate.createNewFile()
            try {
                // return
                // return
                var sheet = workbook.createSheet("zásoby na skladě ") as HSSFSheet
                //return;
                var headerData = mutableListOf("id", "kusy", "plu")
                var rows = sheet.createRow(0)
                rows.createCell(0).setCellValue(headerData[0])
                rows.createCell(1).setCellValue(headerData[1])
                rows.createCell(2).setCellValue(headerData[2])
                try {
                    val fileOut = FileOutputStream(fileToCreate)
                    workbook.write(fileOut)
                    fileOut.close()
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
                //  r.createCell(1).setCellValue("kusy")
                /*for (rn in headers.indices) {
                    rows.createCell(0).setCellValue(headers[0])
                    rows.createCell(1).setCellValue(headers[1])
                    rows.createCell(2).setCellValue(headers[2])
                }


                //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                Toast.makeText(this, "actually this is soo stupid alert :-P", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }*/
            } catch (e : Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

      /*  try {
           // return
            // return
            var sheet = workbook.createSheet("zásoby na skladě ") as HSSFSheet
            //return;
            var headerData = mutableListOf("id", "kusy", "plu")
            var rows = sheet.createRow(0)
            rows.createCell(0).setCellValue(headerData[0])
            rows.createCell(1).setCellValue(headerData[1])
            rows.createCell(2).setCellValue(headerData[2])
            try {
                val fileOut = FileOutputStream(fileToCreate)
                workbook.write(fileOut)
                fileOut.close()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
            //  r.createCell(1).setCellValue("kusy")
            /*for (rn in headers.indices) {
                rows.createCell(0).setCellValue(headers[0])
                rows.createCell(1).setCellValue(headers[1])
                rows.createCell(2).setCellValue(headers[2])
            }


            //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
            //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
            Toast.makeText(this, "actually this is soo stupid alert :-P", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }*/
        } catch (e : Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }*/
        //;;return
       // requestPermission(DEFINED_CODE, DECODE)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_mwcmain)
          // return            //fileToCreate.createNewFile()
           /* Toast.makeText(this, "FILE WAS CREATED SUCCESSFULLY", Toast.LENGTH_SHORT).show()
            var he = mutableListOf("plu", "kusy")
            val workbook = HSSFWorkbook(FileInputStream(fileToCreate))
            val sheet: Sheet = workbook.getSheetAt(0)
            val rowNum = sheet.lastRowNum + 1
            val headers = arrayOf("Header1", "Header2", "Header3")
*/
            //Workbook workbook = new HSSFWorkbook();
            // Sheet sheet = workbook.createSheet("EDR Raw Data");

            //Workbook workbook = new HSSFWorkbook();
            // Sheet sheet = workbook.createSheet("EDR Raw Data");
            //val r = sheet.createRow(2)
            //r.createCell(0).setCellValue(headers[0])
            //r.createCell(1).setCellValue(headers[1])
//            /r.createCell(2).setCellValue(headers[2])
            //tady fdgfhjh

        return
            try {
              // return
                var sheet = workbook.createSheet("Ahoj 2") as HSSFSheet
                //return;
                var headerData = mutableListOf("plu", "kusy")
                var rows = sheet.createRow(headerData.count())
                rows.createCell(0).setCellValue("plu")
              //  r.createCell(1).setCellValue("kusy")
                /*for (rn in headers.indices) {
                    rows.createCell(0).setCellValue(headers[0])
                    rows.createCell(1).setCellValue(headers[1])
                    rows.createCell(2).setCellValue(headers[2])
                }
                try {
                    val fileOut = FileOutputStream(fileToCreate)
                    workbook.write(fileOut)
                    fileOut.close()
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }

                //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                Toast.makeText(this, "actually this is soo stupid alert :-P", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }*/
        } catch (e : Exception) {

        }
        return
        val excel = com.example.scankitdemo.core.writeXls()
        try {

            var recordsToWriteInitHeader: List<ItemEntity> = mutableListOf<ItemEntity>(
                //ItemEntity("Charles", "Babej", "60"),
                //ItemEntity("John", "Doe", "70"),
                //  ItemEntity("Loreum", "rrrrr", "80"
                //),
                //ItemEntity("id", "plu", "80", 8),
                //ItemEntity("id", "plu", "80", 1000)
            )
            excel.appendRows(recordsToWriteInitHeader, fileToCreate.absoluteFile)
        } catch (e : Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
        requestPermission(DEFINED_CODE, DECODE)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_mwcmain)

        return
        // options = FileOperation()
        //var hmsEnaled = HmsScanAnalyzer()
       /* var filePathRender =
            File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");
        */var alertDialog = AlertDialog.Builder(this).create()
        var workbook: Workbook = HSSFWorkbook()

        var filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");
        if(!filePathRender.exists()) {
            filePathRender.createNewFile()
            Toast.makeText(this, "file test created", Toast.LENGTH_SHORT).show()
        }

        val writer = com.example.scankitdemo.core.writeXls()
        var recordsToWriteInitHeader: List<ItemEntity> = mutableListOf<ItemEntity>(
            //ItemEntity("Charles", "Babej", "60"),
            //ItemEntity("John", "Doe", "70"),
            //  ItemEntity("Loreum", "rrrrr", "80"
            //),
            //ItemEntity("id", "plu", "80", 8),
            //ItemEntity("id", "plu", "80", 1000)
        )
        var he  = mutableListOf("plu", "kusy")
        try {
            var sheet = workbook.createSheet("Ahoj 2") as HSSFSheet
            var rows = sheet.createRow(he.count())
            rows.createCell(0).setCellValue("plu")
            rows.createCell(1).setCellValue("kusy")
            try {
                val fileOut = FileOutputStream(filePathRender)
                workbook.write(fileOut)
                fileOut.close()
            } catch (e : Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
            writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
            //writer.appendRows()
            Toast.makeText(this, "file ppending successed", Toast.LENGTH_SHORT).show()
        } catch (e : Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
       // return
        //var mainCoreExcel = com.example.scankitdemo.core.MainExcelWriter()
        //mainCoreExcel.writeToExcelFile(filepath = filePathRender.absolutePath, "plu", this, "kusy")
        try {
            /*ActivityCompat.requestPermissions(
                this, arrayOf(com.example.scankitdemokotlin.MainActivity.DEFINED_CODE.toString()),
                200)*/

            //newViewBtnClick(null)
            //options.loadData(this, intent.getStringExtra("barcodeValue") , "/null")
            //startActivity(Intent(this, FormActivity::class.java))


        } catch (e: Exception) {
            alertDialog.setMessage(e.message)
            alertDialog.show()
        }

        try {

            //startActivity(Intent(this, FormActivity::class.java))
        } catch (e: Exception) {
            alertDialog.setMessage(e.message)
            alertDialog.show()
        }
        //return
        //;;return
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_mwcmain)
        return
        var alert = AlertDialog.Builder(this).create()

        this.window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        //Set noTitleBar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val window = window
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }

        /**
         * Call upload to server action
         * backup file
         * rename file
         * upload file to server via AndSMB client
         *
         */

   @RequiresApi(Build.VERSION_CODES.R)

  public fun startWithNeFileBtn(view : View?) {
            return
     var filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");

      try {
          filePathRender.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", ""), "/readyFor" + System.currentTimeMillis() + ".xls"))
      } catch (e : Exception) {
          Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
      }

            if(!filePathRender.exists()) {
                filePathRender.createNewFile()
            }

            try {
                // return
                var sheet = workbook.createSheet("zásoby na skladě ") as HSSFSheet
                //return;
                var headerData = mutableListOf("id", "kusy", "plu")
                var rows = sheet.createRow(0)
                rows.createCell(0).setCellValue(headerData[0])
                rows.createCell(1).setCellValue(headerData[1])
                rows.createCell(2).setCellValue(headerData[2])
                try {
                    val fileOut = FileOutputStream(filePathRender)
                    workbook.write(fileOut)
                    fileOut.close()
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
                //  r.createCell(1).setCellValue("kusy")
                /*for (rn in headers.indices) {
                    rows.createCell(0).setCellValue(headers[0])
                    rows.createCell(1).setCellValue(headers[1])
                    rows.createCell(2).setCellValue(headers[2])
                }


                //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                //writer.appendRows(recordsToWriteInitHeader, filePathRender.absoluteFile)
                Toast.makeText(this, "actually this is soo stupid alert :-P", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }*/
            } catch (e : Exception) {
                Toast.makeText(this, "errorek", Toast.LENGTH_SHORT).show()
            }
  }
   public fun OnClickUploadToServer(view: View?)  {

            try {
                val folder = Environment.getExternalStorageDirectory().toString() + "/Download/"
                val f = File(folder, "/folder_name")

                val fOut = File(folder, "/folder_name/output")
                f.mkdir()
                fOut.mkdir()

                // return
               // return
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf<String>(MANAGE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
                    200
                )
                var writer = com.example.scankitdemo.core.MainExcelWriter()
                // writer.createBarcodeDirectory(this)

               // File(folder, "/folder_name").forEachBlock(iterator<> {  })
                var folders = File(folder, "/folder_name")
                var foldersTEST = File(folder, "/test.xls")
                //val files = File(folder, "/folder_name").listFiles()
                val files = File(folder, "/folder_name").listFiles()
                val filesOut = File(folder, "/folder_name/output").listFiles()
                val fileNames = arrayOfNulls<String>(files.size)
                val fileNamesOut = arrayOfNulls<String>(filesOut.size)
                    var file = File(Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output", "/importF" + System.currentTimeMillis() + ".xls")
                //var file2 = File(Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output", "/test" + System.currentTimeMillis() + ".xls")
                var file2 = File(Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output", "/zasoby" + ".xls")
                val UPLOAD_FILES_REQUEST = 0;
                val intent = Intent()
                intent.action = Intent.ACTION_PICK
                //val smbUri = Uri.parse("smb://192.168.0.178")

                val smbUri = Uri.parse("smb://37.205.10.181")
                //val smbUri = Uri.parse("smb://192.168.1.122")
                intent.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
                intent.putExtra("command_type", "upload")

                intent.putExtra("smb_username", "root");
                intent.putExtra("smb_password", "okyop3ld");


                    filesOut!!.mapIndexed { index, item ->
                        fileNamesOut[index] = item?.name

                        // Toast.makeText(this, fileNamesOut[3], Toast.LENGTH_SHORT).show()
                        //if(item.name.length < 11) {
                        //if(fileNamesOut[index] == fileNamesOut[fileNamesOut.lastIndex]) {;
                        // if(item.name) {

                        //intent.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" +item.name);
                        // intent.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" +item.name);
                       // intent.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" + fileNamesOut[index]);
                        intent.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" +item.name);
                        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()

                        //item.delete()
                        //}
                        //Toast.


                    }
                intent.putExtra("progress_title", "Nahrávání souboru...");
                Toast.makeText(this, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                intent.putExtra("remote_folder", "/proplant");

                    // ActivityCompat.startActivityForResult(this as Activity, intent, 1, Bundle());
                 //else {

                //}
                //intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/zasoby.xls");

                intent.putExtra("progress_title", "Nahrávání souboru...");
                Toast.makeText(this, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                intent.putExtra("remote_folder", "/proplant");
                val biggerText = SpannableStringBuilder("DATA ODESLÁNA")
                biggerText.setSpan(RelativeSizeSpan(2.35f), 0, biggerText.length, 0)
                biggerText.setSpan(BackgroundColorSpan(Color.rgb(245, 93, 66)), 0, biggerText.length, 0)

                Toast.makeText(this, biggerText, Toast.LENGTH_SHORT).show()
                ActivityCompat.startActivityForResult(this, intent, 1, Bundle());

                //return
                //intentTest.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() +"/Download" + "/folder_name" + "/output" + "/zasoby.xls");
                //var questionDialogBuilder = Data()
                //  questionDialogBuilder.uploadToServerSMB(this, intent, Activity())
                //    Toast.makeText(this, "action started", Toast.LENGTH_LONG).show()
                //getDataFromCSV(context)



                //return
                var UPLOAD_FILES_REQUEST__ = 0;
                val intentTest_ = Intent()
                intentTest_.action = Intent.ACTION_PICK
                //val smbUri = Uri.parse("smb://192.168.0.178")

                val smbUri_ = Uri.parse("smb://37.205.10.181")
                //val smbUri = Uri.parse("smb://192.168.1.122")
                intentTest_.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
                intentTest_.putExtra("command_type", "upload")

                //intent.putExtra("smb_username", "guest");
                //intent.putExtra("smb_password", "patera");
                //intent.putExtra("command_type", "upload")
                intentTest_.putExtra("smb_username", "root");
                intentTest_.putExtra("smb_password", "okyop3ld");
                //intent.putExtra("smb_username", "albert.patera.root");
                //intent.putExtra("smb_password", "ThingForLife1597@NASka");
//intent.putExtra("smb_domain", "YOURDOMAIN");F

                //return
                intentTest_.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() +"/Download" + "/folder_name" + "/output" + "/zasoby.xls");
               /* filesOut!!.mapIndexed { index, item ->
                    fileNamesOut[index] = item?.name

                    // Toast.makeText(this, fileNamesOut[3], Toast.LENGTH_SHORT).show()
                    //if(item.name.length < 11) {
                    //if(fileNamesOut[index] == fileNamesOut[fileNamesOut.lastIndex]) {;
                    // if(item.name) {

                   // intent.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" +item.name);
                    //}
                    //Toast.

                }*/
                //.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

                intentTest_.putExtra("progress_title", "Nahrávání souboru...");
                Toast.makeText(this, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                intent.putExtra("remote_folder", "/proplant");






                /**
                 * kdyztak delketnout
                 */


                 //else {

                //}
                //intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/zasoby.xls");

                intent.putExtra("progress_title", "Nahrávání souboru...");
                Toast.makeText(this, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                intent.putExtra("remote_folder", "/proplant");
                val biggerText7 = SpannableStringBuilder("DATA ODESLÁNA")
                biggerText.setSpan(RelativeSizeSpan(2.35f), 0, biggerText.length, 0)
                biggerText.setSpan(BackgroundColorSpan(Color.rgb(245, 93, 66)), 0, biggerText.length, 0)

                Toast.makeText(this, biggerText, Toast.LENGTH_SHORT).show()
                ActivityCompat.startActivityForResult(this, intent, 1, Bundle());

                //return
                //intentTest.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() +"/Download" + "/folder_name" + "/output" + "/zasoby.xls");
                //var questionDialogBuilder = Data()
                //  questionDialogBuilder.uploadToServerSMB(this, intent, Activity())
                //    Toast.makeText(this, "action started", Toast.LENGTH_LONG).show()
                //getDataFromCSV(context)
                var UPLOAD_FILES_REQUEST_TEST = 0;
                val intentTest = Intent()
                intentTest.action = Intent.ACTION_PICK
                //val smbUri = Uri.parse("smb://192.168.0.178")

                val smbUriT = Uri.parse("smb://37.205.10.181")
                //val smbUri = Uri.parse("smb://192.168.1.122")
                intentTest.setDataAndType(smbUriT, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
                intentTest.putExtra("command_type", "upload")

                //intent.putExtra("smb_username", "guest");
                //intent.putExtra("smb_password", "patera");
                //intent.putExtra("command_type", "upload")
                intentTest.putExtra("smb_username", "root");
                intentTest.putExtra("smb_password", "okyop3ld");
                //intent.putExtra("smb_username", "albert.patera.root");
                //intent.putExtra("smb_password", "ThingForLife1597@NASka");
//intent.putExtra("smb_domain", "YOURDOMAIN");F

                //return
                intentTest.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() +"/Download" + "/folder_name" + "/output" + "/zasoby.xls");

                //.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

                intentTest.putExtra("progress_title", "Nahrávání souboru...");
                Toast.makeText(this, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                intent.putExtra("remote_folder", "/proplant");
                val biggerText2 = SpannableStringBuilder("DATA ODESLÁNA")
                biggerText.setSpan(RelativeSizeSpan(2.35f), 0, biggerText.length, 0)
                biggerText.setSpan(BackgroundColorSpan(Color.rgb(245, 93, 66)), 0, biggerText.length, 0)

                Toast.makeText(this, biggerText, Toast.LENGTH_SHORT).show()
                ActivityCompat.startActivityForResult(this as Activity, intent, 1, Bundle());

                return
                //intent.putExtra("smb_username", "albert.patera.root");
                //intent.putExtra("smb_password", "ThingForLife1597@NASka0");\
//intent.putExtr
                filesOut!!.mapIndexed { index, item ->
                    fileNamesOut[index] = item?.name
                    //Toast.makeText(this, "" + index, Toast.LENGTH_SHORT).show()
                    //if(index == filesOut.lastIndex) {
                        //Toast.makeText(this, fileNamesOut[] + "gfg", Toast.LENGTH_SHORT).show()
                    //}

                    if(fileNamesOut[index] == fileNamesOut[fileNamesOut.lastIndex]) {

                        //if(index == fileNamesOut.lastIndex) {
                      //  intentTest.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/import" + System.currentTimeMillis() + ".xls")
                      //  intentTest.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" + fileNamesOut[fileNamesOut.lastIndex])
                        Toast.makeText(this, item.name + "1", Toast.LENGTH_SHORT).show()
                    //    intentTest.putExtra("progress_title", "Nahrávání souboru...");
                        //Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                      //  intentTest.putExtra("remote_folder", "/proplant");
                    }
                    //return
                   // intentTest.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" + item.name)
                    Toast.makeText(this, "fff" + fileNamesOut[fileNamesOut.lastIndex], Toast.LENGTH_SHORT ).show()
                  //  intentTest.putExtra("local_file$index", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output" + "/" + fileNamesOut[fileNamesOut.lastIndex])
                   // intentTest.putExtra("local_folder", Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name" + "/output")

                     //if(fileNames[index] == fileNames[fileNames.lastIndex]) {
                       // item.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download", "/folder_name"), "_latest"  + index.toString() +  "_"+ fileNames[index]))

                    //}
                    intentTest.putExtra("progress_title", "Nahrávání souboru...");
                    //Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                    intentTest.putExtra("remote_folder", "/proplant");
                    ActivityCompat.startActivityForResult(this as Activity, intentTest, 1, Bundle());

                }


              //  ActivityCompat.startActivityForResult(this as Activity, intentTest, 1, Bundle());
                Toast.makeText(this, "Successfully copied", Toast.LENGTH_SHORT).show()
                //var finalFileTEST = File(foldersTEST)
                return
                var UPLOAD_FILES_REQUEST_ = 0;
                var intent2 = Intent()
                intent2.action = Intent.ACTION_PICK
                //val smbUri = Uri.parse("smb://192.168.0.178")

                val smbUri2 = Uri.parse("smb://37.205.10.181")
                //val smbUri = Uri.parse("smb://192.168.1.122")
                intent.setDataAndType(smbUri2, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
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
               // intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

                intent.putExtra("progress_title", "Nahrávání souboru...");
                //Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                intent.putExtra("remote_folder", "/proplant");

                try {



                    var coreStart = Intent(this, MainActivity::class.java)
                    // ActivityCompat.startActivity(context, coreStart, Bundle())
                } catch (e : Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }


                filesOut?.mapIndexed { index, item ->
                    fileNamesOut[index] = item?.name
                    Toast.makeText(this, fileNamesOut[index], Toast.LENGTH_SHORT).show()
                    //return

                  //  if(fileNames[index] == fileNames[fileNames.lastIndex]) {
                    //    item.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download", "/folder_name"), "_latest"  + index.toString() +  "_"+ fileNames[index]))

                    //} else {
                    try {

                        if(index == 0) {

                            //item.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", "/folder_name"), "_IN"  + index.toString() +  "_"+ fileNames[index]))
                            item.copyTo(File(Environment.getExternalStorageDirectory().toString() + "/Download" + "/folder_name/output",  filesOut[0].name))
                            item.renameTo(File(File(Environment.getExternalStorageDirectory().toString() + "/Download/", "/folder_name/output"), "_IN"  + index.toString() +  "_"+ fileNamesOut[index]))
                            intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/folder_name/output/" + filesOut[0].name);

                        }

                        intent.putExtra("progress_title", "Nahrávání souboru...");
                        //Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                        intent.putExtra("remote_folder", "/proplant");

                    } catch (e : Exception) {
                        Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

                    }
                    //}
                    // folders.copyTo(folders)
                    //intent.putExtra("local_file$index" , Environment.getExternalStorageDirectory().toString() + "/Download/folder_name/" +
                      //      "_"  + index.toString() +  "_"+ fileNames[index]);

                    intent.putExtra("progress_title", "Nahrávání souboru...");
                    //Toast.makeText(context, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                    intent.putExtra("remote_folder", "/proplant");

                }
                try {
                    ActivityCompat.startActivityForResult(this as Activity, intent, 1, Bundle());
                } catch (e : Exception) {
                    Toast.makeText(this, "error during multiupload files", Toast.LENGTH_SHORT).show()
                }
                val folderSource = Environment.getExternalStorageDirectory().toString()
                val sourceDir = File(folderSource + "/Download/folder_name")
                val targetDir = File(folderSource + "/Pictures/folder_name")
                //sourceDir.copyRecursively(targetDir)



            } catch (e : Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
            /**
             * Foreach loop ion all created file in specific folder
             */


            //return

                //
             //   super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            //}
           // requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE , DECODE)
  /*          try {


                Files.createDirectories(Paths.get(Environment.getExternalStorageState() + "/Download"))
            } catch (e : Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
*/
        Toast.makeText(this, "upload button pressed", Toast.LENGTH_SHORT).show()
            var alert = AlertDialog.Builder(this).create()
            var filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");
            try {

                filePathRender.copyTo(File(Environment.getExternalStorageDirectory().toString() + "/Download/folder_name", "import" + System.currentTimeMillis() + ".xls"))
                Toast.makeText(this, "copying successfully finished", Toast.LENGTH_SHORT).show()
            } catch (e : Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

    public fun deleteFilesAnyway(view: View?) {
        val folder = Environment.getExternalStorageDirectory().toString() + "/Download/"
        val filesOut = File(folder, "/folder_name/output").listFiles()

        filesOut!!.mapIndexed { index, item ->
            item.delete()
        }

        Toast.makeText(this, "POLOŽKY SMAZÁNY ", Toast.LENGTH_SHORT).show()
    }

    /**
     * Call the default view.
     */
    fun loadScanKitBtnClick(view: View?) {
        requestPermission(CAMERA_REQ_CODE, DECODE)
    }

    fun loadScanForContinue(view: View?) {
        //return
        requestPermission(CAMERA_REQ_CODE, DECODE)
    }

    /**
     * Call the customized view.
     */
    fun newViewBtnClick(view: View?) {
        requestPermission(DEFINED_CODE, DECODE)
    }

    /**
     * Call the bitmap.
     */
    fun bitmapBtnClick(view: View?) {
        requestPermission(BITMAP_CODE, DECODE)
    }

    /**
     * Call the MultiProcessor API in synchronous mode.
     */
    fun multiProcessorSynBtnClick(view: View?) {
        requestPermission(MULTIPROCESSOR_SYN_CODE, DECODE)
    }

    /**
     * Call the MultiProcessor API in asynchronous mode.
     */
    fun multiProcessorAsynBtnClick(view: View?) {
        requestPermission(MULTIPROCESSOR_ASYN_CODE, DECODE)
    }

    /**
     * Start generating the barcode.
     */
    fun generateQRCodeBtnClick(view: View?) {
        requestPermission(GENERATE_CODE, GENERATE)
    }

    /**
     * Apply for permissions.
     */
    private fun requestPermission(requestCode: Int, mode: Int) {
        if (mode == DECODE) {
            decodePermission(requestCode)
        } else if (mode == GENERATE) {
            generatePermission(requestCode)
        }
    }

    /**
     * Apply for permissions.
     */
    private fun decodePermission(requestCode: Int) {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE),
            requestCode
        )
    }

    /**
     * Apply for permissions.
     */
    private fun generatePermission(requestCode: Int) {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            requestCode
        )
    }

    /**
     * Call back the permission application result. If the permission application is successful, the barcode scanning view will be displayed.
     * @param requestCode Permission application code.
     * @param permissions Permission array.
     * @param grantResults: Permission application result array.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {

            //
            //super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (permissions == null || grantResults == null) {
            return
        }
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && requestCode == GENERATE_CODE) {
            val intent = Intent(this, GenerateCodeActivity::class.java)
            this.startActivity(intent)
        }
        if (grantResults.size < 2 || grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
            return
        }
        //Default View Mode
        if (requestCode == CAMERA_REQ_CODE) {
            ScanUtil.startScan(
                this,
                REQUEST_CODE_SCAN_ONE,
                HmsScanAnalyzerOptions.Creator().create()
            )


        }
        //Customized View Mode
        if (requestCode == DEFINED_CODE) {
            val intent = Intent(this, DefinedActivity::class.java)
            this.startActivityForResult(intent, REQUEST_CODE_DEFINE)
        }
        //Bitmap Mode
        if (requestCode == BITMAP_CODE) {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra(DECODE_MODE, BITMAP_CODE)
            this.startActivityForResult(intent, REQUEST_CODE_SCAN_MULTI)
        }
        //Multiprocessor Synchronous Mode
        if (requestCode == MULTIPROCESSOR_SYN_CODE) {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra(DECODE_MODE, MULTIPROCESSOR_SYN_CODE)
            this.startActivityForResult(intent, REQUEST_CODE_SCAN_MULTI)
        }
        //Multiprocessor Asynchronous Mode
        if (requestCode == MULTIPROCESSOR_ASYN_CODE) {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra(DECODE_MODE, MULTIPROCESSOR_ASYN_CODE)
            this.startActivityForResult(intent, REQUEST_CODE_SCAN_MULTI)
        }
    }

    /**
     * Event for receiving the activity result.
     *
     * @param requestCode Request code.
     * @param resultCode Result code.
     * @param data        Result.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK || data == null) {
            return
        }
        //Default View
        if (requestCode == REQUEST_CODE_SCAN_ONE) {
            val obj: HmsScan = data.getParcelableExtra(ScanUtil.RESULT)!!
            if (obj != null) {
                val intent = Intent(this, DisPlayActivity::class.java)
                intent.putExtra(RESULT, obj)
                startActivity(intent)
            }
            //MultiProcessor & Bitmap
        } else if (requestCode == REQUEST_CODE_SCAN_MULTI) {
            val obj = data.getParcelableArrayExtra(CommonActivity.SCAN_RESULT)
            if (obj != null && obj.size > 0) {
                //Get one result.
                if (obj.size == 1) {
                    if (obj[0] != null && !TextUtils.isEmpty((obj[0] as HmsScan).getOriginalValue())) {
                        val intent = Intent(this, DisPlayActivity::class.java)
                        intent.putExtra(RESULT, obj[0])
                        startActivity(intent)
                    }
                } else {
                    val intent = Intent(this, DisPlayMulActivity::class.java)
                    intent.putExtra(RESULT, obj)
                    startActivity(intent)
                }
            }
            //Customized View
        } else if (requestCode == REQUEST_CODE_DEFINE) {
            val obj: HmsScan = data.getParcelableExtra(DefinedActivity.SCAN_RESULT)!!
            if (obj != null) {
                val intent = Intent(this, DisPlayActivity::class.java)
                intent.putExtra(RESULT, obj)
                startActivity(intent)
            }
        }
    }

    companion object {
        /**
         * Define requestCode.
         */
        const val CAMERA_REQ_CODE = 111
        const val DEFINED_CODE = 222
        const val BITMAP_CODE = 333
        const val MULTIPROCESSOR_SYN_CODE = 444
        const val MULTIPROCESSOR_ASYN_CODE = 555
        const val GENERATE_CODE = 666
        const val DECODE = 1
        const val GENERATE = 2
        const val REQUEST_CODE_SCAN_ONE = 0X01
        private const val REQUEST_CODE_DEFINE = 0X0111
        private const val REQUEST_CODE_SCAN_MULTI = 0X011
        const val DECODE_MODE = "decode_mode"
        const val RESULT = "SCAN_RESULT"
    }
}