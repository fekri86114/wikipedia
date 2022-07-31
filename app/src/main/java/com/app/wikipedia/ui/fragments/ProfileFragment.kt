package com.app.wikipedia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.app.wikipedia.R
import com.app.wikipedia.databinding.FragmentProfileBinding
import com.google.android.material.card.MaterialCardView

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardView= view.findViewById<MaterialCardView>(R.id.cardview_main)
        cardView.isChecked = true

        cardView.setOnClickListener {

            cardView.isChecked = !cardView.isChecked

        }


    }

}