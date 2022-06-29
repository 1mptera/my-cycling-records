package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class LeftSpacePanel extends JPanel {
  private final WritingRepository writingRepository;
  private MainPanel mainPanel;

  private WritingEditorPanel writingEditorPanel;

  public LeftSpacePanel(WritingRepository writingRepository,
                        MainPanel mainPanel) {
    this.mainPanel = mainPanel;
    this.writingRepository = writingRepository;

    this.setLayout(new GridLayout(1, 1));

    this.initWritingEditorPanel();
  }

  public WritingEditorPanel writingEditorPanel() {
    return writingEditorPanel;
  }

  public void initWritingEditorPanel() {
    writingEditorPanel = new WritingEditorPanel(writingRepository, mainPanel);

    this.add(writingEditorPanel);
  }
}
