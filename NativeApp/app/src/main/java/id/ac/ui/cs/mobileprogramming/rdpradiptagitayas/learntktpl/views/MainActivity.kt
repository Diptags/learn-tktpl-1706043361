package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.views

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterButton: Button = findViewById(R.id.counter_button)

        counterButton.setOnClickListener {
            addCounter()
        }
    }

    private fun addCounter() {
        val counterResult: TextView = findViewById(R.id.counter_result)
        counter += 1
        counterResult.text = (counter).toString()
    }
}