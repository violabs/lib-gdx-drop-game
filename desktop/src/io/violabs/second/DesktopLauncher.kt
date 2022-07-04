package io.violabs.second

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import io.violabs.second.config.*
import io.violabs.second.original.Drop

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
object DesktopLauncher {
  @JvmStatic
  fun main(arg: Array<String>) {
    val config = Lwjgl3ApplicationConfiguration().apply {
      setTitle("Drop")
      setWindowedMode(800, 480)
      useVsync(true)
      setForegroundFPS(60)
    }

//    Lwjgl3Application(SecondApp(), config)
    Lwjgl3Application(Drop(), config)
//    Lwjgl3Application(KInjectionProvider.app(), config)
  }
}