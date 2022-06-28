package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
  private WritingEditorPanel writingEditorPanel;
  private BulletinBoardPanel bulletinBoardPanel;

  public MainPanel(WritingRepository writingRepository) {
    this.setLayout(new GridLayout(1, 2));

    this.initWritingEditorPanel(writingRepository);
    this.initBulletinBoardPanel(writingRepository);
  }

  public WritingEditorPanel writingEditorPanel() {
    return writingEditorPanel;
  }

  public void initWritingEditorPanel(WritingRepository writingRepository) {
    writingEditorPanel = new WritingEditorPanel(writingRepository, this);

    this.add(writingEditorPanel);
  }

  public void initBulletinBoardPanel(WritingRepository writingRepository) {
    bulletinBoardPanel = new BulletinBoardPanel(writingRepository);

    this.add(bulletinBoardPanel);
  }

  public void reinitBulletinBoardPanel(WritingRepository writingRepository) {
    bulletinBoardPanel.removeAll();
    bulletinBoardPanel.setLayout(
        new GridLayout(writingRepository.repositorySize(), 1)
    );
    bulletinBoardPanel.initAndAddWritingPanels();
    bulletinBoardPanel.setVisible(false);
    bulletinBoardPanel.setVisible(true);
  }
}
