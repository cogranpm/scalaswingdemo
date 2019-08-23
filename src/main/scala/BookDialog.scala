package com.parinherm.dialogs

import scala.swing._
import scala.swing.event._

import javax.swing.KeyStroke
import net.miginfocom.layout._
import net.miginfocom.swing
import net.miginfocom.swing._


class BookDialog (owner: Window) extends Dialog (owner) {
  modal = true
  val panel = new BoxPanel(Orientation.Vertical)


  val label = new Label()
  label.text = "fred"

  val txtName = new TextField()

  val btnOk = new Button("OK")
  val btnCancel = new Button("Cancel")



  panel.contents += label
  panel.peer.add( txtName.peer, "growx")
  panel.contents += btnOk
  panel.contents += btnCancel


  defaultButton = btnOk

  val layout = new MigLayout("wrap 2", "[shrink] [grow]", "[grow] [grow]")

  panel.peer.setLayout(layout)
  //this.peer.getContentPane().setLayout(layout)
  this.contents = panel
  minimumSize = new Dimension(640, 480)



  listenTo(btnOk)
  listenTo(btnCancel)
  reactions += {
    case ButtonClicked(`btnOk`) => onClickOk()
    case ButtonClicked(`btnCancel`) => onClickCancel()
  }

  def onClickOk(): Unit = {
    println("ok")
      close()
  }

  def onClickCancel() = {
    close()
  }
}

