package com.example.tonottodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tonottodo.databinding.FragmentAddNotTodoBinding

class AddNotTodoFragment : Fragment() {

    private var _binding: FragmentAddNotTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNotTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etFirstNotTodo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) initNotTodoEditTextSelection(binding.clFirstNotTodo)
        }

        binding.etSecondNotTodo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) initNotTodoEditTextSelection(binding.clSecondNotTodo)
        }

        binding.etThirdNotTodo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) initNotTodoEditTextSelection(binding.clThirdNotTodo)
        }

        binding.cdBtnApply.setOnClickListener {
            findNavController().navigate(R.id.action_add_not_todo_to_home)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initNotTodoEditTextSelection(view: View) {
        listOf(binding.clFirstNotTodo, binding.clSecondNotTodo, binding.clThirdNotTodo).forEach { it.isSelected = false }
        view.isSelected = true
    }
}