package io.violabs.second.config

import com.badlogic.gdx.Gdx

class KPhysicsManager {
  fun currentSpeed(): Float = 200 * Gdx.graphics.deltaTime
}