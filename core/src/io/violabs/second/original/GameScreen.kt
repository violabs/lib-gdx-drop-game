package io.violabs.second.original

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.utils.ScreenUtils
import io.violabs.second.common.drawFont
import io.violabs.second.common.drawSprite
import io.violabs.second.config.KAssetManager
import io.violabs.second.config.KCameraOperator
import io.violabs.second.config.KInputManager
import io.violabs.second.config.KSpriteManager

class GameScreen(
  private val game: Drop,
  private val assetManager: KAssetManager,
  private val cameraOperator: KCameraOperator,
  private val inputManager: KInputManager,
  private val spriteManager: KSpriteManager
) : Screen {
  init {
    assetManager.create()
    cameraOperator.create()
    spriteManager.create()
  }

  override fun show() {
    assetManager.rainMusic?.play()
  }

  override fun render(delta: Float) {
    ScreenUtils.clear(0f, 0f, 0.2f, 1f)

    val camera: Camera = cameraOperator.camera ?: throw Exception("Missing camera")

    camera.update()

    spriteManager.updateBatch(camera.combined) {
      drawFont(game.font, "Drops Collected: ${spriteManager.dropsCollected}", 0, 480)
      drawSprite(sprite = spriteManager.bucket)
      spriteManager.raindrops.forEach(this::drawSprite)
    }

    inputManager.checkBucketMouseMovement()

    inputManager.checkBucketKeyboardMovement()

    spriteManager.checkBucketBounds()

    spriteManager.addDropIfOverTime()

    spriteManager.updateDrops()
  }

  override fun resize(width: Int, height: Int) {

  }

  override fun pause() {

  }

  override fun resume() {

  }

  override fun hide() {

  }

  override fun dispose() {
    spriteManager.batch?.dispose()
    assetManager.dispose()
  }
}