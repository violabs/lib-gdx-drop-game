package io.violabs.second.common

import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch

fun SpriteBatch.drawSprite(sprite: KSprite?) {
  sprite?.let {
    draw(sprite.image, sprite.x, sprite.y)
  }
}

fun SpriteBatch.drawFont(font: BitmapFont?, message: String, x: Int, y: Int) {
  font?.let {
    font.draw(this, message, x.toFloat(), y.toFloat())
  }
}

fun SpriteBatch.update(updateScope: SpriteBatch.() -> Unit) {
  begin()
  updateScope(this)
  end()
}