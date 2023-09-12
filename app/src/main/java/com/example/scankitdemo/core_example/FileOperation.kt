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
package com.example.scankitdemo.core

import android.app.AlertDialog
import android.content.Context
import android.graphics.ImageFormat
import android.hardware.Camera
import android.hardware.Camera.PreviewCallback
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.view.SurfaceHolder
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import jcifs.smb.NtlmPasswordAuthentication
import jcifs.smb.SmbFile
import jcifs.smb.SmbFileOutputStream
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Row
import java.io.*


class FileOperation : AppCompatActivity(), IFile {
    private var camera: Camera? = null
    private var parameters: Camera.Parameters? = null
    private var isPreview = false
    private val frameCallback: FrameCallback = FrameCallback()
    private val width = 1920
    private val height = 1080
    private val defaultZoom = 1.0
    var filePath = File(Environment.getExternalStorageDirectory().toString() + "/Seznam zásob na skladě  Sklad p.xls")
    var filePathTempData = File(Environment.getExternalStorageDirectory().toString() + "/outputData.csv")
    var fileOutputStream = FileOutputStream(filePath)


    // private lateinit var alert : AlertDialog
    private lateinit var alert: AlertDialog

    /**
     * Open up the camera.
     */
    @Synchronized
    @Throws(IOException::class)
    fun open(holder: SurfaceHolder?) {
        camera = Camera.open()
        parameters = camera!!.getParameters()!!
        parameters!!.setPictureSize(width, height)
        parameters!!.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)
        parameters!!.setPictureFormat(ImageFormat.NV21)
        camera!!.setPreviewDisplay(holder)
        camera!!.setDisplayOrientation(90)
        camera!!.setParameters(parameters)

        //alert = AlertDialog.Builder()

    }


    @Synchronized
    fun close() {
        if (camera != null) {
            camera!!.release()
            camera = null
        }
    }

    @Synchronized
    fun startPreview() {
        if (camera != null && !isPreview) {
            camera!!.startPreview()
            isPreview = true
        }
    }

    @Synchronized
    fun stopPreview() {
        if (camera != null && isPreview) {
            camera!!.stopPreview()
            frameCallback.setProperties(null)
            isPreview = false
        }
    }

    @Synchronized
    fun callbackFrame(handler: Handler?, zoomValue: Double) {
        if (camera != null && isPreview) {
            frameCallback.setProperties(handler)
            if (camera!!.parameters.isZoomSupported && zoomValue != defaultZoom) {
                //Auto zoom.
                parameters!!.zoom = convertZoomInt(zoomValue)
                camera!!.parameters = parameters
            }
            camera!!.setOneShotPreviewCallback(frameCallback)
        }
    }

    fun convertZoomInt(zoomValue: Double): Int {
        val allZoomRatios = parameters!!.zoomRatios
        val maxZoom = Math.round(allZoomRatios[allZoomRatios.size - 1] / 100f).toFloat()
        if (zoomValue >= maxZoom) {
            return allZoomRatios.size - 1
        }
        for (i in 1 until allZoomRatios.size) {
            if (allZoomRatios[i] >= zoomValue * 100 && allZoomRatios[i - 1] <= zoomValue * 100) {
                return i
            }
        }
        return -1
    }

    internal inner class FrameCallback : PreviewCallback {
        private var handler: Handler? = null
        fun setProperties(handler: Handler?) {
            this.handler = handler
        }

        override fun onPreviewFrame(data: ByteArray, camera: Camera) {
            if (handler != null) {
                val message = handler!!.obtainMessage(
                    0, camera.parameters.previewSize.width,
                    camera.parameters.previewSize.height, data
                )
                message.sendToTarget()
                handler = null
            }
        }
    }

    companion object {
        private const val TAG = "CameraOperation"
    }


    public
    override fun loadData(context: Context?, data: String?, filename: String) {
        //TODO("Not yet implemented")
        /*var alert = AlertDialog.Builder(context).create()

        var file = File(context!!.getExternalFilesDir(null), filename)
        if (file.exists()) {
            file.appendText(data.toString())
        } else {
            file.createNewFile()
            file.appendText(data.toString())
        }

         */

        //var file = filePath
        var file = filePathTempData

        try {
            if (!file.exists()) {
                file.createNewFile()
                file.appendText(data.toString())
            } else {
                file.appendText(data.toString())
            }
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }


    }

    override fun getCSV(context: Context?, oldFile: String?, newFile: String?) {
        File(context?.getExternalFilesDir(null), oldFile.toString())
            .renameTo(File(context?.getExternalFilesDir(null), newFile.toString()))
    }

    fun getAdresarAplikaceFiles(): String? {
        return Environment.getExternalStorageDirectory()
            .toString() + File.separator + "Android" + File.separator + "data" + File.separator + "com.example.scankitdemo" + File.separator + "files"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun readCsv(file: String?, context: Context) {
        //TODO("Not yet implemented")
        var alertDialog = AlertDialog.Builder(context).create()
        var directory = context?.getExternalFilesDir(null)
        val bufferedReader =
            BufferedReader(FileReader(File(context?.getExternalFilesDir(null), file.toString())));
        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);
        var tv = TextView(context)

        for (csvData in csvParser) {
            //alertDialog.setMessage()
            tv.text = tv.text.toString() + " " + csvData.get(0) + "\n"
        }
        alertDialog.setMessage(tv.text.toString())
        alertDialog.show()
    }

    public fun transferFileToSamba(context: android.content.Context) {

        alert = AlertDialog.Builder(context).create()
        var srcFile = File(context?.getExternalFilesDir(null).toString(), "/pp.txt")
            .copyTo(
                File(
                    Environment.getExternalStorageDirectory().toString() + "/Pictures/pp.new.txt"
                ), true
            )
        /*File("C:/Users/sampleuser/Downloads/test.txt").let { sourceFile ->
            sourceFile.copyTo(File("C:/Users/sampleuser/Documents/test.txt"))
            sourceFile.delete()
        }*/
        //return
        try {
            //srcFile.copyTo(Environment.getExternalStorageDirectory().absoluteFile)
            alert.setMessage(Environment.getExternalStorageDirectory().absolutePath);
            alert.show()
            //return
            //srcFile.copyTo(Environment.getExternalStorageDirectory(), overwrite = false )
            //srcFile.copyF(getAdresarAplikaceFiles().toString(), overwrite = false )

        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        return
        try {

            val user = "root"
            val pass = "okyop3ld"
            val sharedFolder = "MyShare"
            val path = "smb://37.205.10.181/$sharedFolder/test.txt"
            val auth = NtlmPasswordAuthentication("", user, pass)
            val smbFile = SmbFile(path, auth)
            val smbfos = SmbFileOutputStream(smbFile)
            smbfos.write("testing....and writing to a file".toByteArray())
            alert.setMessage("completed ...nice !")
            alert.show()
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }

    }


    public fun loadCSVdatam(context: Context, file: String?) {
        var headers = mutableListOf("PLU", "pcs")
        var alertDialog = AlertDialog.Builder(context).create()
        var directory = context?.getExternalFilesDir(null)
        val bufferedReader =
            BufferedReader(
                FileReader(
                    File(
                        Environment.getExternalStorageDirectory().toString(),
                        file.toString()
                    )
                )
            );
        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);
        var tv = TextView(context)

        for (csvData in csvParser) {
            //alertDialog.setMessage()
            tv.text = tv.text.toString() + " " + csvData.get(0) + "\n"
        }
        alertDialog.setMessage(tv.text.toString())
        //alertDialog.show()
        var rowCount = 0;
        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet: HSSFSheet = hssfWorkbook.createSheet("Custom Sheet")
        val hssfRow: HSSFRow = hssfSheet.createRow(0)
        val hssfCell: HSSFCell = hssfRow.createCell(0)
        try {
            if (!filePath.exists()) {
                filePath.createNewFile()
                alert.setMessage("ffdf")
                alert.show()
            } else {
                alert.setMessage("exists")
                alert.show()
            }
            //for (rn in headers.indices) {
                val r: Row = hssfSheet.createRow(++rowCount)
                // val header: Row = sheet.createRow(0)
                //tv.text = tv.text.toString() +
                //tv.text = tv.text.toString() +
                //r.createCell(2).setCellValue("Header3")
                //tv.text = tv.text.toString() + r.createCell(0).setCellValue("12804")
                //tv.text = tv.text.toString() + r.createCell(1).setCellValue("10")
                r.createCell(1).setCellValue("KS")

                for (csvData in csvParser) {
                    //alertDialog.setMessage()
                    r.createCell(rowCount).setCellValue(csvData.get(0) + "\n")

                    tv.text = tv.text.toString() + " " + csvData.get(0) + "\n"
                    r.createCell(rowCount++).setCellValue(csvData.get(0) + "____")
                }
                //r.createCell(0).setCellValue("20222")
                //r.createCell(1).setCellValue("20")
                //r.createCell(3).setCellValue("Header4")
                try {

                    hssfWorkbook.write(fileOutputStream)
                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }

                // hssfWorkbook.write(headers[rn])
                if (fileOutputStream != null) {
                    //fileOutputStream.flush()
                    //fileOutputStream.close()
              //  }
            }

        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }

        /* alert = AlertDialog.Builder(context).create()

             val url = "smb://37.205.10.181/MyShare"
             val auth = NtlmPasswordAuthentication(null, "guest", "patera")
             try {

                 var dir = SmbFile(url, auth)
             } catch (e : Exception) {
                 alert.setMessage(e.message)
                 alert.show()
             }
             try {
                 var dir = SmbFile(url, auth)
             for (f in dir.listFiles()) {
                   println(f.name)
             }
             } catch (e : Exception) {
                 alert.setMessage(e.message)
                 alert.show()
             }
             //for (f in dir.listFiles()) {
               //  println(f.name)
             //}
             return
             // video is some file in internal storage
             val to = File("/sdcard/Pictures/" + "test.txt")
             //val to = File(Environment.getExternalStorageDirectory().absolutePath + "/Pictures/text.txt")
             //video.copyTo(to, true)


             val srcFile = File(context?.getExternalFilesDir(null).toString() + "/pp.txt")

             try {
                 srcFile.copyTo(to, true)
                 alert.setMessage("sucessfully copied");
                 alert.show()

                 //Toast.makeText(context, "Successfully copied", Toast.LENGTH_SHORT).show()
                 //alert.setMessage()
             } catch (e: Exception) {
                 alert.setMessage(e.message)
                 alert.show()


                 try {


                     srcFile.copyTo(Environment.getExternalStorageDirectory().absoluteFile, true)
                 } catch (e: Exception) {
                     alert.setMessage(e.message); alert.show()
                 }
                 alert.setMessage(Environment.getExternalStorageDirectory().absolutePath)
                 alert.show()
                 //srcFile.copyTo(to)
                 return
                 /*val url = "smb://37.205.10.181/MyShare/"
             val auth = NtlmPasswordAuthentication(null, "guest", "patera")
             val dir = SmbFile(url, auth)
             for (f in dir.listFiles()) {
                 println(f.name)
             }*/
             }*/
    }
}

