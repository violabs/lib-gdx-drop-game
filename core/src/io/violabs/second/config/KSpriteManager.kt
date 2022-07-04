package io.violabs.second.config

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.utils.TimeUtils
import io.violabs.second.common.KDimensions
import io.violabs.second.common.KSprite
import io.violabs.second.domain.Bucket
import io.violabs.second.domain.Raindrop

class KSpriteManager(
  private val viewPortConfig: ViewPortConfig = ViewPortConfig(),
  private val assetManager: KAssetManager = KAssetManager(),
  private val physicsManager: KPhysicsManager = KPhysicsManager()
) {
  var batch: SpriteBatch? = null

  var bucket: Bucket? = null

  var raindrops: MutableList<Raindrop> = mutableListOf()

  private var lastDropTime: Long = 0

  var dropsCollected: Int = 0

  fun create() {
    batch = SpriteBatch()

    bucket = Bucket(
      dimensions = KDimensions(
        x = 800f / 2 - 64 / 2,
        y = 20f,
        height = 64f,
        width = 64f
      ),
      image = assetManager.bucketImage
    )

    spawnRaindrop()
  }

  fun checkBucketBounds() {
    val bucket: Bucket = this.bucket ?: return

    if (bucket.x < 0) bucket.x = 0f
    if (bucket.x > 800 - 64) bucket.x = (800f - 64)
  }

  fun addDropIfOverTime() {
    if (TimeUtils.nanoTime() - lastDropTime > 1_000_000_000) spawnRaindrop()
  }

  private fun spawnRaindrop() {
    val raindrop = Raindrop(
      dimensions = KDimensions(
        x = MathUtils.random(0, 800 - 64).toFloat(),
        y = 480f,
        height = 64f,
        width = 64f
      ),
      image = assetManager.dropImage
    )

    this.raindrops.add(raindrop)
    lastDropTime = TimeUtils.nanoTime()
  }

  fun updateDrops() {
    raindrops = raindrops
      .asSequence()
      .onEach { it.moveDown(physicsManager.currentSpeed()) }
      .filter(KSprite::isAboveBottomBound)
      .onEach(this::makeSoundIfHitsBucket)
      .filter(this::missesTheBucket)
      .toMutableList()
  }

  private fun makeSoundIfHitsBucket(drop: Raindrop) {
    if (!drop.overlaps(bucket)) return

    dropsCollected++
    assetManager.dropSound?.play()
  }

  private fun missesTheBucket(drop: Raindrop): Boolean = !drop.overlaps(bucket)

  fun updateBatch(matrix: Matrix4, update: SpriteBatch.() -> Unit) {
    val batch: SpriteBatch = this.batch ?: return

    batch.projectionMatrix = matrix
    batch.begin()
    update(batch)
    batch.end()
  }
}