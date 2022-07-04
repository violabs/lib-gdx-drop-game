package io.violabs.second.config

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import io.violabs.second.common.MousePosition

class KInputManager(
  private val cameraOperator: KCameraOperator = KCameraOperator(),
  private val physicsManager: KPhysicsManager = KPhysicsManager(),
  private val spriteManager: KSpriteManager = KSpriteManager()
) {

  fun checkBucketMouseMovement() {
    if (!Gdx.input.isTouched) return

    val mousePosition = MousePosition()
    cameraOperator.camera?.unproject(mousePosition)
    spriteManager.bucket?.setHorizontal(mousePosition)
  }

  fun checkBucketKeyboardMovement() {
    if (moveLeftPressed()) moveLeft()
    if (moveRightPressed()) moveRight()
  }

  private fun moveLeft() {
    spriteManager.bucket?.moveLeft(physicsManager.currentSpeed())
  }

  private fun moveRight() {
    spriteManager.bucket?.moveRight(physicsManager.currentSpeed())
  }

  private fun moveLeftPressed(): Boolean = Gdx.input.isKeyPressed(Input.Keys.LEFT)
  private fun moveRightPressed(): Boolean = Gdx.input.isKeyPressed(Input.Keys.RIGHT)
}