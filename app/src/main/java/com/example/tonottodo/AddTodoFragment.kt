package com.example.tonottodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tonottodo.databinding.FragmentAddTodoBinding

class AddTodoFragment : Fragment() {

    private var _binding: FragmentAddTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etFirstTodo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) initTodoEditTextSelection(binding.clFirstTodo)
        }

        binding.etSecondTodo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) initTodoEditTextSelection(binding.clSecondTodo)
        }

        binding.etThirdTodo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) initTodoEditTextSelection(binding.clThirdTodo)
        }

        binding.cdBtnNext.setOnClickListener {
            findNavController().navigate(R.id.action_add_todo_to_add_not_todo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initTodoEditTextSelection(view: View) {
        listOf(binding.clFirstTodo, binding.clSecondTodo, binding.clThirdTodo).forEach { it.isSelected = false }
        view.isSelected = true
    }
}