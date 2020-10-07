package com.example.sucrefitness

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sucrefitness.adapter.GymListAdapter
import com.example.sucrefitness.adapter.OpinionAdapter
import com.example.sucrefitness.model.GymList
import com.example.sucrefitness.model.Opinion
import kotlinx.android.synthetic.main.activity_gym.*


class GymActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym)

        val nameGym = intent.getStringExtra("gymName")
        txt_gym_name.text = nameGym

        setupRecycler()

        btn_gym_contact.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=+59169668614"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

    }

    private fun setupRecycler(){
        recyclerview_gym_list.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val gymListList = listOf<GymList>(
            GymList("https://s3-us-west-2.amazonaws.com/melingoimages/Images/42356.jpg"),
            GymList("https://ossfitness.com/fotos/2019/10/boutique2-1024x768.jpg"),
            GymList("https://www.espaciowellness.es/wp-content/uploads/2018/01/espacio-wellness-1580196.jpg"),
            GymList("https://s.abcnews.com/images/US/Virus_Outbreak_Florida-Gyms_Open_hpEmbed_20200519-042233_3x2_992.jpg"),
            GymList("https://images.dailyhive.com/20200609094309/DH-GYM.jpg"),
            GymList("https://media.apnarm.net.au/media/images/2020/04/22/v3imagesbin43b364830f92beff7e68fe1202a71591-qio439q3jjbytc4o7u2_t1880.jpg")
        )
        recyclerview_gym_list.adapter = GymListAdapter(this, gymListList)

        recycler_opinion_gym.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        val opinionList = listOf<Opinion>(
            Opinion("Marina Vega", "Muy buena app!!"),
            Opinion(
                "Nicolas Zelaya",
                "Sinceramente vi aparatos mejores en otros lados y estos no valen la mensualidad"
            ),
            Opinion(
                "Francisco Perez",
                "En lo particular me llamo la atención el precio de la mensualidad, muy accesible"
            ),
            Opinion("Mario Gómez", "El gimnasio estaba muy bueno, era limpio y cercano"),
            Opinion("Isabel Vega", "Al fin encontré mi gimnasio perfecto"),
            Opinion("Norma Orellana", "Encontré de todo, buenos precios"),
            Opinion("Daniel Camacho", "Por el covid todo subió"),
        )
        recycler_opinion_gym.adapter = OpinionAdapter(this, opinionList)


    }

}