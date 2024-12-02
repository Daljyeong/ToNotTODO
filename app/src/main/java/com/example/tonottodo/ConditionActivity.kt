package com.example.tonottodo

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConditionActivity : AppCompatActivity() {
    private var selectedCondition: ImageView? = null
    private var selectedConditionScore: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_condition)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
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

    }
}