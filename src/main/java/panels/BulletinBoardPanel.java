package panels;

import repositories.WritingRepository;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BulletinBoardPanel extends JPanel {
  private final WritingRepository writingRepository;

  private final MainPanel mainPanel;

  public BulletinBoardPanel(WritingRepository writingRepository,
                            MainPanel mainPanel) {
    this.writingRepository = writingRepository;

    this.mainPanel = mainPanel;

    this.setLayoutForBulletinBoardPanel();

    this.initWritingPanels();
  }

  public void setLayoutForBulletinBoardPanel() {
    this.setLayout(new FlowLayout());
  }

  public void initWritingPanels() {
    for (int i = writingRepository.repositorySize() - 1; i >= 0; i -= 1) {
      JPanel writingThumbnailPanel =
          new WritingThumbnailPanel(writingRepository.writing(i), mainPanel);

      writingThumbnailPanel.setPreferredSize(new Dimension(200, 100));
      writingThumbnailPanel.setBorder(new LineBorder(Color.black));

      this.add(writingThumbnailPanel);
    }
  }
}
