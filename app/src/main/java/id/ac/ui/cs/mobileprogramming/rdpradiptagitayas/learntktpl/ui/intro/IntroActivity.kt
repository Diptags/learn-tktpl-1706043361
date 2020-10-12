package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.intro

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.home.HomeActivity
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.onboarding.OnboardingActivity

class IntroActivity : AppCompatActivity() {

    // Timer for splash screen
    private var SPLASH_TIMER: Long = 3000

    // Variables
    private var backgroundImage: ImageView? = null
    private var createdBy: TextView? = null

    private var onBoardingScreen: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        setContentView(R.layout.intro_activity)

        // Hooks (Designs)
        backgroundImage = findViewById(R.id.background_image)
        createdBy = findViewById(R.id.created_by_line)

        // Wait for few seconds before redirect to onboarding activity
        Handler(Looper.getMainLooper()).postDelayed({

            onBoardingScreen = this.getSharedPreferences("onBoardingScreen", MODE_PRIVATE)
            val isFirstTime: Boolean = onBoardingScreen!!.getBoolean("firstTime", true)
            var intent: Intent? = null

            intent = if (isFirstTime) {
                val editor: SharedPreferences.Editor = onBoardingScreen!!.edit()
                editor.putBoolean("firstTime", false)
                editor.apply()

                Intent(this, OnboardingActivity::class.java)
            } else {
                Intent(this, HomeActivity::class.java)
            }
            startActivity(intent)
            finish()
        }, SPLASH_TIMER)
    }
}
