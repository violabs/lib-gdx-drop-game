package io.violabs.second.common

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

class KTexture(internalFilePath: String): Texture(Gdx.files.internal(internalFilePath)), KAsset