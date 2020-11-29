package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.views

import android.Manifest
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.receivers.WifiReceiver


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val PERMISSION_CODE = 100
    private var wifiList: ListView? = null
    private var receiverWifi: WifiReceiver? = null
    private var centerText: TextView? = null

    private var PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    private lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wifiList = findViewById(R.id.wifiList)
        val buttonScan = findViewById<Button>(R.id.scanBtn)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        centerText = findViewById(R.id.center_text_placeholder)

        buttonScan.setOnClickListener {
            getWifiConnection()
        }
    }

    private fun askPermissions() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_CODE)
    }

    private fun getWifiConnection() {
        if (!wifiManager.isWifiEnabled) {
            wifiManager.isWifiEnabled = true
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            wifiManager.startScan()
            centerText?.visibility = View.INVISIBLE
            Toast.makeText(this, getString(R.string.scanning), Toast.LENGTH_LONG).show()
        } else {
            askPermissions()
        }
    }

    override fun onPostResume() {
        super.onPostResume()

        receiverWifi = WifiReceiver(this, wifiManager, wifiList!!)
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        registerReceiver(receiverWifi, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiverWifi)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_CODE && grantResults.isNotEmpty()) {
            val messageToUser =
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getWifiConnection()
                    this.getString(R.string.permission_granted)
                } else {
                    this.getString(R.string.permission_denied)
                }
            Toast.makeText(this, messageToUser, Toast.LENGTH_SHORT).show()
        }
    }
}