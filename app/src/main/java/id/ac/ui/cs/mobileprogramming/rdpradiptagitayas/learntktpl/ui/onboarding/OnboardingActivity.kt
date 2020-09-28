package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.onboarding

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

// Class ini akan digunakan untuk membuat antarmuka onboarding
class OnboardingActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var dotsLayout: LinearLayout? = null
    var letsGetStarted: Button? = null
    var animation: Animation? = null
    var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun next(view: View) {}

    fun skip(view: View) {}

    fun addDots(position: Int) {}

}