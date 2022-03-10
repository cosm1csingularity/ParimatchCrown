package com.royaltyexpansion.parimatchcrown

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_gameplay_pc.*

class GameplayPC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay_pc)

        var treasures = arrayListOf(treasure1, treasure2, treasure3, treasure4, treasure5, treasure6, treasure7, treasure8)
        var visible = arrayListOf(treasure1)
        visible.remove(treasure1)

        for (treasure in treasures) {
            if (treasure.tag == "unicorn") {
                treasure.setImageResource(R.drawable.unicorn)
            }
            if (treasure.tag == "rose") {
                treasure.setImageResource(R.drawable.rose)
            }
            if (treasure.tag == "crown") {
                treasure.setImageResource(R.drawable.crown)
            }
            if (treasure.tag == "mirror") {
                treasure.setImageResource(R.drawable.mirror)
                treasure.isClickable = false
            }
            Handler().postDelayed({
                for (treasure in treasures) {
                    treasure.setImageResource(R.drawable.treasure)
                    treasure.isClickable = true
                }
            }, 1500)
        }

        for (treasure in treasures) {
            treasure.setOnClickListener {
                rulesTxt.isVisible = false
                val handler = Handler()
                if (treasure.tag == "unicorn") {
                    treasure.setImageResource(R.drawable.unicorn)
                }
                if (treasure.tag == "rose") {
                    treasure.setImageResource(R.drawable.rose)
                }
                if (treasure.tag == "crown") {
                    treasure.setImageResource(R.drawable.crown)
                }
                if (treasure.tag == "mirror") {
                    treasure.setImageResource(R.drawable.mirror)
                }
                if (visible.isNullOrEmpty()) {
                    visible.add(treasure)
                    treasure.isClickable = false

                } else {
                    if (visible[0].tag == treasure.tag) {
                        treasure.isClickable = false
                        handler.postDelayed({
                            visible[0].isVisible = false
                            treasure.isVisible = false
                            treasures.remove(visible[0])
                            treasures.remove(treasure)
                            visible.removeAt(0)
                            if (treasures.isNullOrEmpty()) {
                                endim.isVisible = true
                                restartBtn.isVisible = true
                                rulesTxt.isVisible = true
                                rulesTxt.text = "You Won!"
                            }
                        }, 300)
                    } else {
                        handler.postDelayed({
                            visible[0].setImageResource(R.drawable.treasure)
                            visible[0].isClickable = true
                            treasure.setImageResource(R.drawable.treasure)
                            visible.removeAt(0)
                        }, 300)
                    }

                }
            }
        }
    }
    fun goRestart(view: View) {
        Intent(applicationContext, GameplayPC::class.java).also { startActivity(it) }
        finish()
    }
}
