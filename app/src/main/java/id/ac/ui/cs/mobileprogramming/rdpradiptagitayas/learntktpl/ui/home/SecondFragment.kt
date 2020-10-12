package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R


class SecondFragment : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.home_fragment_second, container, false)
    }
}