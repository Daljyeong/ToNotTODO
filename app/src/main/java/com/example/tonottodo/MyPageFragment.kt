package com.example.tonottodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tonottodo.databinding.FragmentMyPageBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter

class MyPageFragment : Fragment() {
    lateinit var binding: FragmentMyPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyPageBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBarChart()

        binding.clMyPageSeesaw1.setOnClickListener {
            findNavController().navigate(R.id.action_my_page_to_seesaw_record)
        }
    }


    // barChart 초기화
    private fun initBarChart() {
        val barChart = binding.barChartMypage

        // barChart에 표시할 데이터 (우선 더미값으로 설정해둠. 추후 데이터 불러와서 y만 수정 필요)
        val entries = listOf(
            BarEntry(0.5f, 2f),  // Sunday
            BarEntry(1.5f, 4f),  // Monday
            BarEntry(2.5f, 6f),  // Tuesday
            BarEntry(3.5f, 3f),  // Wednesday
            BarEntry(4.5f, 5f),  // Thursday
            BarEntry(5.5f, 5f),  // Friday
            BarEntry(6.5f, 4f)   // Saturday
        )

        // barChart의 데이터
        val barDataSet = BarDataSet(entries, "Weekly Data").apply {
            color = ContextCompat.getColor(requireContext(), R.color.main_green) // 막대 색상
            setDrawValues(false) // 데이터 값 표시 비활성화
        }

        val barData = BarData(barDataSet).apply {
            barWidth = 0.8f // 막대 너비
        }

        barChart.apply {
            data = barData
            description.isEnabled = false
            legend.isEnabled = false
            setDrawGridBackground(false) // 차트 배경 그리드 채우기 비활성화

            // x축 설정
            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                granularity = 1f
                axisMinimum = 0f  // x축 최소값 설정
                axisMaximum = 7f  // x축 최대값 설정
                setDrawGridLines(true) // x축 그리드 라인 활성화
                enableGridDashedLine(15f, 10f, 0f) // 점선으로 설정
                setCenterAxisLabels(true)
                valueFormatter = object : ValueFormatter() {
                    private val days = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
                    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                        return days.getOrNull(value.toInt()) ?: ""
                    }
                }

                // 라벨 폰트 설정
                typeface = resources.getFont(R.font.jua_400)
                textSize = 12f
            }

            // y축 값 표시 비활성화
            axisLeft.isEnabled = false
            axisRight.isEnabled = false

            notifyDataSetChanged()
            invalidate()
        }
    }

}