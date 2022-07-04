package io.violabs.second.common

class ViewPort(val width: Float, val height: Float) {
  constructor(width: Int, height: Int) : this(width.toFloat(), height.toFloat())
}