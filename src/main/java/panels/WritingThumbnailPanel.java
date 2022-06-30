package panels;

import models.Writing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WritingThumbnailPanel extends JPanel {
  public WritingThumbnailPanel(Writing writing, MainPanel mainPanel) {
    this.setLayout(new GridLayout(4, 1));

    this.initWriterThumbnailLabel(writing.writer());
    this.initSubjectThumbnailLabel(writing.subject());
    this.initTitleThumbnailLabel(writing.title());
    this.initDistanceThumbnailLabel(writing.distance());

    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent event) {
        mainPanel.leftSpacePanel().initWritingPanel(writing);
      }
    });
  }

  private void initWriterThumbnailLabel(String writer) {
    this.add(new JLabel(writer));
  }

  private void initSubjectThumbnailLabel(String subject) {
    this.add(new JLabel(subject));
  }

  private void initTitleThumbnailLabel(String title) {
    this.add(new JLabel(title));
  }

  private void initDistanceThumbnailLabel(String distance) {
    this.add(new JLabel(distance));
  }
}
