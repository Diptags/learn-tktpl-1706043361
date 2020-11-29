package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.receivers

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.services.APIServiceImpl


class WifiReceiver(
    private var activity: Activity,
    private var wifiManager: WifiManager,
    private var wifiDeviceList: ListView
) :
    BroadcastReceiver() {

    private var sb: StringBuilder? = null

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION == action) {

            sb = StringBuilder()
            val wifiList = wifiManager.scanResults
            val wifiListToSend: ArrayList<HashMap<String, String>> = ArrayList()
            val wifiListToShow: ArrayList<String> = ArrayList()

            if (wifiList.isEmpty()) {

                val centerText: TextView = activity.findViewById(R.id.center_text_placeholder)
                centerText.text = context.getString(R.string.no_wifi_found)

            } else {
                for (scanResult in wifiList) {

                    // Add to list of hashmap (to be sent to API)
                    val wifi: HashMap<String, String> = HashMap()
                    wifi["ssid"] = scanResult.SSID
                    wifi["frequency"] = scanResult.frequency.toString() + " Hz"
                    wifi["capabilities"] = scanResult.capabilities.toString()
                    wifiListToSend.add(wifi)

                    // Add to list of hashmap (to be displayed in application)
                    sb!!.append("\n").append(scanResult.SSID).append(" - ")
                        .append(scanResult.frequency.toString() + " Hz")
                    wifiListToShow.add(wifi["ssid"] + " - " + wifi["frequency"])
                }

                val arrayAdapter: ArrayAdapter<*> = ArrayAdapter(
                    context,
                    android.R.layout.simple_list_item_1,
                    wifiListToShow.toArray()
                )

                wifiDeviceList.adapter = arrayAdapter
                sendWifiData(context, wifiListToSend)
            }
        }
    }

    private fun sendWifiData(context: Context, wifiList: ArrayList<HashMap<String, String>>) {
        val apiService = APIServiceImpl()
        apiService.sendData(wifiList) {
            if (it != null) {
                Toast.makeText(context, R.string.send_success, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, R.string.send_fail, Toast.LENGTH_LONG).show()
            }
        }
    }
}
