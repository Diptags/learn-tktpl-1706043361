package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R

class FirstFragment : Fragment() {

    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.home_fragment_first, container, false)
        val changeFragmentButton: Button = view.findViewById(R.id.changeFragmentButton)

        changeFragmentButton.setOnClickListener {
            val secondFragment = SecondFragment()
            val transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer, secondFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        return view
    }


}

