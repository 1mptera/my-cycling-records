import panels.BulletinBoardPanel;
import panels.WritingPanel;
import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class MyCyclingRecords {
  private JFrame frame;
  private JPanel bulletinBoardPanel;

  private WritingRepository writingRepository;

  public static void main(String[] args) {
    MyCyclingRecords application = new MyCyclingRecords();
    application.run();
  }

  public MyCyclingRecords() {
    writingRepository = new WritingRepository();
  }

  public void run() {
    initFrame();

    initBulletinBoardPanel();
    initWritingPanels();

    addBulletinBoardPanelToFrame();

    showFrame();
  }

  public void initFrame() {
    frame = new JFrame("My Cycling Application");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(150, 150);
    frame.setLayout(new GridLayout(1, 1));
    frame.setSize(450, 600);
  }

  public void initBulletinBoardPanel() {
    bulletinBoardPanel = new BulletinBoardPanel();
    bulletinBoardPanel.setLayout(
        new GridLayout(writingRepository.repositorySize(), 1)
    );
  }

  public void initWritingPanels() {
    for (int i = 0; i < writingRepository.repositorySize(); i += 1) {
      JPanel writingPanel = new WritingPanel(writingRepository.writing(i));

      bulletinBoardPanel.add(writingPanel);
    }
  }

  public void addBulletinBoardPanelToFrame() {
    frame.add(bulletinBoardPanel);
  }

  public void showFrame() {
    frame.pack();

    frame.setVisible(true);
  }
}
