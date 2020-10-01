package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var chronometer: Chronometer
    private lateinit var toggleButton: Button
    private var isRunning: Boolean = false
    private var timeWhenStopped: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById(R.id.chronometer)
        toggleButton = findViewById(R.id.toggleButton)
    }

    override fun onBackPressed() {
        Toast.makeText(
            this@MainActivity,
            "Tolong tekan tombol exit untuk keluar",
            Toast.LENGTH_LONG
        ).show()
    }

    fun toggleChronometer(view: View) {
        if (isRunning) {
            timeWhenStopped = SystemClock.elapsedRealtime() - chronometer.base
            chronometer.stop()
            toggleButton.text = "Mulai"
            isRunning = false
        } else {
            chronometer.base = (SystemClock.elapsedRealtime() - timeWhenStopped)
            chronometer.start()
            toggleButton.text = "Pause"
            isRunning = true
        }
    }

    fun resetChronometer(view: View) {
        timeWhenStopped = 0
        chronometer.base = (SystemClock.elapsedRealtime())
        chronometer.stop()
        toggleButton.text = "Mulai"
        isRunning = false
    }

    fun exitChronometer(view: View) {
        super.onBackPressed()
    }
}
