package com.parinherm.dialogs

import scala.swing._
import javax.swing.KeyStroke
import net.miginfocom.layout._
import net.miginfocom.swing
import net.miginfocom.swing._


class BookDialog (owner: Window) extends Dialog (owner) {
  modal = true
  val panel = new BoxPanel(Orientation.Vertical)

  val label = new Label()
  label.text = "fred"

  val btnOk = new Button("OK")
  val btnCancel = new Button("Cancel")

  panel.contents += label
  panel.contents += btnOk
  panel.contents += btnCancel

  this.contents = panel
  minimumSize = new Dimension(640, 480)

}
