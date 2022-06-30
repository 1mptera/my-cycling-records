package panels;

import models.Writing;
import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class LeftSpacePanel extends JPanel {
  private final WritingRepository writingRepository;

  private MainPanel mainPanel;

  private WritingEditorPanel writingEditorPanel;
  private WritingPanel writingPanel;

  public LeftSpacePanel(WritingRepository writingRepository,
                        MainPanel mainPanel) {
    this.mainPanel = mainPanel;
    this.writingRepository = writingRepository;

    this.setLayout(new GridLayout(1, 1));
  }

  public void initWritingEditorPanel() {
    this.removeAll();

    writingEditorPanel = new WritingEditorPanel(writingRepository, mainPanel);

    addAndSetVisible(writingEditorPanel);
  }

  public void initWritingEditorPanel(Writing writing) {
    this.removeAll();

    writingEditorPanel = new WritingEditorPanel(
        writingRepository, mainPanel, writing
    );

    addAndSetVisible(writingEditorPanel);
  }

  public void initWritingPanel(Writing writing) {
    this.removeAll();

    writingPanel = new WritingPanel(writing, mainPanel);

    addAndSetVisible(writingPanel);
  }

  public void addAndSetVisible(JPanel panel) {
    this.add(panel);

    this.setVisible(false);
    this.setVisible(true);
  }
}
