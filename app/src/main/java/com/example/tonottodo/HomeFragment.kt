package com.example.tonottodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tonottodo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var isRecentOrder = true

    private val recentOrderData = listOf(
        Pair("킹왕짱 대학생 되기", R.drawable.img_seesaw_21),
        Pair("건강한 식습관 형성하기", R.drawable.img_seesaw_33),
        Pair("갓생 개발자 되기", R.drawable.img_seesaw_30),
        Pair("게임 중독 벗어나기", R.drawable.img_seesaw_13),
        Pair("킹왕짱 헬스인 되기", R.drawable.img_seesaw_03),
        Pair("꼼꼼 인간 되기", R.drawable.img_seesaw_22)
    )

    private val balanceOrderData = listOf(
        Pair("건강한 식습관 형성하기", R.drawable.img_seesaw_33),
        Pair("꼼꼼 인간 되기", R.drawable.img_seesaw_22),
        Pair("킹왕짱 대학생 되기", R.drawable.img_seesaw_21),
        Pair("게임 중독 벗어나기", R.drawable.img_seesaw_13),
        Pair("갓생 개발자 되기", R.drawable.img_seesaw_30),
        Pair("킹왕짱 헬스인 되기", R.drawable.img_seesaw_03)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setupDropdownMenu()

        return binding.root
    }

    private fun setupDropdownMenu() {
        binding.clHomeSubTopBar.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), binding.clHomeSubTopBar)
            popupMenu.menuInflater.inflate(R.menu.home_dropdown_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_recent -> {
                        binding.tvHomeDown.text = "최근 생성순"
                        if (!isRecentOrder) {
                            updateConstraintLayouts(recentOrderData)
                        }
                    }
                    R.id.menu_balance -> {
                        binding.tvHomeDown.text = "밸런스순"
                        if (isRecentOrder) {
                            updateConstraintLayouts(balanceOrderData)
                        }
                    }
                }
                true
            }

            popupMenu.show()
        }
    }

    private fun updateConstraintLayouts(data: List<Pair<String, Int>>) {
        val layouts = listOf(
            binding.clHomeSeesaw1 to Pair(R.id.tv_home_seesaw1, R.id.iv_home_seesaw1),
            binding.clHomeSeesaw2 to Pair(R.id.tv_home_seesaw2, R.id.iv_home_seesaw2),
            binding.clHomeSeesaw3 to Pair(R.id.tv_home_seesaw3, R.id.iv_home_seesaw3),
            binding.clHomeSeesaw4 to Pair(R.id.tv_home_seesaw4, R.id.iv_home_seesaw4),
            binding.clHomeSeesaw5 to Pair(R.id.tv_home_seesaw5, R.id.iv_home_seesaw5),
            binding.clHomeSeesaw6 to Pair(R.id.tv_home_seesaw6, R.id.iv_home_seesaw6)
        )

        layouts.forEachIndexed { index, (layout, ids) ->
            val textView = layout.findViewById<TextView>(ids.first)
            val imageView = layout.findViewById<ImageView>(ids.second)

            textView?.text = data[index].first
            imageView?.setImageResource(data[index].second)
        }

        isRecentOrder = !isRecentOrder
    }
}