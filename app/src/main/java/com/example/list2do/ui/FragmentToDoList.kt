package com.example.list2do.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.list2do.R
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationView.setOnItemReselectedListener {
            when(it.itemId){
                R.id.labelListItem->findNavController().navigate(R.id.action_fragmentToDoList_task_to_fragmentToDoDetail)
            }
            true
        }
    }
}