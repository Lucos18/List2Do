package com.example.list2do.ui.toDoFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.list2do.databinding.FragmentToDoListBinding


class FragmentToDoList : Fragment() {
    private var _binding: FragmentToDoListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentToDoListBinding.inflate(inflater, container, false)
        return binding.root
    }

}