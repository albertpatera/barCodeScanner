package com.example.scankitdemo.core

import android.app.AlertDialog
import android.content.Context
import android.os.Environment
import android.widget.TextView
import android.widget.Toast
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import com.huawei.hms.scankit.p.wb

import org.apache.poi.ss.usermodel.CellStyle




//import statements
class WriteExcel{
    private val filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/out__" + System.currentTimeMillis()+ ".xls")

    // private lateinit var alert : AlertDialog

    var workbook: Workbook = HSSFWorkbook()
    var hssfWorkbook = HSSFWorkbook()
    lateinit var sheet: HSSFSheet

    //var hssfSheet: HSSFSheet = workbook.createSheet("Custom Sheet")
    //var tv = TextView(this)
    fun writeExcel(context : Context) {
        //Blank workbook
       var alert = AlertDialog.Builder(context).create()

        if (!filePathRender.exists()) {
            filePathRender.createNewFile()
            alert.setMessage("ffdf")
            alert.show()
        } else {
            alert.setMessage("exists")
            alert.show()
        }
       //return
       //try {
           //hssfSheet =  hssfWorkbook.createSheet("Custom Sheet")


                //return

           //try {

        var header = mutableListOf("")
        var rn = mutableListOf("pp", "oo", "rr", "err")
               sheet = workbook.createSheet("Employee Data") as HSSFSheet

        val bufferedReader = Files.newBufferedReader(
            Paths.get(
                Environment.getExternalStorageDirectory().toString() + "/Download//temp_out.csv"
            )
        );

        var csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)
               var fileOutputStream = FileOutputStream(filePathRender)
            //var dataArray = arrayOff<String>
               val data: MutableMap<String, Array<Any>> = TreeMap<String, Array<Any>>()
               data["1"] = arrayOf("ID", "NAME", "LASTNAME")
               data["2"] = arrayOf(1, "Amit", "Shukla")
               data["3"] = arrayOf(2, "Lokesh", "Gupta")
               data["4"] = arrayOf(3, "John", "Adwards")
               data["5"] = arrayOf(4, "Brian", "Schultz")

               val keyset: Set<String> = data.keys
                var rownum = 0
        var tv = TextView(context)
               for (key in keyset) {

               val row: Row = sheet.createRow(rownum++)
                 for(item in rn.indices) {

                     for(pol in csvParser) {
                         tv.text = tv.text.toString() + pol.get(0)
                         tv.text = tv.text.toString() + pol.get(1)
                        // row.createCell(0).setCellValue(pol.get(0))
                         //row.createCell(1).setCellValue(pol.get(1))
                         row.createCell(1).setCellValue(tv.text.toString())



                     }
                 }
                 val objArr = data[key]!!
               var cellnum = 0
               for (obj in objArr) {
                   val cell: Cell = row.createCell(cellnum++)
                   if (obj is String) cell.setCellValue(obj) else if (obj is Int) cell.setCellValue(obj as String)
                   //cell.setCellValue()
                   //Toast.makeText(context, "yes", Toast.LENGTH_LONG).show()
                   //row.create14Cell(0).setCellValue("errr")

                   //for (item in rn.indices) {

                       //rotady to funguje w.createCell(0).setCellValue("gfrgtgtt")
                      // row.createCell(1).setCellValue(tv.text.toString()+ "text")
                   //}
                   var csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)
                   var tv = TextView(context)
                   var del = "name, 2012, 2017".split(",").toTypedArray()
                  try {

                       for (itemRowm in csvParser) {

                           row.createCell(0).setCellValue(itemRowm.get(0) + del.contentToString())
                           row.createCell(1).setCellValue(itemRowm.get(1) + del.contentToString())
                           row.createCell(1).setCellValue(tv.text.toString())
                       }
                       /*for (item in rn.indices) {
                           var row = sheet.createRow(del.count())
                           var cell = row.createCell(1)
                           for (pol in csvParser) {
                               tv.text =
                                   tv.text.toString() + del.contentToString() + pol.get(0) + "\n"
                               cell?.setCellValue(
                                   tv.text.toString() + del.contentToString() + pol.get(1)
                               )
                               cell?.setCellValue(tv.text.toString())
                               row.createCell(0).setCellValue("ppp")
                           }
                           //cell?.setCellValue(obj)
                       }*/
                       alert.setMessage(tv.text.toString())
                       alert.show()

                   } catch (e : Exception) {
                       alert.setMessage(e.message)
                       alert.show()
                   }
               }

                   val bufferedReader = Files.newBufferedReader(
                       Paths.get(
                           Environment.getExternalStorageDirectory().toString() + "/Download//temp_out.csv"
                       )
                   );

                   var csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)
                    var tv = TextView(context)
                   var tvPeaces = TextView(context)
                   var del = "name, 2012, 2017".split(",").toTypedArray()

                   for(item in del) {
                       del.get(0)

                       Toast.makeText(context, del.get(0), Toast.LENGTH_LONG).show()
                   }

                   for(csvData in csvParser) {
                      // for(data in dataArray) {
                           //  dataArray.add(0.toString(), )

                           //}
                       //}
                   }
                  // return

                   //var dataArray = mutableListOf("")

                   //dataArray.add(0, "plu")
                   //dataArray.add()


                  // return
                   try {
                       for(pol in csvParser) {
                       for (item in rn.indices) {
                           var rowCsvCont = 0;

                           var row = sheet.createRow(cellnum++)
                           var cell = row.createCell(rowCsvCont++)                        // for (pol in csvParser) {
                               tv.text =
                                   tv.text.toString() + del.contentToString() + pol.get(0) + "\n"
                               tv.text =  tv.text.toString() + del.contentToString() + pol.get(1)

                              /* row.?.setCellValue(
                                   tv.text.toString() + del.contentToString() + pol.get(1)
                               )*/
                               tvPeaces.text = tvPeaces.text.toString() + pol.get(1)
                               tv.text = tv.text.toString() + pol.get(0) + "\n"
                              // row.createCell(0).setCellValue(tv.text.toString() + pol.get(0) + "\n klklkklk")
                              // 0row.createCell(1).setCellValue(pol.get(1) +"\n\n\n")

                           cell.setCellValue(pol.get(1))
                           cell.setCellValue(pol.get(1))
                           //row.createCell(cellnum++).setCellValue("Use \\n with word wrap on to create a new line")

                           //val row: Row = sheet.createRow(2)
                          // val cell = row.createCell(2)
                           cell.setCellValue("Use \n with word wrap on to create a new line")

//to enable newlines you need set a cell styles with wrap=true

//to enable newlines you need set a cell styles with wrap=true
                          // val cs: CellStyle = wb.createCellStyle()
                           //cs.wrapText = true
                           //cell.cellStyle = cs
                           val arrayname = arrayOf(1, 2, 3, 4, 5)

                           // declaring an array using arrayOf<Int>
                           val arrayname2 = arrayOf<Int>(10, 20, 30, 40, 50)
                           for (i in 0..arrayname2.size-1)
                           {
                               //print(" "+arrayname2[i])
                            //   cell.setCellValue(arrayname2[i].toString())
                           }
                            // row.createCell(1).setCellValue(tv.text.toString() + "")
                                //row.createCell(0).setCellValue(tvPeaces.text.toString() + "")

                           //row.createCell()
                           //row?.setCellValue(3, "rrererr")
                               //cell?.setCellValue(tv.text.toString())
                           }
                       }

                   } catch (e : Exception) {
                       alert.setMessage(e.message)
                       alert.show()
                   }
               }

               try {

                   workbook.write(fileOutputStream)
                   Toast.makeText(context, "successfully writed !!!", Toast.LENGTH_LONG).show()
                   alert.setMessage("kok, writed")
                   alert.show()
               } catch (e : Exception) {
                   alert.setMessage(e.message)
                   alert.show()
               }
           /*} catch (e : Exception) {
               alert.setMessage(e.message)
               alert.show()
           }*/


            //Iterate over data and write to sheet
            //var rownum = 0
            //for (key in keyset) {

                //val row: Row = sheet.createRow(rownum++)
              //  val objArr = data[key]!!
                //var cellnum = 0
                /*for (obj in objArr) {
                    val cell: Cell = row.createCell(cellnum++)
                    //if (obj is String) cell.setCellValue(obj) else if (obj is Int) cell.setCellValue(obj as kotlin.Int?.to)
                    cell.setCellValue("kkk")
                }*/
            //}
        //} catch (e : Exception) {
          //  alert.setMessage(e.message)
            //alert.show()
        //}

        //Create a blank sheet

        //This data needs to be written (Object[])

        /*try {
            //Write the workbook in file system
            val out = FileOutputStream(File("howtodoinjava_demo.xlsx"))
            workbook.write(out)
            out.close()
            println("howtodoinjava_demo.xlsx written successfully on disk.")
        } catch (e: Exception) {
            e.printStackTrace()
        }*/
    }
}