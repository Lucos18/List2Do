package com.example.list2do.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.list2do.R
import com.example.list2do.databinding.FragmentMoreInfoTaskBinding


class FragmentMoreInfoTask : Fragment() {
    private var _binding: FragmentMoreInfoTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoreInfoTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
}