package io.violabs.second.config

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Camera
import io.violabs.second.common.KOrthographicCamera
import io.violabs.second.common.ViewPort

class KCameraOperator(private val viewPortConfig: ViewPortConfig = ViewPortConfig()) {

  var camera: Camera? = null

  fun create() {
    camera = KOrthographicCamera(viewPortConfig.viewPort)
  }
}