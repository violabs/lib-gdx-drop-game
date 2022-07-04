package io.violabs.second.config

import com.badlogic.gdx.ApplicationAdapter
import io.violabs.second.common.KAsset
import io.violabs.second.common.KMusic
import io.violabs.second.common.KSound
import io.violabs.second.common.KTexture

class KAssetManager {
  var dropImage: KTexture? = null
  var bucketImage: KTexture? = null

  var dropSound: KSound? = null
  var rainMusic: KMusic? = null

  fun create() {
    initializeAssets()
  }

  private fun initializeAssets() {
    dropImage = KTexture("droplet.png")
    bucketImage = KTexture("bucket.png")

    dropSound = KSound("drop.wav")
    rainMusic = KMusic("rain.mp3")
  }

  private val allAssets: List<KAsset?> = listOf(
    dropImage,
    bucketImage,
    dropSound,
    rainMusic
  )

  fun dispose() {
    allAssets.asSequence().filterNotNull().forEach(KAsset::dispose)
  }
}