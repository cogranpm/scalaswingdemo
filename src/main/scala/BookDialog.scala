package com.parinherm.dialogs

import scala.swing._
import scala.swing.event._
import javax.swing._
import javax.swing.KeyStroke
import net.miginfocom.layout._
import net.miginfocom.swing
import net.miginfocom.swing._


class BookDialog (owner: Window) extends Dialog (owner) {
  modal = true
  //val layout = new MigLayout("fill")
  //val layout = new MigLayout("fillx", "[right]rel[grow, fill]", "[]10[]")
  val layout = new MigLayout()
  layout.setLayoutConstraints("fillx")
  layout.setColumnConstraints("[right]rel[grow, fill]")
  layout.setRowConstraints("[]10[]")

  val panel = new JPanel(layout)

  val label = new Label()
  label.text = "fred"

  val txtName = new TextField()
  txtName.editable = true

  val btnOk = new Button("OK")
  val btnCancel = new Button("Cancel")

  panel.add(label.peer)
  panel.add(txtName.peer, "wrap")
  panel.add(btnOk.peer)
  panel.add(btnCancel.peer)
/*
  panel.add(label.peer, "cell 0 0")
  panel.add( txtName.peer, "cell 1 0, growx")
  panel.add(btnOk.peer, "cell 0 1")
  panel.add(btnCancel.peer, "cell 1 1")
*/

  defaultButton = btnOk



  //panel.peer.setLayout(layout)
  //this.contents = panel
  peer.add(panel)
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

