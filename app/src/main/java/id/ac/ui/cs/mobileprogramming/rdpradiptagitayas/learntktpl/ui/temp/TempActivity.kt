package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.temp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ApplicationViewModelFactory
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.R
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.User
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user.UserHelper
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user.UserServiceImpl
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.Status
import kotlinx.android.synthetic.main.temp_activity.*

class TempActivity : AppCompatActivity() {

    private lateinit var mainViewModel: TempViewModel
    private lateinit var adapter: TempAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temp_activity)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TempAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    // Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ApplicationViewModelFactory(UserHelper(UserServiceImpl()))
        ).get(TempViewModel::class.java)
    }
}
