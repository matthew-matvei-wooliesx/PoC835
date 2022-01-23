package com.example.poc835

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.flutter.embedding.android.*
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MainActivity : AppCompatActivity() {
    private var count = 0

    companion object {
        private const val TAG_CACHED_ENGINE = "cached_engine"
        private const val TAG_FLUTTER_FRAGMENT = "flutter_fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flutterEngine = FlutterEngine(this)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        FlutterEngineCache
            .getInstance()
            .put(TAG_CACHED_ENGINE, flutterEngine)

        val incrementer: Button = findViewById(R.id.incrementer)
        val counter: TextView = findViewById(R.id.counter)
        counter.text = "0"

        incrementer.setOnClickListener {
            count++
            counter.text = count.toString()
        }

        val otherPageNavigator: Button = findViewById(R.id.toOtherPage)
        otherPageNavigator.setOnClickListener {
            val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)
        }

        val flutterFragment = supportFragmentManager
            .findFragmentByTag(TAG_FLUTTER_FRAGMENT) as FlutterFragment?

        if (flutterFragment == null) {
            FlutterFragment
                .withCachedEngine(TAG_CACHED_ENGINE)
                .renderMode(RenderMode.texture)
                .build<FlutterFragment>()
        }
    }
}