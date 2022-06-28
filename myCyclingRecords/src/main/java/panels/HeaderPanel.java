package panels;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
  private JButton createNewWritingButton;

  public HeaderPanel() {
    this.setLayout(new GridLayout(1, 2));

    this.initBlankPanel();
    this.initCreateNewWritingButton();
  }

  public void initBlankPanel() {
    JPanel blankPanel = new JPanel();
    this.add(blankPanel);
  }

  public void initCreateNewWritingButton() {
    createNewWritingButton = new JButton("새 글 작성하기");
    this.add(createNewWritingButton);
  }

  public void setButtonActionListener(MainPanel mainPanel) {
    createNewWritingButton.addActionListener(event -> {
      mainPanel.writingEditorPanel().setVisible(true);
    });
  }
}
