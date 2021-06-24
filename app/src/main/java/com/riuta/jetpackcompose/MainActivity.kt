package com.riuta.jetpackcompose

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val soundMap = mapOf<String, Int>(Pair("ramen", R.raw.ramen), Pair("fire", R.raw.fire), Pair("ice", R.raw.ice), Pair("thunder", R.raw.thunder))
        setContent {
            soundList(soundMap)
        }
    }
    private fun playSound(sound: Int){
        var player = MediaPlayer.create(this, sound)
        player.also {
                it.start()
        }
    }
    @Composable
    private fun card(name: String, sound: Int){
        Column(
            Modifier.padding(100.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick ={ playSound(sound) }
            ) {
                Text(name)
            }
        }
    }

    @Composable
    private fun soundList(soundMap: Map<String, Int>){
        ScrollableColumn {
            soundMap.forEach{
                card(it.key, it.value)
            }
        }
    }
}