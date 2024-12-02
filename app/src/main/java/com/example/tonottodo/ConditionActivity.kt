package com.example.tonottodo


import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.ImageView
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tonottodo.databinding.ActivityConditionBinding
import com.example.tonottodo.databinding.DialogRecommendBinding

class ConditionActivity : AppCompatActivity() {
    private var selectedCondition: ImageView? = null
    private var selectedConditionScore: Int? = null

    private lateinit var binding: ActivityConditionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ivConditionFace5 = findViewById<ImageView>(R.id.iv_condition_face_5)
        val ivNumGray5 = findViewById<ImageView>(R.id.iv_num_gray_5)

        ivConditionFace5.setOnClickListener {
            // Tint Color로 색상 변경
            val tintColor = ColorStateList.valueOf(android.graphics.Color.parseColor("#EF9595"))
            ivNumGray5.imageTintList = tintColor
        }

        binding.btnConditionNext.setOnClickListener {
            showRecommendDialog()
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

        dialogBinding.tvRecommendMessage.text = "오늘 당신은 우울한 날이네요!\n우울한 날에는\n산책을 해보는 것은 어떨까요?"

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
