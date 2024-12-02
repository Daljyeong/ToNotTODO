package com.example.tonottodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tonottodo.databinding.FragmentSeesawRecordBinding

class SeesawRecordFragment : Fragment() {
    private lateinit var binding: FragmentSeesawRecordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSeesawRecordBinding.inflate(layoutInflater)

        binding.clSeesaw1.setOnClickListener {
            findNavController().navigate(R.id.action_seesaw_record_to_goal_detail)
        }

        return binding.root
    }
}
