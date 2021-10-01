package com.example.firebaseanalyticexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseanalyticexample.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = "123"
        val text = "Hehehe"
        firebaseAnalytics = Firebase.analytics
        FirebaseApp.initializeApp(this)



        binding.btnInput.setOnClickListener {
            Toast.makeText(this, "Coba Cek Dashboard Anda", Toast.LENGTH_SHORT).show()
                firebaseAnalytics.logEvent("data"){
                    param("id", id)
                    param("name", text)
                }
            }
        }

    override fun onResume() {
        super.onResume()
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, "Layar Utama")
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        }
    }

    }
