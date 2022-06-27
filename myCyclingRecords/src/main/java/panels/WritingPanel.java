package panels;

import models.Writing;

import javax.swing.*;
import java.awt.*;

public class WritingPanel extends JPanel {
  public WritingPanel(Writing writing) {
    addWriterLabel(writing.writer());
    addSubjectLabel(writing.subject());
    addTitleLabel(writing.title());
    addDistanceLabel(writing.distance());
    addStopoverPlacesPanel(writing.stopoverPlaces());
    addContentField(writing.content());
  }

  public void addWriterLabel(String writer) {
    this.add(new JLabel(writer));
  }

  public void addSubjectLabel(String subject) {
    this.add(new JLabel(subject));
  }

  public void addTitleLabel(String title) {
    this.add(new JLabel(title));
  }

  public void addDistanceLabel(String distance) {
    this.add(new JLabel(distance));
  }

  public void addStopoverPlacesPanel(String[] stopoverPlaces) {
    JPanel stopoverPlacesPanel = new JPanel();

    stopoverPlacesPanel.setLayout(new FlowLayout());

    for (String stopoverPlace : stopoverPlaces) {
      stopoverPlacesPanel.add(new JLabel(stopoverPlace));
    }

    this.add(stopoverPlacesPanel);
  }

  public void addContentField(String content) {
    JTextArea contentField = new JTextArea(content);

    contentField.setLineWrap(true);
    contentField.setEditable(false);

    this.add(contentField);
  }
}
