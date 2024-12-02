package com.example.tonottodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tonottodo.databinding.FragmentSeesawRecordBinding

class SeesawRecordFragment : Fragment() {
    private lateinit var binding: FragmentSeesawRecordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSeesawRecordBinding.inflate(layoutInflater)

        return binding.root
    }
}
