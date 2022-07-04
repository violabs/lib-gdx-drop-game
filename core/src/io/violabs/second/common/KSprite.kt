package io.violabs.second.common

import com.badlogic.gdx.math.Rectangle

open class KSprite(dimensions: KDimensions, val image: KTexture? = null) : Rectangle(
  dimensions.x,
  dimensions.y,
  dimensions.width,
  dimensions.height
) {
  fun moveDown(amount: Float) {
    super.y -= amount
  }

  fun moveLeft(amount: Float) {
    super.x -= amount
  }

  fun moveRight(amount: Float) {
    super.x += amount
  }

  fun setHorizontal(mousePosition: MousePosition) {
    x = mousePosition.x - width / 2
  }

  fun isAboveBottomBound(): Boolean = y + height >= 0
}