package io.violabs.second.common

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector3

class MousePosition : Vector3(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 0f)