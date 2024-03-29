package com.parinherm.scalaswing.demo

import scala.swing._
import scala.swing.event.ButtonClicked
import scala.swing.event.Key
import javax.swing.{Box, BoxLayout, ImageIcon, JDialog, JEditorPane, JFrame, JScrollPane, KeyStroke, UIManager}
import java.awt.{BorderLayout, Color, Component, Dimension, Graphics, Image, Point, Toolkit}
import java.awt.event._
import java.awt.event.KeyEvent.VK_B
import java.awt.image.BufferedImage
import java.net.URL

import net.miginfocom.layout._
import net.miginfocom.swing
import net.miginfocom.swing._
import javax.swing.text.EditorKit
import de.sciss.syntaxpane.actions.ActionUtils
import de.sciss.syntaxpane.actions.CaretMonitor
import de.sciss.syntaxpane.DefaultSyntaxKit


import com.parinherm.dialogs._

class AppFrame extends MainFrame() {

  title = "FrameDemo2"


  //Use the Java look and feel.  This needs to be done before the frame is created
  //so the companion object FrameDemo2 cannot simply extend SimpleSwingApplcation.
//  try {
//    UIManager.setLookAndFeel(
//      UIManager.getCrossPlatformLookAndFeelClassName());
//  } catch {
//    case e: Exception => ;
//  }
  //Make sure we have nice window decorations.
  JFrame.setDefaultLookAndFeelDecorated(true);
  JDialog.setDefaultLookAndFeelDecorated(true);

  title = "fred"
  maximize()

  menuBar = createMenuBar()

  val migl = new swing.MigLayout()

  contents = new MainWindow()

  pack()


  def createMenuBar(): MenuBar = {
    val mb = new MenuBar()
    val fileMenu = new Menu("File")
    fileMenu.mnemonic = Key.F

    //val ctrlXKeyStroke = KeyStroke.getKeyStroke("control X")

    //here is how to do menu with accelerator key
    val fileMenuQuit = new MenuItem(new Action("Quit") {
      accelerator = Some(KeyStroke.getKeyStroke("ctrl Q"))
      def apply(): Unit =
      {
        MainWindow.quit()
      }
    })
    fileMenuQuit.mnemonic = Key.Q

    fileMenu.contents += fileMenuQuit
    mb.contents += fileMenu
    val editMenu = new Menu("Edit")
    editMenu.mnemonic = Key.E

    val theFrame = this
    val editMenuAddBook = new MenuItem(new Action("New Subject") {
      accelerator = Some(KeyStroke.getKeyStroke("ctrl N"))
      def apply() =
        {
          //new dialog
          val bookDialog = new  BookDialog(theFrame)
          bookDialog.open()

        }
    })
    editMenuAddBook.mnemonic = Key.N

    editMenu.contents += editMenuAddBook
    mb.contents += editMenu
    return mb
  }

}

class MainWindow extends GridPanel(1, 1) {

  val splitter: SplitPane = new SplitPane(Orientation.Vertical)
  splitter.dividerLocation = 150
  val btn: Button = new Button ("click here")
  splitter.leftComponent = btn

  //setting up the editor
  DefaultSyntaxKit.initKit()
  val txtSyntax = new JEditorPane()
  val srcScrollPane = new JScrollPane(txtSyntax)
  txtSyntax.setContentType("text/java")
  txtSyntax.setText("public static void main(String[] args) {\n}")
  splitter.peer.setRightComponent(srcScrollPane)
  splitter.preferredSize = new Dimension(400, 200)

  listenTo(btn)
  reactions += {
    case ButtonClicked(`btn`) => onClickButton()
  }

  def onClickButton(): Unit = {
    btn.enabled = false
  }


  contents += splitter

}


object MainWindow extends SimpleSwingApplication {

  lazy val top = new AppFrame()

  override def shutdown(): Unit = {
    println("i am shutting down")
  }



}
