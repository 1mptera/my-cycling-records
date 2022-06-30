package panels;

import models.Writing;
import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class WritingPanel extends JPanel {
  private MainPanel mainPanel;
  private WritingRepository writingRepository;

  public WritingPanel(Writing writing, MainPanel mainPanel,
                      WritingRepository writingRepository) {
    this.mainPanel = mainPanel;
    this.writingRepository = writingRepository;

    this.setLayout(new GridLayout(9, 1));

    this.initWriterLabel(writing.writer());
    this.initSubjectLabel(writing.subject());
    this.initTitleLabel(writing.title());
    this.initDistanceLabel(writing.distance());
    this.initStopoverPlacesPanel(writing.stopoverPlaces());
    this.initContentArea(writing.content());
    this.initButtonsPanel(writing);
  }

  public void initWriterLabel(String writer) {
    this.add(new JLabel("작성자: " + writer));
  }

  public void initSubjectLabel(String subject) {
    this.add(new JLabel("주제: " + subject));
  }

  public void initTitleLabel(String title) {
    this.add(new JLabel("제목: " + title));
  }

  public void initDistanceLabel(String distance) {
    this.add(new JLabel("주행거리: " + distance));
  }

  public void initStopoverPlacesPanel(String[] stopoverPlaces) {
    this.add(new JLabel("경유장소:"));

    JPanel stopoverPlacesPanel = new JPanel();

    stopoverPlacesPanel.setLayout(new FlowLayout());

    for (String stopoverPlace : stopoverPlaces) {
      stopoverPlacesPanel.add(new JLabel(stopoverPlace));
    }

    this.add(stopoverPlacesPanel);
  }

  public void initContentArea(String content) {
    this.add(new JLabel("상세 내용:"));

    JTextArea contentArea = new JTextArea(content);

    contentArea.setLineWrap(true);
    contentArea.setEditable(false);

    JScrollPane contentScrollPane = new JScrollPane(contentArea);

    this.add(contentScrollPane);
  }

  public void initButtonsPanel(Writing writing) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2));

    initModifyButton(buttonsPanel, writing);
    initDeleteButton(buttonsPanel, writing);

    this.add(buttonsPanel);
  }

  public void initModifyButton(JPanel buttonsPanel, Writing writing) {
    JButton modifyButton = new JButton("수정하기");

    modifyButton.addActionListener(event -> {
      mainPanel.leftSpacePanel().initWritingEditorPanel(writing);
    });

    buttonsPanel.add(modifyButton);
  }

  public void initDeleteButton(JPanel buttonsPanel, Writing writing) {
    JButton deleteButton = new JButton("삭제하기");

    deleteButton.addActionListener(event -> {
      writingRepository.deleteWriting(writing.uniqueNumber());

      this.setVisible(false);

      mainPanel.reinitBulletinBoardPanel();
    });

    buttonsPanel.add(deleteButton);
  }
}
