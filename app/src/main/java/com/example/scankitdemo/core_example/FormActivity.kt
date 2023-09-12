package com.example.scankitdemo.core

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.scankitdemo.MainActivity
import com.example.scankitdemo.R
//import com.example.scankitdemo.R
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths





class FormActivity : Activity(), ActivityCompat.OnRequestPermissionsResultCallback {
    private lateinit var alert : AlertDialog
    private lateinit var textViewLabel: TextView
    private lateinit var editTextView: TextView
    private lateinit var editTextViewEdit: EditText
    private lateinit var editTextViewEditText: TextView
    private lateinit var addArray: ArrayList<String>
    private lateinit var save: Button
    private lateinit var show: ListView
    lateinit var arrayAdapter : ArrayAdapter<String>
    lateinit var options: Data
    private lateinit var upload : ImageButton
    private lateinit var barcodeValue : TextView
    //  private lateinit var arrayAdapter: ArrayAdapter<String>
    private lateinit var finishBtn : Button
    private lateinit var data: Data
    private lateinit var btnSaveBG : Button
    private lateinit var excelFile : WriteExcel

    private val filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/final_cutz_down.xls")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
      //return
       // finishBtn = findViewById(R.id.btn_complete)
       //return
        alert = AlertDialog.Builder(this).create()
        textViewLabel = findViewById(R.id.textViewBar)
        editTextView = findViewById(R.id.textViewBar)
        editTextViewEdit = findViewById(R.id.editTextTextPersonName)
        editTextViewEditText = findViewById(R.id.editTextTextPersonName)
        show = findViewById(R.id.listView)
      //  return
        save = findViewById(R.id.button2)
        //btnSaveBG = findViewById(R.id.btn_complete)
        addArray = ArrayList()
        options = Data()
      //  return
        // barcodeValue = findViewById(R.id.textViewBar)
        textViewLabel.text = intent.getStringExtra("barcodeValueTemp").toString()
        //return
        //upload = findViewById(R.id.leaveBtn)

    //    finishBtn.visibility = View.VISIBLE
        //return
        data = Data()
       // return
        //excelFile = WriteExcel()
        var workbook: Workbook = HSSFWorkbook()
        //var fileOutputStream = FileOutputStream(filePathRender)
        //var tv = TextView(this)

        //    return
        save.setOnClickListener {
            var getInput : String = editTextViewEdit.text.toString()
            if(addArray.contains(getInput)) {
                Toast.makeText(this, "Item added", Toast.LENGTH_LONG).show();
                finishBtn.visibility = View.VISIBLE
            } else if (getInput == null || getInput.trim() == "") {
                Toast.makeText(this, "Input field is empty ", Toast.LENGTH_LONG).show();

            } else {
                addArray.add(getInput)
                arrayAdapter= ArrayAdapter(this@FormActivity, android.R.layout.simple_expandable_list_item_1, addArray);
                show.setAdapter(arrayAdapter)
                //editTextViewEdit.setText("  ")
                finishBtn.visibility = View.VISIBLE
                return@setOnClickListener
                try {
                    //options.loadData(this, addArray.last(), "/output.csv")

                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }
                Toast.makeText(applicationContext, "Item added", Toast.LENGTH_LONG).show()
            }
        }

        upload.setOnClickListener {
            Toast.makeText(this, "pressed", Toast.LENGTH_LONG).show()
            //return@setOnClickListener
            //data.getDataFromCSV(this, workbook)
            try {

              //excelFile.writeExcel(this)

            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            }

            try {
                startActivity(Intent(this, FinalRenderActivity::class.java))
            } catch (e : Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }

        }

        editTextViewEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("Not yet implemented")
                //editTextViewEdit.background = ContextCompat.getDrawable(this, R.drawable.if_is_empty);
                if(count == 0) {
                    finishBtn.visibility = View.INVISIBLE
                } else {

                    finishBtn.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {
                //TODO("Not yet implemented")
            }

        })

        /*finishBtn.setOnClickListener {
            var intentActivityRes = Intent(this@FormActivity, FinalRenderActivity::class.java)
            try {
            data.alertCancelOrExit(this@FormActivity, intentActivityRes)
            //startActivity(intentActivityRes)
                //data.alertShow(applicationContext)
                //data.alertShow(this)

            } catch (e : Exception) {
                alert.setMessage(e.message)
                alert.show()
            }
        }*/

        /*finishBtn.setOnClickListener {
            var getInput : String = editTextViewEdit.text.toString()

            if(addArray.contains(getInput)) {
                Toast.makeText(this, "Item added", Toast.LENGTH_LONG).show();
                //startActivity(Intent(this, MainActivity::class.java))
                finishBtn.visibility = View.VISIBLE
                // startActivity(Intent(this@FormActivity, FinalRenderActivity::class.java))
                var activityContinue = Intent(this@FormActivity, FormActivity::class.java)
                data.alertCancelOrExit(this, activityContinue)
            } else if (getInput == null || getInput.trim() == "") {
                Toast.makeText(this, "Input field is empty ", Toast.LENGTH_LONG).show();
                editTextViewEdit.background = ContextCompat.getDrawable(this, R.drawable.if_is_empty);


            } else {
                addArray.add(getInput)
                arrayAdapter= ArrayAdapter(this@FormActivity, android.R.layout.simple_expandable_list_item_1, addArray);
                show.setAdapter(arrayAdapter)
                //editTextViewEdit.setText("  ")
                try {

                    options.loadData(this, addArray.last(), "/output.csv")
                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }


                Toast.makeText(applicationContext, "Item from edit added", Toast.LENGTH_LONG).show()
                options.loadData(this, ";\n", "/output.csv")
                //startActivity(Intent(this@FormActivity, MainActivity::class.java))


                //requestPermissions()

                fun decodePermission(requestCode: Int) {
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE),
                        requestCode
                    )
                }

                fun generatePermission(requestCode: Int) {
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        requestCode
                    )
                }
                fun requestPermission(requestCode: Int, mode: Int) {
                    if (mode == MainActivity.DECODE) {
                        decodePermission(requestCode)
                    } else if (mode == MainActivity.GENERATE) {
                        generatePermission(requestCode)
                    }
                }
               // requestPermissions(MainActivity.DEFINED_CODE, MainActivity.DECODE)
                try {
                   // requestPermission(MainActivity.CAMERA_REQ_CODE, MainActivity.DECODE)
                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }
                //startActivity(Intent(this, FinalRenderActivity::class.java))





            }

        }*/

        editTextViewEdit.setOnClickListener {
            var getInput : String = editTextViewEdit.text.toString()
            if(addArray.contains(getInput)) {
                Toast.makeText(this, "Item added", Toast.LENGTH_LONG).show();
                //startActivity(Intent(this, MainActivity::class.java))
                finishBtn.visibility = View.VISIBLE
                // startActivity(Intent(this@FormActivity, FinalRenderActivity::class.java))
                startActivity(Intent(this@FormActivity, MainActivity::class.java))

            } else if (getInput == null || getInput.trim() == "") {
                Toast.makeText(this, "Input field is empty ", Toast.LENGTH_LONG).show();

            } else {
                addArray.add(getInput)
                arrayAdapter= ArrayAdapter(this@FormActivity, android.R.layout.simple_expandable_list_item_1, addArray);
                show.setAdapter(arrayAdapter)
                editTextViewEdit.setText("  ")
                try {

                    options.loadData(this, addArray.last(), "/output.csv")
                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }


                Toast.makeText(applicationContext, "Item from edit added", Toast.LENGTH_LONG).show()
                options.loadData(this, ";\n", "/output.csv")
                //startActivity(Intent(this@FormActivity, MainActivity::class.java))


                //requestPermissions()

                fun decodePermission(requestCode: Int) {
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE),
                        requestCode
                    )
                }

                fun generatePermission(requestCode: Int) {
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        requestCode
                    )
                }
                fun requestPermission(requestCode: Int, mode: Int) {
                    if (mode == MainActivity.DECODE) {
                        decodePermission(requestCode)
                    } else if (mode == MainActivity.GENERATE) {
                        generatePermission(requestCode)
                    }
                }
                // requestPermissions(MainActivity.DEFINED_CODE, MainActivity.DECODE)
                try {
                    // requestPermission(MainActivity.CAMERA_REQ_CODE, MainActivity.DECODE)
                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }
                //startActivity(Intent(this, FinalRenderActivity::class.java))





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
                /*if (!filePathRender.exists()) {
                    filePathRender.createNewFile()
                    alert.setMessage("ffdf")
                    alert.show()
                } else {
                    alert.setMessage("exists")
                    alert.show()
                }*/

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
                    val fileOut = FileOutputStream(filePathRender)
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







    }

    override fun onBackPressed() {

    }




}