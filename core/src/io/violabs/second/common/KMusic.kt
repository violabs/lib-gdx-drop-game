package io.violabs.second.common

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music

class KMusic(internalFilePath: String) : KAsset {
  private val music: Music = Gdx.audio.newMusic(Gdx.files.internal(internalFilePath))

  fun play(loop: Boolean = false) {
    music.isLooping = loop
    music.play()
  }

  override fun dispose() { music.dispose() }
}