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

//import com.example.scankitdemo.core.TenpActivity
//import java.lang.Exception
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Color.rgb
import android.net.Uri
import android.os.*
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.BackgroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.text.backgroundColor
import com.example.scankitdemo.action.*
import com.example.scankitdemo.core.Data
import com.example.scankitdemo.core.FileOperation
import com.example.scankitdemo.core.ItemEntity
import com.example.scankitdemo.core.MainCoreActivity
import com.google.android.material.snackbar.Snackbar
import com.huawei.hms.hmsscankit.ScanUtil
import com.huawei.hms.ml.scan.HmsScan
import com.huawei.hms.ml.scan.HmsScan.WiFiConnectionInfo
import java.io.File
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class DisPlayActivity : Activity(), ActivityCompat.OnRequestPermissionsResultCallback {
    //Define a view.
    private var backBtn: ImageView? = null
    private var copyButton: Button? = null
    private var codeFormat: TextView? = null
    private var resultType: TextView? = null
    private var rawResult: TextView? = null
    private var icon: ImageView? = null
    private var iconText: TextView? = null
    private var resultTypeTitle: TextView? = null
    private var wiFiConnectionInfo: WiFiConnectionInfo? = null
    lateinit var operation : FileOperation
    private lateinit var alert : AlertDialog
    private lateinit var options : Data
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        operation = FileOperation()

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_display)
        alert = AlertDialog.Builder(this).create()
        options = Data()
        //alert.setMessage("eeee")
        //alert.show()
        //return

        try {
            //fstartActivity(Intent(this@DisPlayActivity, InsertActivity::class.java))
            //return
            //redirect.putExtra("barcodeValue", "rrrrr")
            //startActivity(redirect
           // )
        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        //Toast.makeText(this, "doneenečnene", Toast.LENGTH_LONG).show()
        //return
        //return
        /*try {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.MANAGE_EXTERNAL_STORAGE),
            )
            //operation.loadData(this, "ttt", "/noWherghhgheToRun.txt")
        } catch (e : Exception) {
            alert.setMessage("nnn")
            alert.show()
        }*/
        //return
        backBtn = findViewById(R.id.result_back_img_in)
        backBtn!!.setOnClickListener(View.OnClickListener { finish() })
        codeFormat = findViewById(R.id.barcode_type)
        icon = findViewById(R.id.diplay_icon)
        iconText = findViewById(R.id.diplay_text)
        resultType = findViewById(R.id.barcode_type_mon)
        rawResult = findViewById(R.id.barcode_rawValue)
        resultTypeTitle = findViewById(R.id.barcode_type_mon_t)
        copyButton = findViewById(R.id.button_operate)
        operation = FileOperation()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val window = window
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            val relativeLayout = findViewById<RelativeLayout>(R.id.result_title)
            if (relativeLayout != null) {
                val lp = RelativeLayout.LayoutParams(
                    relativeLayout.layoutParams.width,
                    relativeLayout.layoutParams.height
                )
                lp.setMargins(0, statusBarHeight, 0, 0)
                relativeLayout.layoutParams = lp
            }

            //Obtain the scanning result.


            val obj: HmsScan = intent.getParcelableExtra(ScanUtil.RESULT)!!
            try {
               // if(hmsScan.getScanType() == HmsScan.CODE128_SCAN_TYPE)
                valueFillIn(obj)

            } catch (e: Exception) {
                alert
            };


        }
        var alert = AlertDialog.Builder(this).create();
      //  val vibrator = this.getSystemService(this.VIBRATOR_SERVICE) as Vibrator
       // vibrator.vibrate(300)
        try {
            //load("kkk")

            //alert.setMessage("ok..")
            //alert.show()
        } catch (e: Exception) {

            alert.setMessage(e.message)
        }
        try {
            var coreStart = Intent(this, MainCoreActivity::class.java)
             //startActivity(coreStart)
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
    }

    /*fun load(data: String)  {
        var file = File(Environment.getExternalStorageDirectory().toString(), "/null.ttt");
        if (file.exists())  {
            file.appendText(data)
        } else {
            file.createNewFile()
            file.appendText(data)

        }
    }*/

    @RequiresApi(Build.VERSION_CODES.N)
    public fun valueFillIn(hmsScan: HmsScan?) {
        var alertDialog = AlertDialog.Builder(this).create()
        rawResult!!.text = hmsScan!!.getOriginalValue()
        if(hmsScan.getScanType() == HmsScan.CODE128_SCAN_TYPE) {
           //startActivity(Intent(this@DisPlayActivity, FormActivity::class.java))
           //alert.setMessage("eeeee");
            //alert.show()
            //startActivity(Intent(this, DisPlayActivity::class.java))fcopyf


        }
       /////////// return
        if (hmsScan.getScanType() == HmsScan.QRCODE_SCAN_TYPE) {
            codeFormat!!.text = "QR code"
        } else if (hmsScan.getScanType() == HmsScan.AZTEC_SCAN_TYPE) {
            codeFormat!!.text = "AZTEC code"
        } else if (hmsScan.getScanType() == HmsScan.DATAMATRIX_SCAN_TYPE) {
            codeFormat!!.text = "DATAMATRIX code"
        } else if (hmsScan.getScanType() == HmsScan.PDF417_SCAN_TYPE) {
            codeFormat!!.text = "PDF417 code"
        } else if (hmsScan.getScanType() == HmsScan.CODE93_SCAN_TYPE) {
            codeFormat!!.text = "CODE93"
        } else if (hmsScan.getScanType() == HmsScan.CODE39_SCAN_TYPE) {
            codeFormat!!.text = "CODE39"
        } else if (hmsScan.getScanType() == HmsScan.CODE128_SCAN_TYPE) {
            codeFormat!!.text = "CODE128"
        } else if (hmsScan.getScanType() == HmsScan.EAN13_SCAN_TYPE) {
            codeFormat!!.text = "EAN13 code"
        } else if (hmsScan.getScanType() == HmsScan.EAN8_SCAN_TYPE) {
            codeFormat!!.text = "EAN8 code"
        } else if (hmsScan.getScanType() == HmsScan.ITF14_SCAN_TYPE) {
            codeFormat!!.text = "ITF14 code"
        } else if (hmsScan.getScanType() == HmsScan.UPCCODE_A_SCAN_TYPE) {
            codeFormat!!.text = "UPCCODE_A"
        } else if (hmsScan.getScanType() == HmsScan.UPCCODE_E_SCAN_TYPE) {
            codeFormat!!.text = "UPCCODE_E"
        } else if (hmsScan.getScanType() == HmsScan.CODABAR_SCAN_TYPE) {
            codeFormat!!.text = "CODABAR"
        }


        //return
        //Show the barcode result.
        if (hmsScan.getScanType() == HmsScan.QRCODE_SCAN_TYPE) {
            resultType!!.visibility = View.VISIBLE
            resultTypeTitle!!.visibility = View.VISIBLE
            if (hmsScan.getScanTypeForm() == HmsScan.PURE_TEXT_FORM) {
                icon!!.setImageResource(R.drawable.text)
                iconText!!.text = "Text"
                resultType!!.text = "Text"
                copyButton!!.text = "tttttrtrttrtrrttrtr"
                copyButton!!.setOnClickListener {
                    if (rawResult != null && !TextUtils.isEmpty(rawResult!!.text)) {
                        val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                        val mClipData = ClipData.newPlainText("Label", rawResult!!.text)
                        cm.setPrimaryClip(mClipData)
                        Toast.makeText(
                            this@DisPlayActivity,
                            getText(R.string.copy_toast),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.EVENT_INFO_FORM) {
                icon!!.setImageResource(R.drawable.event)
                iconText!!.text = "Event"
                resultType!!.text = "Event"
                copyButton!!.text = "tttttrtrttrtrrttrffrfrftr"
                copyButton!!.setOnClickListener {
                    startActivity(CalendarEventAction.getCalendarEventIntent(hmsScan.getEventInfo()))
                    finish()
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.CONTACT_DETAIL_FORM) {
                icon!!.setImageResource(R.drawable.contact)
                iconText!!.text = "Contact"
                resultType!!.text = "Contact"
                copyButton!!.text = "rrrrrr"
                copyButton!!.setOnClickListener {
                    startActivity(ContactInfoAction.getContactInfoIntent(hmsScan.getContactDetail()))
                    finish()
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.DRIVER_INFO_FORM) {
                icon!!.setImageResource(R.drawable.text)
                iconText!!.text = "Text"
                resultType!!.text = "License"
                copyButton!!.text = "rrerereer"
                copyButton!!.setOnClickListener {
                    if (rawResult != null && !TextUtils.isEmpty(rawResult!!.text)) {
                        val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                        val mClipData = ClipData.newPlainText("Label", rawResult!!.text)
                        try {

                            //load(rawResult!!.text.toString())
                        } catch (e : Exception) {
                            //alertDialog.setMessage(e.message)
                            //alertDialog.show()
                        }
                        cm.setPrimaryClip(mClipData)
                        Toast.makeText(
                            this@DisPlayActivity,
                            getText(R.string.copy_toast),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.EMAIL_CONTENT_FORM) {
                icon!!.setImageResource(R.drawable.email)
                iconText!!.text = "Email"
                resultType!!.text = "Email"
                copyButton!!.text = "črčrere"
                copyButton!!.setOnClickListener {
                    startActivity(
                        Intent.createChooser(
                            EmailAction.getEmailInfo(hmsScan.getEmailContent()),
                            "Select email application."
                        )
                    )
                    //startActivity(EmailAction.getContactInfoIntent(result.getEmailContent()));
                    finish()
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.LOCATION_COORDINATE_FORM) {
                icon!!.setImageResource(R.drawable.location)
                iconText!!.text = "Location"
                resultType!!.text = "Location"
                if (LocationAction.checkMapAppExist(applicationContext)) {
                    copyButton!!.text = "črrrčrč"
                    copyButton!!.setOnClickListener {
                        try {
                            startActivity(LocationAction.getLoactionInfo(hmsScan.getLocationCoordinate()))
                            finish()
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } else {
                    copyButton!!.text = "ččččččč"
                    copyButton!!.setOnClickListener {
                        if (rawResult != null && !TextUtils.isEmpty(rawResult!!.text)) {
                            val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                            val mClipData = ClipData.newPlainText("Label", rawResult!!.text)
                            cm.setPrimaryClip(mClipData)
                            Toast.makeText(
                                this@DisPlayActivity,
                                getText(R.string.copy_toast),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.TEL_PHONE_NUMBER_FORM) {
                icon!!.setImageResource(R.drawable.tel)
                iconText!!.text = "Tel"
                resultType!!.text = "Tel"
                copyButton!!.text = "trtt"
                copyButton!!.setOnClickListener {
                    try {
                        startActivity(DialAction.getDialIntent(hmsScan.getTelPhoneNumber()))
                        finish()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.SMS_FORM) {
                icon!!.setImageResource(R.drawable.sms)
                iconText!!.text = "SMS"
                resultType!!.text = "SMS"
                copyButton!!.text = getText(R.string.send_sms)
                copyButton!!.setOnClickListener {
                    startActivity(SMSAction.getSMSInfo(hmsScan.getSmsContent()))
                    finish()
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.WIFI_CONNECT_INFO_FORM) {
                icon!!.setImageResource(R.drawable.wifi)
                iconText!!.text = "Wi-Fi"
                resultType!!.text = "Wi-Fi"
                copyButton!!.text = getText(R.string.connect_network)
                wiFiConnectionInfo = hmsScan.wifiConnectionInfo
                copyButton!!.setOnClickListener {
                    val permissionWifi = Manifest.permission.ACCESS_WIFI_STATE
                    val permissionWifi2 = Manifest.permission.CHANGE_WIFI_STATE
                    val permission = arrayOf(permissionWifi, permissionWifi2)
                    ActivityCompat.requestPermissions(
                        this@DisPlayActivity,
                        permission,
                        CalendarEvent
                    )
                }
            } else if (hmsScan.getScanTypeForm() == HmsScan.URL_FORM) {
                icon!!.setImageResource(R.drawable.website)
                iconText!!.text = "WebSite"
                resultType!!.text = "WebSite"
                copyButton!!.text = getText(R.string.open_browser)
                copyButton!!.setOnClickListener {
                    val webpage = Uri.parse(hmsScan.getOriginalValue())
                    val intent = Intent(Intent.ACTION_VIEW, webpage)
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }
                }
                resultType!!.text = "WebSite"
            } else {
                icon!!.setImageResource(R.drawable.text)
                iconText!!.text = "Text"
                resultType!!.text = "Text"
                copyButton!!.text = "ttt"
                copyButton!!.setOnClickListener {
                    if (rawResult != null && !TextUtils.isEmpty(rawResult!!.text)) {
                        val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                        val mClipData = ClipData.newPlainText("Label", rawResult!!.text)
                        cm.setPrimaryClip(mClipData)
                        Toast.makeText(
                            this@DisPlayActivity,
                            getText(R.string.copy_toast),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        } else if (hmsScan.getScanType() == HmsScan.EAN13_SCAN_TYPE) {
           //Toast.makeText(this, "špatný formát kódu", Toast.LENGTH_SHORT).show()

            val biggerText = SpannableStringBuilder("PODPOROVANÝ FORMÁT KÓDU")
            biggerText.setSpan(RelativeSizeSpan(2.35f), 0, biggerText.length, 0)
            biggerText.setSpan(BackgroundColorSpan(rgb(245, 93, 66)), 0, biggerText.length, 0)
            Toast.makeText(this, biggerText, Toast.LENGTH_SHORT).show()
            var phoneVibrate = com.example.scankitdemo.core.MainExcelWriter()
            phoneVibrate.vibratePhone(this)
            var backTo = Intent(this, MainActivity::class.java)
            startActivity(backTo)
            return
            try {
               // startActivity(Intent(this@DisPlayActivity, FormActivity::class.java))

            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            }
            if (hmsScan.getScanTypeForm() == HmsScan.ISBN_NUMBER_FORM) {
                icon!!.setImageResource(R.drawable.isbn)
                iconText!!.text = "ISBN"
                resultType!!.visibility = View.VISIBLE
                resultTypeTitle!!.visibility = View.VISIBLE
                resultType!!.text = "ISBN"
            } else if (hmsScan.getScanTypeForm() == HmsScan.ARTICLE_NUMBER_FORM) {
                icon!!.setImageResource(R.drawable.product)
                iconText!!.text = "Product"
                resultType!!.visibility = View.VISIBLE
                resultTypeTitle!!.visibility = View.VISIBLE
                resultType!!.text = "Product"
            } else {
                icon!!.setImageResource(R.drawable.text)
                iconText!!.text = "Text"
                resultType!!.visibility = View.GONE
                resultTypeTitle!!.visibility = View.GONE
            }
            copyButton!!.text = "ttttt"
            copyButton!!.setOnClickListener {
                if (rawResult != null && !TextUtils.isEmpty(rawResult!!.text)) {
                    //Obtain the clipboard manager.
                    val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                    val mClipData = ClipData.newPlainText("Label", rawResult!!.text)
                    cm.setPrimaryClip(mClipData)
                    Toast.makeText(
                        this@DisPlayActivity,
                        getText(R.string.copy_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                try {
                    //startActivity(Intent(this@DisPlayActivity, FormActivity::class.java))
                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }
            }
        } else if (hmsScan.getScanType() == HmsScan.EAN8_SCAN_TYPE || hmsScan.getScanType() == HmsScan.UPCCODE_A_SCAN_TYPE || hmsScan.getScanType() == HmsScan.UPCCODE_E_SCAN_TYPE) {
            //return
            try {
                ///startActivity(Intent(this@DisPlayActivity, FormActivity::class.java))
            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            }
            if (hmsScan.getScanTypeForm() == HmsScan.ARTICLE_NUMBER_FORM) {
                icon!!.setImageResource(R.drawable.product)
                iconText!!.text = "Product"
                resultType!!.visibility = View.VISIBLE
                resultTypeTitle!!.visibility = View.VISIBLE
                resultType!!.text = "Product"
            } else {
                icon!!.setImageResource(R.drawable.text)
                iconText!!.text = "Text"
                resultType!!.visibility = View.GONE
                resultTypeTitle!!.visibility = View.GONE
            }
            copyButton!!.text = "tt"
            copyButton!!.setOnClickListener {
                if (rawResult != null && !TextUtils.isEmpty(rawResult!!.text)) {
                    val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                    val mClipData = ClipData.newPlainText("Label", rawResult!!.text)
                    alertDialog.setMessage(rawResult!!.text.toString())

                    alertDialog.show()
                    cm.setPrimaryClip(mClipData)
                    Toast.makeText(
                        this@DisPlayActivity,
                        getText(R.string.copy_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            try {
               // startActivity(Intent(this@DisPlayActivity, FormActivity::class.java))
            } catch (e: Exception) {
                alert.setMessage(e.message)
                alert.show()
            }
        } else {
            icon!!.setImageResource(R.drawable.text)
            iconText!!.text = "Text"
            copyButton!!.text = "tr"


            try {
                options.loadData(this, rawResult!!.text.toString() + ";", "/output.csv")
                //Toast.makeText(this, "successfully inserted", Toast.LENGTH_

                //intentData.putExtra("barcodeValueTemp", rawResult!!.text.toString())
                try {
                    //var intentData = Intent(this, FormActivity::class.java)
                    val mainCoreExcel = com.example.scankitdemo.core.MainExcelWriter()
                    val write = com.example.scankitdemo.core.writeXls()
                    //mainCoreExcel//.main(mutableListOf<String>("r"))
                    var filePathRender = File(Environment.getExternalStorageDirectory().toString() + "/Download", "/test.xls");
                    if(!filePathRender.exists()) {
                        filePathRender.createNewFile()
                    } else {
                        alert.setMessage(filePathRender.absolutePath)
                       // alert.show()
                        try {
                            //Toast.makeText(applicationContext, "eeee", Toast.LENGTH_SHORT).show()
                            val factory = LayoutInflater.from(this)
                            val view: View = factory.inflate(R.layout.activity_form, null)
                            val view_activity: View = factory.inflate(R.layout.activity_display, null)
                            val enterPCS : TextView = view.findViewById(R.id.editTextTextPersonName)
                            if(rawResult!!.text.length > 5) {
                                //Snackbar.make(view, "Invalid code !", Snackbar.LENGTH_SHORT).show()

                                val toastText = Toast.makeText(applicationContext, "INVAI", Toast.LENGTH_SHORT)
                                val toast: Toast = Toast.makeText(
                                    applicationContext,
                                    "text",
                                    Toast.LENGTH_SHORT
                                )
//the default toast view group is a relativelayout
//the default toast view group is a relativelayout
                                val biggerText = SpannableStringBuilder("NEPLATNá DÉLKA KÓDU")
                                biggerText.setSpan(RelativeSizeSpan(2.35f), 0, biggerText.length, 0)
                                biggerText.setSpan(BackgroundColorSpan(rgb(245, 93, 66)), 0, biggerText.length, 0)
                                //biggerText.setSpan(Gravity(Gravity.CENTER), 0, biggerText.length, 0)
                                var textView = TextView(this)
                                //textView.setText("ttttt")
                                //textView.setBackgroundColor(rgb(245, 93, 66))
                                //textView
                               biggerText.run {
                                    //textView.setText("ttttt")
                                    //textView.setBackgroundColor(rgb(245, 93, 66))
                                    //textView
                                 //   backgroundColor(rgb(245, 93, 66))
                                }
                                //biggerText.setSpan( BackgroundColorSpan(0xFFCCCCCC),0, myString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                Toast.makeText(applicationContext, biggerText, Toast.LENGTH_LONG).show()
                               //Snackbar.make(getVi, biggerText, Snackbar.LENGTH_SHORT).show()
                                // var textToast : TextView = toast.view.findViewById(toast.)
                                //Toast.makeText(applicationContext, "INVALID CODE", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, MainActivity::class.java))
                               // val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                                //vibrator
                                mainCoreExcel.vibratePhone(this)
                                //Snackbar.make(view, "fffffff", Snackbar.LENGTH_SHORT).show()
                                /*val timer = object: CountDownTimer(20000, 1000) {
                                    override fun onTick(millisUntilFinished: Long) {
                                        alertDialog.setMessage("timer")
                                        alertDialog.show()
                                    }

                                    override fun onFinish() {
                                        alertDialog.cancel()
                                        alertDialog.dismiss()
                                    }
                                }
                                timer.start()
                                return*/
                            } else {
                                var recordsToWritely: List<ItemEntity> = mutableListOf<ItemEntity>(
                                  //  ItemEntity("Charles", "Babej", "60"),
                                   //ItemEntity("John", "Doe", "70"),
                                    //ItemEntity(rawResult!!.text.toString(), "super", "80", null),
                                   // ItemEntity("PLU", rawResult!!.text.toString(), 452)
                                )
                              //  mainCoreExcel.writeToExcelFile(filepath = filePathRender.absolutePath, "plu", this, "kusy")
                              //  mainCoreExcel.writeToExcelFile(filepath = filePathRender.absolutePath, rawResult!!.text.toString(), this, enterPCS.text.toString())
                            //@TODO super
                              mainCoreExcel.alertShow(this, data = rawResult!!.text.toString(), dataPLU = rawResult, dataPCS = TextView((this)))
                                //write.appendRows(recordsToWritely, filePathRender.absoluteFile)
                            }

                            return
/*odkomentovat*/
                            //Toast.makeText(applicationContext, "eedddee", Toast.LENGTH_SHORT).show()
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

                            //return
                            intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Download/test.xls");

                            intent.putExtra("progress_title", "Nahrávání souboru...");
                            Toast.makeText(this, "nahravaniDokonceno", Toast.LENGTH_SHORT).show()
                            intent.putExtra("remote_folder", "/proplant");
                            ActivityCompat.startActivityForResult(this, intent, 1, Bundle());

                        } catch (e : Exception) {
                            alert.setMessage(e.message)
                            alert.show()
                        }
                        try {
                            //ActivityCompat.startActivity(this, intent, Bundle());
                        } catch (e : Exception) {

                        }
                    }
                    return
                   // mainCoreExcel.writeToExcelFile("")
                   // startActivity(intentData)
                    //startActivity(Intent(this,  FormActivity::class.java))
                } catch (e : Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }


                //startActivity(Intent(this@DisPlayActivity, FormActivity::class.java))
                //return
                //operation.transferFileToSamba(this)

               //requestPermissions();
               // return
               /* when {
                    ContextCompat.checkSelfPermission(
                        this, Manifest.permission.MANAGE_EXTERNAL_STORAGE


                    ) == PackageManager.PERMISSION_GRANTED -> {
                        // You can use the API that requires the permission.
                        //performAction(...)
                        alertDialog.setMessage("eeee")
                        alertDialog.show()
                    }
                    // shouldShowRequestPermissionRationale(...) -> {
                    // In an educational UI, explain to the user why your app requires this
                    // permission for a specific feature to behave as expected. In this UI,
                    // include a "cancel" or "no thanks" button that allows the user to
                    // continue using your app without granting the permission.
                    //showInContextUI(...)
                    // }
                    else -> {
                        // You can directly ask for the permission.
                        alertDialog.setMessage("permissions not granted")
                        alertDialog.show()
                        requestPermissions(
                            arrayOf(Manifest.permission.MANAGE_EXTERNAL_STORAGE

                            ),
                            30


                        )
                    }
                }*/
            } catch (e : Exception) {
                alertDialog.setMessage(e.message)
                alertDialog.show()
            }

            try {
                //operation.loadData(this, "super je tpo data ", "/noWhereToRun.txt")
                //requestPermission(MainActivity.DEFINED_CODE, MainActivity.DECODE)

               // alert.setMessage("rrr")
                //alert.show()
            } catch (e: Exception) {
                alertDialog.setMessage(e.message)
                alertDialog.show()
            }




            //return
            /*try {
              ;

               // load()
                // load(rawResult!!.text.toString())
                //alertDialog.setMessage("yes")
                 // operation.loadData(this, rawResult!!.text.toString(), "/noWhereToRun.txt")
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
                intent.putExtra("smb_username", "guest");
                intent.putExtra("smb_password", "patera");
//intent.putExtra("smb_domain", "YOURDOMAIN");

                //return
                intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/noWhereToRun.txt");
                intent.putExtra("progress_title", "Nahrávání souboru...");

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

                startActivityForResult(intent, UPLOAD_FILES_REQUEST);

                val status = intent.getStringExtra("TRANSFERSTATUS")
                val files = intent.getStringExtra("TRANSFERAMOUNT")
                val size = intent.getStringExtra("TRANSFERSIZE")
                val time = intent.getStringExtra("TRANSFERTIME")

            } catch (e : Exception) {
                alertDialog.setMessage(e.message)
                alertDialog.show()
            }*/
                //alertDialog.show()
                try {
                    /*try {

                        operation.getAdresarAplikaceFiles()
                        alertDialog.setMessage(operation.getAdresarAplikaceFiles())
                        alertDialog.show()

                        var file = File(operation.getAdresarAplikaceFiles().toString(), "/pp.txt")
                        //file.createNewFile()
                       // file.copyTo(File("/sdcard", "/null.txt" /*"", "/importOut.txt"*/))

                        /*File(this.getExternalFilesDir(null), "/pp.txt").copyTo(File("/sdcard/Android/test" +
                                "" +
                                "" + File.separator, "/pp.txt" /*"", "/importOut.txt"*/))*/
                       // return


                    } catch (e : Exception) {
                        alertDialog.setMessage(e.message)
                        alertDialog.show()
                    }*/
                    //return

                /*try {
                    //try {
                    /*File("/sdcard/Android/data/com.example.scankitdemo/files").walkTopDown().forEach {
                        println(it)
                        alertDialog.setMessage("eeeee")
                        alertDialog.show()
                    }*/
                   // return

                    var tmpFile = File("/sdcard/Android/data/com.example.scankitdemo/files", "/nullsd.txt")

                    if(!tmpFile.exists()) {
                        tmpFile.createNewFile()
                        alertDialog.setMessage("created")
                    } else {
                        alertDialog.setMessage("eeerdferf")
                        alertDialog.show()
                    }
                } catch (e : Exception) {
                    alertDialog.setMessage(e.message)
                    alertDialog.show()
                }*/

                //var enterPeacess = Intent(this, InseertActivity::class.java)
                /*var enterPeacess = Intent(this, InseertActivity::class.java)
               //
                //operation.loadData(this, ",", "/plu2.txt")
                if(rawResult!!.text.count() == 5 || rawResult!!.text.count() == 4) {
                    enterPeacess.putExtra("barcodeValue", rawResult!!.text.toString())
                    operation.loadData(this, rawResult!!.text.toString() + ",", "/null")

                    startActivity(enterPeacess)
                }
                */

                    //operation.loadData(this, "test", "/noWhereToRun.txt")
return
                    try {
                        ;
                        try {

                            //operation.loadData(this, "super;", "/noWhereToRun.txt")
                            Toast.makeText(this, "done....", Toast.LENGTH_LONG).show()




                        } catch (e : Exception) {
                            alertDialog.show()
                        }
                        // load()
                        // load(rawResult!!.text.toString())
                        //alertDialog.setMessage("yes")


                         //operation.loadData(this, rawResult!!.text.toString(), "/noWhereToRun.txt")
                        //startActivity(Intent(this, InseertActivity::class.java));
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
                        intent.putExtra("smb_username", "guest");
                        intent.putExtra("smb_password", "patera");
//intent.putExtra("smb_domain", "YOURDOMAIN");

                        //return
                        intent.putExtra("local_file1", Environment.getExternalStorageDirectory().toString() + "/Demo2.xls");

                        intent.putExtra("progress_title", "Nahrávání souboru...");

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

                        startActivityForResult(intent, UPLOAD_FILES_REQUEST);

                        val status = intent.getStringExtra("TRANSFERSTATUS")
                        val files = intent.getStringExtra("TRANSFERAMOUNT")
                        val size = intent.getStringExtra("TRANSFERSIZE")
                        val time = intent.getStringExtra("TRANSFERTIME")

                    } catch (e : Exception) {
                        alertDialog.setMessage(e.message)
                        alertDialog.show()
                    }

            } catch (e: Exception) {
                alertDialog.setMessage(e.message)
                alertDialog.show()
            }

            copyButton!!.setOnClickListener {

                if (rawResult != null && !TextUtils.isEmpty(rawResult!!.text)) {
                    val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                    val mClipData = ClipData.newPlainText("Label", rawResult!!.text)
                    cm.setPrimaryClip(mClipData)
                    try {
                      // operation.loadData(this, p);

                    } catch (e : Exception) {
                        alertDialog.setMessage(e.message)
                    }
                    Toast.makeText(
                        this@DisPlayActivity,
                        getText(R.string.copy_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            resultType!!.visibility = View.GONE
            resultTypeTitle!!.visibility = View.GONE
        }
    }

    val CalendarEvent = 0x3300
    /*override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CalendarEvent -> {
                if (grantResults.size > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    if (wiFiConnectionInfo != null) {
                        WifiAdmin(this@DisPlayActivity).Connect(
                            wiFiConnectionInfo!!.getSsidNumber(),
                            wiFiConnectionInfo!!.getPassword(), wiFiConnectionInfo!!.getCipherMode()
                        )
                        this@DisPlayActivity.startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                        finish()
                    }
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }*/

    override fun onStop() {
        super.onStop()
    }

    // Obtain the ID.
    protected val statusBarHeight: Int
        protected get() {
            var result = 0
            // Obtain the ID.
            if (resources != null) {
                val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
                if (resourceId > 0) {
                    result = resources.getDimensionPixelSize(resourceId)
                }
            }
            return result
        }
}

