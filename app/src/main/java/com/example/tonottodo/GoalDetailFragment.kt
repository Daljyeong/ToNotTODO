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

        val todos = listOf(binding.clTodo1, binding.clTodo2, binding.clTodo3)
        val notTodos = listOf(binding.clNotTodo1, binding.clNotTodo2, binding.clNotTodo3)
        val todoIcons = listOf(binding.ivTodo1, binding.ivTodo2, binding.ivTodo3)
        val notTodoIcons = listOf(binding.ivNotTodo1, binding.ivNotTodo2, binding.ivNotTodo3)

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
                updateSeesawImage()
            }
        }

        todos.zip(todoIcons).forEach { (container, icon) ->
            setClickListener(container, icon, greenBG, greenCheck)
        }

        notTodos.zip(notTodoIcons).forEach { (container, icon) ->
            setClickListener(container, icon, redBG, redCheck)
        }

    }

    private fun updateSeesawImage() {
        val todosChecked = countChecked(listOf(binding.clTodo1, binding.clTodo2, binding.clTodo3))
        val notTodosChecked =
            countChecked(listOf(binding.clNotTodo1, binding.clNotTodo2, binding.clNotTodo3))

        // 이미지 파일 이름 형식: img_seesaw_<todosChecked><notTodosChecked>
        val imageName = "img_seesaw_${todosChecked}$notTodosChecked"

        val drawableId =
            requireContext().resources.getIdentifier(
                imageName,
                "drawable",
                requireContext().packageName,
            )

        if (drawableId != 0) {
            binding.ivGoalDetailSeesaw.setImageResource(drawableId)
        }
    }

    private fun countChecked(containers: List<ConstraintLayout>): Int = containers.count { it.tag as? Boolean == true }
}
