package io.violabs.second

import io.violabs.second.config.*
import io.violabs.second.original.Drop

object KInjectionProvider {
  val assetManager = KAssetManager()
  val viewPortConfig = ViewPortConfig()
  val cameraOperator = KCameraOperator(viewPortConfig)
  val physicsManager = KPhysicsManager()
  val spriteManager = KSpriteManager(viewPortConfig, assetManager, physicsManager)
  val inputManager = KInputManager(cameraOperator, physicsManager, spriteManager)

  fun app(): KSecondApp = KSecondApp(
    assetManager,
    cameraOperator,
    inputManager,
    spriteManager
  )
}