package io.violabs.second.common

import com.badlogic.gdx.graphics.OrthographicCamera

class KOrthographicCamera(
  viewPort: ViewPort,
  yDown: Boolean = false
) : OrthographicCamera(viewPort.width, viewPort.height) {

  init {
    setToOrtho(yDown)
  }

  object Factory {
    fun default(): KOrthographicCamera = KOrthographicCamera(
      ViewPort(100f, 100f)
    )
  }
}