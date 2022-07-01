package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
  private final WritingRepository writingRepository;

  private LeftSpacePanel leftSpacePanel;
  private BulletinBoardPanel bulletinBoardPanel;

  public MainPanel(WritingRepository writingRepository) {
    this.writingRepository = writingRepository;

    this.setLayout(new GridLayout(1, 2));

    this.initLeftSpacePanel();
    this.initBulletinBoardPanel();
  }

  public LeftSpacePanel leftSpacePanel() {
    return leftSpacePanel;
  }

  public void initLeftSpacePanel() {
    leftSpacePanel = new LeftSpacePanel(writingRepository, this);

    this.add(leftSpacePanel);
  }

  public void initBulletinBoardPanel() {
    bulletinBoardPanel = new BulletinBoardPanel(writingRepository, this);

    this.add(bulletinBoardPanel);
  }

  public void reinitBulletinBoardPanel() {
    bulletinBoardPanel.removeAll();
    bulletinBoardPanel.setLayoutForBulletinBoardPanel();
    bulletinBoardPanel.initWritingPanels();
    bulletinBoardPanel.setVisible(false);
    bulletinBoardPanel.setVisible(true);
  }
}
