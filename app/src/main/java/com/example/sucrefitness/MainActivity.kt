package com.example.sucrefitness

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sucrefitness.adapter.GymAdapter
import com.example.sucrefitness.adapter.OpinionAdapter
import com.example.sucrefitness.model.Gym
import com.example.sucrefitness.model.Opinion
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()

        intentToMap()

        var name = intent.getStringExtra("keyName")
        txt_user_get.text = "Hola $name..."

    }

    private fun setupRecycler(){
        recyclerview_gym.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val gymList = listOf<Gym>(
            Gym("https://gestorweb.go-fit.es/Upload/Images/418D8D3312C5C9DB90F4FC5543D9D8C0.jpg","Go Fit"),
            Gym("https://i.pinimg.com/originals/69/c3/59/69c359b07862931fcbefce769c6e92ef.jpg","Tiburón"),
            Gym("https://cppc.org.ar/wp-content/uploads/2020/03/megatlon-en-casa-con-logo-.jpg","Megatlon"),
            Gym("https://cdn.knoji.com/images/logo/gymsharkcom.jpg","Gym Shark")
        )
        recyclerview_gym.adapter = GymAdapter(this, gymList)

        recycler_opinion.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        val opinionList = listOf<Opinion>(
            Opinion("Marina Vega","Muy buena app!!"),
            Opinion("Nicolas Zelaya", "Sinceramente vi aparatos mejores en otros lados y estos no valen la mensualidad"),
            Opinion("Francisco Perez","En lo particular me llamo la atención el precio de la mensualidad, muy accesible"),
            Opinion("Mario Gómez","El gimnasio estaba muy bueno, era limpio y cercano"),
            Opinion("Isabel Vega","Al fin encontré mi gimnasio perfecto"),
            Opinion("Norma Orellana","Encontré de todo, buenos precios"),
            Opinion("Daniel Camacho","Por el covid todo subió"),
        )
        recycler_opinion.adapter = OpinionAdapter(this, opinionList)

    }

    fun intentToMap(){
        btn_gym_search.setOnClickListener {
//            Toast.makeText(this, "HOLI", Toast.LENGTH_SHORT).show()
            var intentMap = Intent(this, MapActivity::class.java)
            startActivity(intentMap)
        }
    }
}