package com.example.poc835

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.RenderMode

class OtherActivity : AppCompatActivity() {
    companion object {
        private const val TAG_CACHED_ENGINE = "cached_engine"
        private const val TAG_FLUTTER_FRAGMENT = "flutter_fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val goBackButton: Button = findViewById(R.id.back)
        goBackButton.setOnClickListener { finish() }

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