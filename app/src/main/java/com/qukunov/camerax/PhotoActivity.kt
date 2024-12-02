package com.qukunov.camerax

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        val photoView: ImageView = findViewById(R.id.photoView)
        val photoPath = intent.getStringExtra("photoPath")

        photoPath?.let { path ->
            val file = File(path)
            if (file.exists() && file.length() > 0) {
                // Загружаем изображение в ImageView
                val bitmap = BitmapFactory.decodeFile(path)
                if (bitmap != null) {
                    photoView.setImageBitmap(bitmap)
                } else {
                    Toast.makeText(this, "Не удалось загрузить изображение", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Файл не найден или поврежден", Toast.LENGTH_SHORT).show()
            }
        } ?: run {
            Toast.makeText(this, "Путь к изображению отсутствует", Toast.LENGTH_SHORT).show()
        }
    }
}