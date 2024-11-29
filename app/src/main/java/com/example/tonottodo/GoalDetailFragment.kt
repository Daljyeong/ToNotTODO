package com.example.tonottodo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tonottodo.databinding.FragmentGoalDetailBinding

class GoalDetailFragment : Fragment() {
    private lateinit var binding: FragmentGoalDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGoalDetailBinding.inflate(layoutInflater)

        goalOnClickListeners()

        return binding.root
    }

    private fun goalOnClickListeners() {
        val greenBG = ContextCompat.getDrawable(requireContext(), R.drawable.bg_green_8)
        val redBG = ContextCompat.getDrawable(requireContext(), R.drawable.bg_red_8)
        val grayBG = ContextCompat.getDrawable(requireContext(), R.drawable.bg_gray_8)
        val greenCheck = ContextCompat.getColor(requireContext(), R.color.main_green)
        val redCheck = ContextCompat.getColor(requireContext(), R.color.red)
        val grayCheck = ContextCompat.getColor(requireContext(), R.color.gray_500)

        fun setClickListener(
            container: ConstraintLayout,
            icon: ImageView,
            activeBackground: Drawable?,
            activeColor: Int,
        ) {
            container.tag = false
            container.setOnClickListener {
                val isActive = container.tag as Boolean
                if (isActive) {
                    container.background = grayBG
                    icon.setColorFilter(grayCheck)
                } else {
                    container.background = activeBackground
                    icon.setColorFilter(activeColor)
                }
                container.tag = !isActive
            }
        }

        setClickListener(binding.clTodo1, binding.ivTodo1, greenBG, greenCheck)
        setClickListener(binding.clTodo2, binding.ivTodo2, greenBG, greenCheck)
        setClickListener(binding.clTodo3, binding.ivTodo3, greenBG, greenCheck)

        setClickListener(binding.clNotTodo1, binding.ivNotTodo1, redBG, redCheck)
        setClickListener(binding.clNotTodo2, binding.ivNotTodo2, redBG, redCheck)
        setClickListener(binding.clNotTodo3, binding.ivNotTodo3, redBG, redCheck)
    }
}
