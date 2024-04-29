package com.example.imadpet

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class GameActivity : AppCompatActivity() {
    var petHealth =100
    var petHunger =0
    var petCleanliness =100



    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        var Health = findViewById<TextView>(R.id.Health)
        var Hunger = findViewById<TextView>(R.id.Hunger)
        var Cleanliness = findViewById<TextView>(R.id.Cleanliness)
        var message =findViewById<TextView>(R.id.message)
        var btnFeed = findViewById<Button>(R.id.btnFeed)
        var btnplay = findViewById<Button>(R.id.btnplay)
        var btnclean = findViewById<Button>(R.id.btnclean)
        var image = findViewById<ImageView>(R.id.imageView3)
        updateStatus()

        btnFeed.setOnClickListener{
            feedPet()
            Hunger.text = "Hunger:$petHunger"
            image.setImageDrawable(getDrawable(R.drawable.download))
            message.text="pet is feeding"


        }
        btnclean.setOnClickListener{
            cleanPet()
            Health.text = "Health:$petHealth"
            image.setImageDrawable(getDrawable(R.drawable.clean))
            message.text="pet is clean "

        }
        btnplay.setOnClickListener{
            playWithPet()
            Cleanliness.text = "Cleanliness:$petCleanliness"
            image.setImageDrawable(getDrawable(R.drawable.feed))
            message.text="pet is playing "

        }
    }
    fun  updateStatus() {

    }

    fun feedPet(){
        petHunger -= 10
        if (petHunger <0) petHunger =100
        updateStatus()
    }

    fun cleanPet(){
        petHunger += 10
        if (petHunger <0) petHunger = 0
        updateStatus()
    }
    fun playWithPet(){
        petHunger +=10
        petCleanliness-=10
        petHealth +=5
        if (petHealth> 100)
            petHealth =100
        if (petHunger>100)
            petHunger =100
        if (petCleanliness<0)
            petCleanliness = 0
        updateStatus()
    }
}




