package com.cacttus.android_gr2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity

class SimpleListActivity : ComponentActivity() {
    private lateinit var simpleList: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simple_list_layout)
        simpleList = findViewById(R.id.simple_list)

        var adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listOf(
                "Arber",
                "Anda",
                "Egzon",
                "Arsona",
                "Alisa",
                "Bleron",
                "Elsa",
                "Elton",
                "Denis",
                "Elion",
                "Butrint"
            )
        )

        simpleList.adapter = adapter
    }
}