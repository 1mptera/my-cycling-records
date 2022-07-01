package panels;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
  private JButton createNewWritingButton;

  public HeaderPanel() {
    this.setLayout(new BorderLayout());

    this.initCreateNewWritingButton();
  }

  public void initCreateNewWritingButton() {
    createNewWritingButton = new JButton("새 글 작성하기");
    this.add(createNewWritingButton, BorderLayout.EAST);
  }

  public void setButtonActionListener(MainPanel mainPanel) {
    createNewWritingButton.addActionListener(event -> {
      mainPanel.leftSpacePanel().initWritingEditorPanel();
    });
  }
}
