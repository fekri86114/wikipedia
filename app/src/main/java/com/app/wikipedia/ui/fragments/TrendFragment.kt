package com.app.wikipedia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.wikipedia.databinding.FragmentTrendBinding

class TrendFragment : Fragment() {
    lateinit var binding: FragmentTrendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrendBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}