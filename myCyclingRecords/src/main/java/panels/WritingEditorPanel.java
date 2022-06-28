package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class WritingEditorPanel extends JPanel {
  private WritingRepository writingRepository;

  private JTextField writerFormTextField;
  private JTextField subjectFormTextField;
  private JTextField titleFormTextField;
  private JTextField distanceFormTextField;
  private JTextField stopoverPlacesFormTextField;
  private JTextArea contentFormTextArea;

  private final MainPanel mainPanel;

  public WritingEditorPanel(WritingRepository writingRepository,
                            MainPanel mainPanel) {
    this.writingRepository = writingRepository;
    this.mainPanel = mainPanel;
    
    this.setLayout(new GridLayout(7, 1));

    this.addWriterForm();
    this.addSubjectForm();
    this.addTitleForm();
    this.addDistanceForm();
    this.addStopoverPlacesForm();
    this.addContentForm();
    this.addButtonsPanel();

    this.setVisible(false);
  }

  public void addWriterForm() {
    JPanel writerFormPanel = new JPanel();

    writerFormPanel.setLayout(new GridLayout(1, 2));

    writerFormPanel.add(new JLabel("작성자: "));

    writerFormTextField = new JTextField();
    writerFormPanel.add(writerFormTextField);

    this.add(writerFormPanel);
  }

  public void addSubjectForm() {
    JPanel subjectFormPanel = new JPanel();

    subjectFormPanel.setLayout(new GridLayout(1, 2));

    subjectFormPanel.add(new JLabel("주제: "));

    subjectFormTextField = new JTextField();
    subjectFormPanel.add(subjectFormTextField);

    this.add(subjectFormPanel);
  }

  public void addTitleForm() {
    JPanel titleFormPanel = new JPanel();

    titleFormPanel.setLayout(new GridLayout(1, 2));

    titleFormPanel.add(new JLabel("제목: "));

    titleFormTextField = new JTextField();
    titleFormPanel.add(titleFormTextField);

    this.add(titleFormPanel);
  }

  public void addDistanceForm() {
    JPanel distanceFormPanel = new JPanel();

    distanceFormPanel.setLayout(new GridLayout(1, 2));

    distanceFormPanel.add(new JLabel("주행거리: "));

    distanceFormTextField = new JTextField();
    distanceFormPanel.add(distanceFormTextField);

    this.add(distanceFormPanel);
  }

  public void addStopoverPlacesForm() {
    JPanel stopoverPlacesFormPanel = new JPanel();

    stopoverPlacesFormPanel.setLayout(new GridLayout(1, 2));

    stopoverPlacesFormPanel.add(new JLabel("경유장소: "));

    stopoverPlacesFormTextField = new JTextField();
    stopoverPlacesFormPanel.add(stopoverPlacesFormTextField);

    this.add(stopoverPlacesFormPanel);
  }

  public void addContentForm() {
    JPanel contentFormPanel = new JPanel();

    contentFormPanel.setLayout(new GridLayout(1, 2));

    contentFormPanel.add(new JLabel("상세 내용: "));

    contentFormTextArea = new JTextArea();
    contentFormTextArea.setLineWrap(true);

    JScrollPane contentFormScrollPane = new JScrollPane(contentFormTextArea);

    contentFormPanel.add(contentFormScrollPane);

    this.add(contentFormPanel);
  }

  public void addButtonsPanel() {
    JPanel buttonsPanel = new JPanel();

    JButton cancelButton = new JButton("취소하기");
    cancelButton.addActionListener(event -> {
      this.writerFormTextField.setText("");
      this.subjectFormTextField.setText("");
      this.titleFormTextField.setText("");
      this.distanceFormTextField.setText("");
      this.stopoverPlacesFormTextField.setText("");
      this.contentFormTextArea.setText("");

      this.setVisible(false);
    });
    buttonsPanel.add(cancelButton);

    JButton submitButton = new JButton("올리기");
    submitButton.addActionListener(event -> {
      writingRepository.createNewWriting(
          this.writerFormTextField.getText(),
          this.subjectFormTextField.getText(),
          this.titleFormTextField.getText(),
          this.distanceFormTextField.getText(),
          this.stopoverPlacesFormTextField.getText(),
          this.contentFormTextArea.getText()
      );

      this.writerFormTextField.setText("");
      this.subjectFormTextField.setText("");
      this.titleFormTextField.setText("");
      this.distanceFormTextField.setText("");
      this.stopoverPlacesFormTextField.setText("");
      this.contentFormTextArea.setText("");

      this.setVisible(false);

      mainPanel.reinitBulletinBoardPanel(writingRepository);
    });
    buttonsPanel.add(submitButton);

    this.add(buttonsPanel);
  }
}
