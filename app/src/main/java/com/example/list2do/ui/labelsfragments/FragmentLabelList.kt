package com.example.list2do.ui.labelsfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.list2do.ToDoApplication
import com.example.list2do.databinding.FragmentLabelListBinding
import com.example.list2do.viewmodels.LabelViewModel
import com.example.list2do.viewmodels.LabelViewModelFactory

class FragmentLabel : Fragment() {

    private var _binding: FragmentLabelListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LabelViewModel by activityViewModels {
        LabelViewModelFactory(
            (activity?.application as ToDoApplication).database.labelDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLabelListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = LabelListAdapter
    }

}