package io.violabs.second.original

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.utils.ScreenUtils
import io.violabs.second.KInjectionProvider
import io.violabs.second.common.KOrthographicCamera
import io.violabs.second.common.ViewPort
import io.violabs.second.common.drawFont
import io.violabs.second.common.update

class MainMenuScreen(private val game: Drop) : Screen {
  private val camera = KOrthographicCamera(
    viewPort = ViewPort(800, 400)
  )

  override fun show() {
    TODO("Not yet implemented")
  }

  override fun render(delta: Float) {
    ScreenUtils.clear(0f, 0f, 0.2f, 1f)

    camera.update()
    game.batch?.projectionMatrix = camera.combined

    game.batch?.update {
      drawFont(game.font, "Welcome to Drop!!!", 100, 150)
      drawFont(game.font, "Click anywhere to begin!", 100, 100)
    }

    if (!Gdx.input.isTouched) return

    game.screen = GameScreen(
      game,
      KInjectionProvider.assetManager,
      KInjectionProvider.cameraOperator,
      KInjectionProvider.inputManager,
      KInjectionProvider.spriteManager
    )
    dispose()
  }

  override fun resize(width: Int, height: Int) {

  }

  override fun pause() {
    TODO("Not yet implemented")
  }

  override fun resume() {
    TODO("Not yet implemented")
  }

  override fun hide() {

  }

  override fun dispose() {

  }
}