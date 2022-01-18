package com.example.poc835

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.flutter.embedding.android.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    companion object {
        private const val TAG_FLUTTER_FRAGMENT = "flutter_fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val incrementer: Button = findViewById(R.id.incrementer)
        val counter: TextView = findViewById(R.id.counter)
        counter.text = "0"

        incrementer.setOnClickListener {
            count++
            counter.text = count.toString()
        }

        val flutterFragment = supportFragmentManager
            .findFragmentByTag(TAG_FLUTTER_FRAGMENT) as FlutterFragment?

        if (flutterFragment == null) {
            FlutterFragment
                .withNewEngine()
                .renderMode(RenderMode.texture)
                .build<FlutterFragment>()
        }
    }
}