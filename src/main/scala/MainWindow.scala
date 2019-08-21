package com.parinherm.scalaswing.demo

import scala.swing._
import scala.swing.event.ButtonClicked


class AppFrame extends MainFrame() {
  println("Mainframe")
  title = "fred"
  maximize()

  menuBar = createMenuBar()

  contents = new MainWindow()


  def createMenuBar(): MenuBar = {
    val mb = new MenuBar()
    val fileMenu = new Menu("File")
    val fileMenuQuit = new MenuItem("Quit")
    fileMenuQuit.mnemonic = Key.Val
    fileMenu.contents += fileMenuQuit
    mb.contents += fileMenu
    mb.contents += new Menu("Edit")
    return mb
  }

}

class MainWindow extends FlowPanel() {

  val btn: Button = new Button ("click here")
  contents += btn


  listenTo(btn)
  reactions += {
    case ButtonClicked(`btn`) => onClickButton()
  }

  def onClickButton(): Unit = {
    btn.enabled = false
  }
}


object MainWindow extends SimpleSwingApplication {

  lazy val top = new AppFrame()

  override def shutdown(): Unit = {
    println("i am shutting down")
  }



}
