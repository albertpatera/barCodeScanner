package com.example.scankitdemo.core

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.scankitdemo.R
import com.grapecity.documents.excel.Workbook
import java.io.File
//import jcifs.smb.NtlmPasswordAuthentication;
//import jcifs.smb.SmbFile;



/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private lateinit var wifiSettings : WifiOperation
    private lateinit var alert : AlertDialog
    private lateinit var workbook: Workbook
    private lateinit var documentPath : String
    private lateinit var checkFile : File

    private lateinit var options : FileOperation
    //Create XSSF Workbook entity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    /*override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            23

            -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                    alert.setMessage("eeee")
                    alert.show()
                } else {
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                    alert.setMessage("lll");
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }*/
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //var directory = activity?.getExternalFilesDir(null).toString()
        alert = AlertDialog.Builder(activity).create()
        options = FileOperation();


        //Create XSSF Workbook entity

        /*try {
            documentPath = activity?.intent?.putExtra("fileExcel",
                "/Import.xlsx"
            ).toString()

            var generateFile = File(directory, documentPath)
            workbook = Workbook()

            checkFile = File(directory, documentPath)
            if(!checkFile.exists()) {
                checkFile.createNewFile()
                workbook.save(activity?.getExternalFilesDir(null).toString() +
                        activity?.intent?.getStringExtra("fileExcel")
                )
            } else {
                workbook.save(activity?.getExternalFilesDir(null).toString() +
                    activity?.intent?.getStringExtra("fileExcel")
                )

            }


        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }*/


        /*try {


            var fileName = activity?.intent?.getStringExtra("finalFileName")
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            //val smbUri = Uri.parse("smb://37.205.10.181")
            val smbUri = Uri.parse("smb://192.168.0.178")
            //val smbUri = Uri.parse("smb://192.168.1.101")
            intent.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
            intent.putExtra("command_type", "upload")
            //intent.putExtra("smb_password", "patera")
            intent.putExtra("smb_username", "guest");
// Remote files to download.
            alert.setMessage(activity?.getExternalFilesDir(null).toString())
            alert.show()
            intent.putExtra("local_file1", activity?.getExternalFilesDir(null).toString() + "/SimpleBudget.xlsx");
            //intent.putExtra("local_file1", activity?.getExternalFilesDir(null).toString() + "/"+
                    //activity?.intent?.getStringExtra("excelFile"));
              //           "null");

           // alert.setMessage(.toString() + "lkkkjkkk")
            //alert.show()
            //intent.putExtra("local_file2", "/sdcard/subfolder2/file2.zip");
// Optional initial remote folder (it must exist before upload)
            intent.putExtra("remote_folder", "/Public");
            //intent.putExtra("remote_folder", "/Public/Android");
//intent.putExtra("smb_password", "yourpassword");
//intent.putExtra("smb_domain", "YOURDOMAIN");
            var UPLOAD_FILES_REQUEST = 1;
            startActivityForResult(intent, UPLOAD_FILES_REQUEST);
            val status = intent.getStringExtra("TRANSFERSTATUS")
            val files = intent.getStringExtra("TRANSFERAMOUNT")
            val size = intent.getStringExtra("TRANSFERSIZE")
            val time = intent.getStringExtra("TRANSFERTIME")

//intent.putExtra("smb_domain", "YOURDOMAIN");
            //intent.putExtra("local_file1", "/sdcard/subfolder1/file1.zip");
           // intent.putExtra("local_file2", activity?.getExternalFilesDir(null).toString() + "/out.csv");
// Optional initial remote folder (it must exist before upload)
;


//intent.putExtra("smb_encoding", "UTF-8");


            //intent.putExtra("local_file1", "/sdcard/subfolder1/file1.zip");
            //intent.putExtra("local_file2", "/sdcard/subfolder2/file2.zip");
// Optional initial remote folder (it must exist before upload)
            //intent.putExtra("remote_folder", "/demouser");

            //intent.putExtra("local_file1", activity?.getExternalFilesDir(null).toString() + "/out.csv")
// Optional Initial remote folder (it must exist before upload)
// Optional Initial remote folder (it must exist before upload)
            //intent.putExtra("remote_folder", "/demouser")


        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }*/
        try {
            //alert.setMessage("data" + Environment.getExternalStoragePublicDirectory(null).toString())
            //alert.show()
            //return
            options.getCSV(activity, "/null", "import.csv")
            options.getCSV(activity, "/import.csv", "output.xlsx")

            //try

            //alert.setMessage(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString())
            //alert.show()
           //File(activity?.getExternalFilesDir(null), "/test.txt").copyTo(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator, "/null.txt" /*"", "/importOut.txt"*/))
           //File(activity?.getExternalFilesDir(null), "/output.xlsx").copyTo(File(activity?.getExternalFilesDir(null).toString() + File.separator, "/output.xlsx" /*"", "/importOut.txt"*/))
            //File(activity?.getExternalFilesDir(null), "/test.txt").copyTo(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator, "/null.txt" /*"", "/importOut.txt"*/))
            Toast.makeText(requireContext(), "file copied...", Toast.LENGTH_SHORT).show()
           // return
        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }
        try {
           // var UPLOAD_FILES_REQUEST = 0;
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            //val smbUri = Uri.parse("smb://192.168.0.178")
            //val smbUri = Uri.parse("smb://37.205.10.181")
            val smbUri = Uri.parse("smb://192.168.1.122")
            intent.setDataAndType(smbUri, "vnd.android.cursor.dir/lysesoft.andsmb.uri")
            intent.putExtra("command_type", "upload")

            intent.putExtra("smb_username", "guest");
//intent.putExtra("smb_password", "yourpassword");
//intent.putExtra("smb_domain", "YOURDOMAIN");

            //return
           // intent.putExtra("local_file1", "/sdcard/subfolder1/file1.zip");
            intent.putExtra("progress_title", "Nahrávání souboru...");

            //alert.setMessage(Environment.getExternalStorageState() + "     _______storage");
            //alert.show()
            //intent.putExtra("local_file1",  activity?.externalCacheDir.toString() + "/importOut.txt");
           // intent.putExtra("local_file1",  activity?.getExternalFilesDir(null).toString() +"/Documents" + "/SimpleBudget.xlsx");
            //intent.putExtra("local_file1",  Environment.getExternalStorageDirectory().toString() +"/Documents" + "/SimpleBudget.xlsx");
            //intent.putExtra("local_file1",  Environment.getExternalStorageDirectory().toString() + "/Pictures/test.txt");

// Optional initial remote folder (it must exist before upload)
            //intent.putExtra("remote_folder", "/Public/Přenos dat do money");

          //  startActivityForResult(intent, UPLOAD_FILES_REQUEST);

            //val status = intent.getStringExtra("TRANSFERSTATUS")
            //val files = intent.getStringExtra("TRANSFERAMOUNT")
            //val size = intent.getStringExtra("TRANSFERSIZE")
            //val time = intent.getStringExtra("TRANSFERTIME")

        } catch (e : Exception) {
            alert.setMessage(e.message)
            alert.show()
        }


//Create an excel sheet

        wifiSettings = WifiOperation()
        alert = AlertDialog.Builder(activity).create()
        try {
            wifiSettings.isOnline(requireContext());
            //wifiSettings.initWifiSettings(requireContext())
        } catch (e: Exception) {
            alert.setMessage(e.message)
            alert.show()
        }

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }
}