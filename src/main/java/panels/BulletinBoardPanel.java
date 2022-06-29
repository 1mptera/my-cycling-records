package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class BulletinBoardPanel extends JPanel {
  private final WritingRepository writingRepository;

  private final MainPanel mainPanel;

  public BulletinBoardPanel(WritingRepository writingRepository,
                            MainPanel mainPanel) {
    this.writingRepository = writingRepository;

    this.mainPanel = mainPanel;

    this.setLayout(
        new GridLayout(writingRepository.repositorySize(), 1)
    );

    this.initWritingPanels();
  }

  public void initWritingPanels() {
    for (int i = writingRepository.repositorySize() - 1; i >= 0; i -= 1) {
      JPanel writingThumbnailPanel =
          new WritingThumbnailPanel(writingRepository.writing(i), mainPanel);

      this.add(writingThumbnailPanel);
    }
  }
}
