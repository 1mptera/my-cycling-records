package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
  private final WritingRepository writingRepository;

  private WritingEditorPanel writingEditorPanel;
  private BulletinBoardPanel bulletinBoardPanel;

  public MainPanel(WritingRepository writingRepository) {
    this.writingRepository = writingRepository;

    this.setLayout(new GridLayout(1, 2));

    this.initWritingEditorPanel();
    this.initBulletinBoardPanel();
  }

  public WritingEditorPanel writingEditorPanel() {
    return writingEditorPanel;
  }

  public void initWritingEditorPanel() {
    writingEditorPanel = new WritingEditorPanel(writingRepository, this);

    this.add(writingEditorPanel);
  }

  public void initBulletinBoardPanel() {
    bulletinBoardPanel = new BulletinBoardPanel(writingRepository);

    this.add(bulletinBoardPanel);
  }

  public void reinitBulletinBoardPanel() {
    bulletinBoardPanel.removeAll();
    bulletinBoardPanel.setLayout(
        new GridLayout(writingRepository.repositorySize(), 1)
    );
    bulletinBoardPanel.initWritingPanels();
    bulletinBoardPanel.setVisible(false);
    bulletinBoardPanel.setVisible(true);
  }
}
