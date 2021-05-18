package com.example.pokemongo.ui.captured

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemongo.R

class CapturedFragment : Fragment() {

    companion object {
        fun newInstance() = CapturedFragment()
    }

    private lateinit var viewModel: CapturedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.captured_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CapturedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}