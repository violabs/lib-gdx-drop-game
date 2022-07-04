package io.violabs.second.client

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.gwt.GwtApplication
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration
import io.violabs.second.SecondApp

class HtmlLauncher : GwtApplication() {
  override fun getConfig(): GwtApplicationConfiguration {
    // Resizable application, uses available space in browser
    return GwtApplicationConfiguration(800, 400)
    // Fixed size application:
    //return new GwtApplicationConfiguration(480, 320);
  }

  override fun createApplicationListener(): ApplicationListener {
    return SecondApp()
  }
}