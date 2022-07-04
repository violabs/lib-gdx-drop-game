package io.violabs.second.common

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound

class KSound(internalFilePath: String) : KAsset {
  private val sound: Sound = Gdx.audio.newSound(Gdx.files.internal(internalFilePath))

  fun play() { sound.play() }

  override fun dispose() { sound.dispose() }
}