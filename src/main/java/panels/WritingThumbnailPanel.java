package panels;

import models.Writing;

import javax.swing.*;
import java.awt.*;

public class WritingThumbnailPanel extends JPanel {
  public WritingThumbnailPanel(Writing writing) {
    this.setLayout(new GridLayout(4, 1));

    this.addWriterThumbnailLabel(writing.writer());
    this.addSubjectThumbnailLabel(writing.subject());
    this.addTitleThumbnailLabel(writing.title());
    this.addDistanceThumbnailLabel(writing.distance());
  }

  private void addWriterThumbnailLabel(String writer) {
    this.add(new JLabel(writer));
  }

  private void addSubjectThumbnailLabel(String subject) {
    this.add(new JLabel(subject));
  }

  private void addTitleThumbnailLabel(String title) {
    this.add(new JLabel(title));
  }

  private void addDistanceThumbnailLabel(String distance) {
    this.add(new JLabel(distance));
  }
}
