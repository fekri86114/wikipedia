package com.app.wikipedia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.wikipedia.R
import com.app.wikipedia.databinding.FragmentPhotographerBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class PhotographerFragment : Fragment() {
    lateinit var binding: FragmentPhotographerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPhotographerBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = R.drawable.img_photographer
        Glide
            .with( requireContext() )
            .load( imageUrl )
            .transform(CenterInside(), RoundedCorners(16))
            .into( binding.imgBePhotographer )

    }

}