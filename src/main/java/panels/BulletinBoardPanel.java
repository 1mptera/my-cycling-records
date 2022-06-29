package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class BulletinBoardPanel extends JPanel {
  private final WritingRepository writingRepository;

  public BulletinBoardPanel(WritingRepository writingRepository) {
    this.writingRepository = writingRepository;

    this.setLayout(
        new GridLayout(writingRepository.repositorySize(), 1)
    );

    this.initWritingPanels();
  }

  public void initWritingPanels() {
    for (int i = writingRepository.repositorySize() - 1; i >= 0; i -= 1) {
      JPanel writingThumbnailPanel = new WritingThumbnailPanel(writingRepository.writing(i));

      this.add(writingThumbnailPanel);
    }
  }
}
