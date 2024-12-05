package com.cacttus.android_gr2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.cacttus.android_gr2.adapters.SingerAdapter
import com.cacttus.android_gr2.models.Singer

class ComplexListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.complex_list_layout)

        var complexList = findViewById<ListView>(R.id.complex_list)


        var singerList = listOf(
            Singer(R.drawable.rina, "Rina", 23),
            Singer(R.drawable.noizy, "Noizy", 37),
            Singer(R.drawable.dafina, "Dafina", 30),
            Singer(R.drawable.mc_kresha, "MC KRESHA", 35),
            Singer(R.drawable.lyrical_son, "Lyrical Son", 38),
            Singer(R.drawable.stresi, "Stresi", 38),
            Singer(R.drawable.ledri, "Ledri", 40),
            Singer(R.drawable.tayna, "Tayna", 25),
            Singer(R.drawable.ariana, "Ariana", 32),
            Singer(R.drawable.beyone, "Beyonce", 43)
        )

        var singerAdapter = SingerAdapter(this, singerList)


        complexList.adapter = singerAdapter


        complexList.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(
                this, "${singerList[position].name} is clicked",
                Toast.LENGTH_LONG
            )
                .show()


            var intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("photo", singerList[position].photo)
            intent.putExtra("name", singerList[position].name)
            startActivity(intent)
        }
    }
}