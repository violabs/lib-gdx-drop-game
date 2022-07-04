package io.violabs.second

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.utils.ScreenUtils
import io.violabs.second.common.drawSprite
import io.violabs.second.config.KAssetManager
import io.violabs.second.config.KCameraOperator
import io.violabs.second.config.KInputManager
import io.violabs.second.config.KSpriteManager

class KSecondApp(
  private val assetManager: KAssetManager = KAssetManager(),
  private val cameraOperator: KCameraOperator = KCameraOperator(),
  private val inputManager: KInputManager = KInputManager(),
  private val spriteManager: KSpriteManager = KSpriteManager()
) : ApplicationAdapter() {

  override fun create() {
    assetManager.create()
    cameraOperator.create()
    spriteManager.create()
    assetManager.rainMusic?.play(loop = true)
  }

  override fun render() {
    ScreenUtils.clear(0f, 0f, 0.2f, 1f)

    val camera: Camera = cameraOperator.camera ?: throw Exception("Missing camera")

    camera.update()

    spriteManager.updateBatch(camera.combined) {
      drawSprite(sprite = spriteManager.bucket)
      spriteManager.raindrops.forEach(this::drawSprite)
    }

    inputManager.checkBucketMouseMovement()

    inputManager.checkBucketKeyboardMovement()

    spriteManager.checkBucketBounds()

    spriteManager.addDropIfOverTime()

    spriteManager.updateDrops()
  }

  override fun dispose() {
    spriteManager.batch?.dispose()
    assetManager.dispose()
  }
}