package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        ButterKnife.bind(this)
    }
}