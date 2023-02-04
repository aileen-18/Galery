package com.kotlin.galery


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var img1 :ImageView
    private lateinit var img2 :ImageView
    private lateinit var img3 :ImageView
    private lateinit var img4 :ImageView
    private lateinit var img5 :ImageView
    private lateinit var img6 :ImageView
    private lateinit var img7 :ImageView
    private lateinit var prev: Button
    private lateinit var next : Button
    private lateinit var layout : ConstraintLayout
    private lateinit var layout1 : LinearLayout


    var imgArray: MutableList<Int> = mutableListOf()
    var index = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img6 = findViewById(R.id.imageView6)
        img5 = findViewById(R.id.imageView5)
        img1 = findViewById(R.id.imageView)
        img2 = findViewById(R.id.imageView2)
        img3 = findViewById(R.id.imageView3)
        img4 = findViewById(R.id.imageView4)
        img7 = findViewById(R.id.imageView7)
        prev = findViewById(R.id.previous)
        next = findViewById(R.id.next)
        layout = findViewById(R.id.layout)
        layout1 = findViewById(R.id.layout1)

        imgArray.add(R.drawable.img)
        imgArray.add(R.drawable.img_1)
        imgArray.add(R.drawable.img_2)
        imgArray.add(R.drawable.img_3)
        imgArray.add(R.drawable.img_4)
        imgArray.add(R.drawable.img_5)

        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)
        img6.setOnClickListener(this)


        prev.setOnClickListener {
            prev()
        }
        next.setOnClickListener {next()}
    }

    override fun onClick(p0: View?) {
        var image = findViewById<ImageView>(p0!!.id)
        var tag = image.tag.toString().toInt()
        index = tag
        img7.setImageResource(imgArray[tag])
        layout.visibility = View.VISIBLE
        layout1.visibility  = View.GONE

    }
    fun prev(){
        if(index>0){
            index--
            img7.setImageResource(imgArray[index])
        }
        if(index == 0){
            Toast.makeText(this@MainActivity,"Bu birinchi rasm edi",Toast.LENGTH_SHORT).show()
        }
    }
    fun next(){
        if(index<imgArray.size-1){
            index++
            img7.setImageResource(imgArray[index])
        }
        if(index == imgArray.size-1){
            Toast.makeText(this@MainActivity,"Bu eng oxirgi rasm edi",Toast.LENGTH_SHORT).show()
        }


    }

}