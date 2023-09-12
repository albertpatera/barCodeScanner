package com.example.scankitdemo.core

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.graphics.Color.rgb
import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.scankitdemo.MainActivity
import com.example.scankitdemo.R
import com.huawei.hms.hmsscankit.RemoteView.REQUEST_CODE_PHOTO
import com.huawei.hms.hmsscankit.ScanUtil
import com.huawei.hms.ml.scan.HmsScan
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), ActivityCompat.OnRequestPermissionsResultCallback {
    private lateinit var insertPieciesTextEdit : EditText
    private lateinit var insertPieciesTextView : TextView
    private lateinit var options : com.example.scankitdemo.core.FileOperation
    private lateinit var diaplayPLUtext : TextView
    lateinit var loading : ProgressBar
    lateinit var alert : AlertDialog
    private var builder: AlertDialog.Builder? = null;



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    private fun decodePermission(requestCode: Int) {
        ActivityCompat.requestPermissions(
            requireActivity(), arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE),
            requestCode
        )
    }
    private fun generatePermission(requestCode: Int) {
        ActivityCompat.requestPermissions(
            requireActivity(), arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            requestCode
        )
    }
    private fun requestPermission(requestCode: Int, mode: Int) {
        if (mode == MainActivity.DECODE) {
            decodePermission(requestCode)
        } else if (mode == MainActivity.GENERATE) {
            generatePermission(requestCode)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alert = AlertDialog.Builder(activity).create()
        try {
            startActivity(Intent(activity, FormActivity::class.java))
            //requestPermission(MainActivity.DECODE, MainActivity.GENERATE)

            //startActivity(Intent(activity, Dis))
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        try {


              return
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }

        ActivityCompat.requestPermissions(
            requireContext() as Activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            23
        )
        //val editTextData: String = editText.getText().toString()

        //return
        insertPieciesTextEdit = view.findViewById(R.id.enterPocet)
        insertPieciesTextView = view.findViewById(R.id.enterPocet)
        diaplayPLUtext = view.findViewById(R.id.diplay_text)
        options = FileOperation()
        //builder = AlertDialog.Builder(activity).create()
        diaplayPLUtext.setTextColor(rgb(235, 94, 52))
        diaplayPLUtext.gravity = Gravity.CENTER
        diaplayPLUtext.setTypeface(null, Typeface.BOLD);
        diaplayPLUtext.text = activity?.intent?.getStringExtra("barcodeValue").toString()

       // alertCancel()
        try {
          // alertCancel()
            insertPieciesTextEdit.addTextChangedListener(textWatcher)

        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        try {
            insertPieciesTextEdit.requestFocus()
            insertPieciesTextEdit.setSelection(0)

            val imm: InputMethodManager =
                activity?.getSystemService(
                    INPUT_METHOD_SERVICE
                ) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        view.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                alert.setMessage("errr")
                alert.show()
                return@OnKeyListener true
            }
            false
        })
        //alert.setMessage("i am hre");
        //alert.show()
        //try {
//        val obj: HmsScan = activity?.intent?.getParcelableExtra(ScanUtil.RESULT)!!
        //var value = obj.getOriginalValue()
        //alert.setMessage("value is : $value")
        //alert.show()

        try {
            /*ScanUtil.startScan(
                activity,
                MainActivity.REQUEST_CODE_SCAN_ONE,
                HmsScanAnalyzerOptions.Creator().create()
            )*/
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        //insertPieciesTextEdit.requestFocus()
        //insertPieciesTextEdit.setSelection(0)
        //return
        try {
            //insertPieciesTextEdit.requestFocus()
            //insertPieciesTextEdit.setSelection(0)
        } catch (e: Exception) {
            alert.setMessage(e.message);
            alert.show()
        }

        /*insertPieciesTextEdit.setOnKeyListener { v, keyCode, event ->
            when (keyCode) {


                    //neutralButton.setTextColor(Color.parseColor("#FF1B5AAC"))
                    //neutralButton.setBackgroundColor(Color.parseColor("#FFD9E9FF"))
                    /* try {

                        var builder= AlertDialog.Builder(activity)
                        alert = AlertDialog.Builder(activity).create()
                        alert.setTitle("Ukončit")
                        alert.setMessage("opravdu ukončit ? ")
                        alert.show()


                        builder.setPositiveButton("ANO") { dialog, which ->
                            try {
                                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                            } catch (e: Exception) {

                                alert.show()
                            }
                            alert.dismiss()
                        }
                        builder.setNegativeButton("NE") { dialog, which ->
                            try {
                                //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                            } catch (e: Exception) {
                                alert.show()
                            }
                            alert.dismiss()
                        }

                        builder.setCancelable(false)

                        builder.show()
                        //val dialog = AlertDialog.Builder(this).setMessage("Hello world").show()
                        //var message = alert.findViewById<View>(android.R.id.message)
                        //var title = alert.findViewById<View>(android.R.id.title) as TextView
                        //message.textSize = 40F
                        //title.setBackgroundColor(rgb(54, 0, 179));
                        //title.setTextColor(Color.rgb(255, 255, 255))
                        //message.se
                        //title.gravity = Gravity.CENTER;
                        //title.textSize = 20F




                       // var builder = alert.create();
                        var fileNameGenerated = activity?.intent!!.putExtra("finalFileName", "import_" + System.currentTimeMillis() + "_ready.csv")
                        options.getCSV(activity, "/null", "out.csv")

                        Toast.makeText(requireContext(), "successfully renamed", Toast.LENGTH_LONG).show()
                        //options.readCsv("/out.csv", requireContext())
                        options.readCsv("out.csv", requireContext())tr
                    } catch (e: Exception) {
                        alert.setMessage(e.message)
                        alert.show()
                    }*/
                    true
                }
                else -> false
            }*/
        //}
        /*insertPieciesTextEdit.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                //alert.setMessage("i am here..")
                //alert.show()
                options = FileOperation()

                try {
                    alert.setMessage(diaplayPLUtext.text.toString() + "eeeee")
                    alert.show()
                    options.loadData(activity, insertPieciesTextView.text.toString() + "," + "\n", "/outputData.csv")
                    options.loadData(activity, diaplayPLUtext.text.toString() + "," + "\n", "/outputData.csv")



                     Toast.makeText(activity, "successfully loaded", Toast.LENGTH_LONG).show();
                    startActivity(Intent(activity, MainActivity::class.java))
                   // startActivity(Intent(activity, MainActivity::class.java))

                } catch (e: Exception) {
                    alert.setMessage(e.message)
                    alert.show()
                }

                    /*try {
                        options.loadData(activity, "\n\n" + ",", "/plu2.txt")
                        options.loadData(activity, insertPieciesTextView.text.toString() + ",", "/plu2.txt")
                       // options.loadData(activity, "\n", "/test.log.txt")
                        options.loadData(activity, "wwww", "/plu2.txt")
                        options.loadData(activity, "\n\n\n", "/plu2.txt")
                        //insertPieciesTextView.text = "";
                        startActivity(Intent(activity, MainActivity::class.java))
                        //requestPermission(MainActivity.CAMERA_REQ_CODE, MainActivity.DECODE)
                    } catch (e: Exception) {
                        alert.setMessage(e.message)
                        alert.show()
                    }*/

                    if(s.count() > 2) {
                       // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                        try {
                           //findNavController().navigate(R.id.action_FirstFragment_to_disPlayActivity)
                           // requestPermission(MainActivity.CAMERA_REQ_CODE, MainActivity.DECODE)
                            // (requestCode == MainActivity.CAMERA_REQ_CODE) {
                               /* ScanUtil.startScan(
                                    activity,
                                    MainActivity.REQUEST_CODE_SCAN_ONE,
                                    HmsScanAnalyzerOptions.Creator().create()
                                )*/
                           // val obj: HmsScan = activity?.intent?.getParcelableExtra(ScanUtil.RESULT)!!
                               try {

                                  // options.loadData(activity, insertPieciesTextView.text.toString() + "\n", "/null")
                               } catch (e: Exception) {
                                   alert.setMessage(e.message)
                                   alert.show()
                               }
                            startActivity(Intent(activity, MainActivity::class.java))

                            /*if (result != null && result.isNotEmpty()) {
                                if (!TextUtils.isEmpty(result[0].getOriginalValue())) {
                                    Toast.makeText(
                                        requireContext(),
                                        result[0].getOriginalValue(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }*/
                            return
                            //var value = obj.getOriginalValue()
                            //alert.setMessage("value is : $value")
                            //alert.show()
                        } catch (e : Exception) {
                            alert.setMessage(e.message)
                            alert.show()
                        }

                       // activity!!.startActivity(nextLoop)

                    }
                   // alert.setMessage("successfully inserted" + insertPieciesTextView.text.toString())
                    //alert.show()
                //}
            }
        })*/





        /*view.findViewById<Button>(R.id.button_firs
t).setOnClickLimstener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (start == 12) {
                Toast.makeText(requireContext(), "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }

            if(s!!.count() == 5) {
                alert.setMessage("eeee")
                alert.show()
            }
        }
    }

    private fun alertCancel() {

        var alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setMessage("eeee")
        alertDialog.show()
        loading = ProgressBar(activity)
        loading.max = 10;
        loading.progress;

        requireView().setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                    alertDialog.setMessage("ppp")
                alertDialog.show()
                return@OnKeyListener true
            }
            false
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //receive result after your activity finished scanning
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK || data == null) {
            return
        }
        if (requestCode == REQUEST_CODE_PHOTO) {
            // Obtain the image path.
            //val path = getImagePath(this@MainActivity, data)

            // Obtain the bitmap from the image path.
            val bitmap = ScanUtil.compressBitmap(requireContext(), null)
            // Call the decodeWithBitmap method to pass the bitmap.
            val result = ScanUtil.decodeWithBitmap(requireContext(), bitmap, HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScan.QRCODE_SCAN_TYPE, HmsScan.DATAMATRIX_SCAN_TYPE).setPhotoMode(true).create())
            // Obtain the scanning result.
            if (result != null && result.isNotEmpty()) {
                if (!TextUtils.isEmpty(result[0].getOriginalValue())) {
                    Toast.makeText(requireContext(), result[0].getOriginalValue(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}