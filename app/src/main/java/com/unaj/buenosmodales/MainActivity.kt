package com.unaj.buenosmodales

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val handler = Handler(Looper.getMainLooper())
        val tiempoDesaparicion = 2000L // 2 segundos

        val btnGracias = findViewById<Button>(R.id.btnGracias)
        val btnEstornudar = findViewById<Button>(R.id.btnEstornudar)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)

        btnGracias.setOnClickListener {
            tvMensaje.text = "De nada"
            tvMensaje.visibility = View.VISIBLE
            handler.removeCallbacksAndMessages(null)
            handler.postDelayed({ tvMensaje.visibility = View.GONE }, tiempoDesaparicion)
        }

        btnEstornudar.setOnClickListener {
            tvMensaje.text = "¡Salud!"
            tvMensaje.visibility = View.VISIBLE
            handler.removeCallbacksAndMessages(null)
            handler.postDelayed({ tvMensaje.visibility = View.GONE }, tiempoDesaparicion)
        }
    }
}