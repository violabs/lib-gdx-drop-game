package io.violabs.second.original

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Drop : Game() {
  var batch: SpriteBatch? = null
  var font: BitmapFont? = null

  override fun create() {
    batch = SpriteBatch()
    font = BitmapFont()
    super.screen = MainMenuScreen(this)
  }

  override fun dispose() {
    screen.dispose()
    batch?.dispose()
    font?.dispose()
  }
}