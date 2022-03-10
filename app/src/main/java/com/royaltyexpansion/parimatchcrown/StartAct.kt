package com.royaltyexpansion.parimatchcrown

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StartAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun goStart(view: View) {
        Intent(applicationContext, GameplayPC::class.java).also { startActivity(it) }
        finish()
    }
}