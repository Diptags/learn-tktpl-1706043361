package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.views

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R

class MainActivity : AppCompatActivity() {

    // Variables
    private var firstNumberForm: TextInputLayout? = null
    private var secondNumberForm: TextInputLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sumButton: Button = findViewById(R.id.sumButton)

        sumButton.setOnClickListener {
            sendNumbers()
        }
    }

    // Implementasi untuk mengolah isi form dan mengirimkan ke berkas C++
    private fun sendNumbers() {

        firstNumberForm = findViewById(R.id.firstNumBox)
        secondNumberForm = findViewById(R.id.secondNumBox)

        val firstNum = if (firstNumberForm?.editText!!.text.toString()
                .isEmpty()
        ) 0 else firstNumberForm?.editText!!.text.toString().toInt()

        val secondNum = if (secondNumberForm?.editText!!.text.toString()
                .isEmpty()
        ) 0 else secondNumberForm?.editText!!.text.toString().toInt()

        // Memanggil fungsi sumNumbers yang berada di berkas C++
        findViewById<TextView>(R.id.calculation_result).text =
            sumNumbers(firstNum, secondNum).toString()
    }

    // Implementasi fungsi sumNumbers berada pada berkas C++
    private external fun sumNumbers(firstNum: Int, secondNum: Int): Int

    // Melakukan load berkas C++ dalam bentuk native library
    companion object {
        init {
            System.loadLibrary("lab6-1706043361")
        }
    }
}