package com.example.tonottodo


import android.app.AlertDialog
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tonottodo.databinding.ActivityConditionBinding
import com.example.tonottodo.databinding.DialogRecommendBinding

class ConditionActivity : AppCompatActivity() {
    private var selectedCondition: ImageView? = null
    private var selectedConditionScore: Int? = null

    private lateinit var binding: ActivityConditionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //컨디션=5점, 기분=4점만 클릭해!!
        binding.ivConditionFace5.setOnClickListener {
            binding.ivNumGray5.imageTintList = ColorStateList.valueOf(Color.parseColor("#EF9595"))
        }
        binding.ivMoodFace4.setOnClickListener {
            binding.ivMoodNum4.imageTintList = ColorStateList.valueOf(Color.parseColor("#FFB187"))
        }

        binding.btnConditionNext.setOnClickListener {
            showRecommendDialog()
        }

        binding.tvConditionSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun showRecommendDialog() {
        val dialogBinding = DialogRecommendBinding.inflate(LayoutInflater.from(this))
        val dialog = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .create()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.show()
        dialog.window?.setLayout(
            resources.displayMetrics.widthPixels - 72.dpToPx(),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialogBinding.tvRecommendBtn.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun Int.dpToPx(): Int {
        val density = resources.displayMetrics.density
        return (this * density).toInt()
    }
}
