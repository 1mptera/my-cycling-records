package panels;

import models.Writing;
import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class WritingEditorPanel extends JPanel {
  private MainPanel mainPanel;
  private WritingRepository writingRepository;

  private final int uniqueNumber;

  private JTextField writerFormTextField;
  private JTextField subjectFormTextField;
  private JTextField titleFormTextField;
  private JTextField distanceFormTextField;
  private JTextField stopoverPlacesFormTextField;
  private JTextArea contentFormTextArea;
  private JPanel buttonsPanel;

  public WritingEditorPanel(WritingRepository writingRepository,
                            MainPanel mainPanel) {
    setFieldVariables(writingRepository, mainPanel);

    this.uniqueNumber = -1;

    this.setLayout(new GridLayout(7, 1));

    this.initWriterForm("");
    this.initSubjectForm("");
    this.initTitleForm("");
    this.initDistanceForm("");
    this.initStopoverPlacesForm(new String[]{""});
    this.initContentForm("");
    this.initButtonsPanel();
  }

  public WritingEditorPanel(WritingRepository writingRepository,
                            MainPanel mainPanel, Writing writing) {
    setFieldVariables(writingRepository, mainPanel);

    this.uniqueNumber = writing.uniqueNumber();

    this.setLayout(new GridLayout(7, 1));

    this.initWriterForm(writing.writer());
    this.initSubjectForm(writing.subject());
    this.initTitleForm(writing.title());
    this.initDistanceForm(writing.distance());
    this.initStopoverPlacesForm(writing.stopoverPlaces());
    this.initContentForm(writing.content());
    this.initButtonsPanel();
  }

  public void setFieldVariables(WritingRepository writingRepository,
                                MainPanel mainPanel) {
    this.writingRepository = writingRepository;
    this.mainPanel = mainPanel;
  }

  public JPanel createFormPanel(String labelName) {
    JPanel formPanel = new JPanel();

    formPanel.setLayout(new GridLayout(1, 2));

    formPanel.add(new JLabel(labelName));

    return formPanel;
  }

  public void initWriterForm(String receivedWriter) {
    JPanel writerFormPanel = createFormPanel("작성자: ");

    writerFormTextField = new JTextField(receivedWriter);
    writerFormPanel.add(writerFormTextField);

    this.add(writerFormPanel);
  }

  public void initSubjectForm(String receivedSubject) {
    JPanel subjectFormPanel = createFormPanel("주제: ");

    subjectFormTextField = new JTextField(receivedSubject);
    subjectFormPanel.add(subjectFormTextField);

    this.add(subjectFormPanel);
  }

  public void initTitleForm(String receivedTitle) {
    JPanel titleFormPanel = createFormPanel("제목: ");

    titleFormTextField = new JTextField(receivedTitle);
    titleFormPanel.add(titleFormTextField);

    this.add(titleFormPanel);
  }

  public void initDistanceForm(String receivedDistance) {
    JPanel distanceFormPanel = createFormPanel("주행거리: ");

    distanceFormTextField = new JTextField(receivedDistance);
    distanceFormPanel.add(distanceFormTextField);

    this.add(distanceFormPanel);
  }

  public void initStopoverPlacesForm(String[] receivedStopoverPlaces) {
    JPanel stopoverPlacesFormPanel = createFormPanel("경유장소: ");

    String concatenatedStopoverPlaces = String.join(",", receivedStopoverPlaces);

    stopoverPlacesFormTextField = new JTextField(concatenatedStopoverPlaces);
    stopoverPlacesFormPanel.add(stopoverPlacesFormTextField);

    this.add(stopoverPlacesFormPanel);
  }

  public void initContentForm(String receivedContent) {
    JPanel contentFormPanel = createFormPanel("상세 내용: ");

    contentFormTextArea = new JTextArea(receivedContent);
    contentFormTextArea.setLineWrap(true);

    JScrollPane contentFormScrollPane = new JScrollPane(contentFormTextArea);

    contentFormPanel.add(contentFormScrollPane);

    this.add(contentFormPanel);
  }

  public void initButtonsPanel() {
    buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2));

    initCancelButton();
    initSubmitButton();

    this.add(buttonsPanel);
  }

  public void emptyAllTextFields() {
    this.writerFormTextField.setText("");
    this.subjectFormTextField.setText("");
    this.titleFormTextField.setText("");
    this.distanceFormTextField.setText("");
    this.stopoverPlacesFormTextField.setText("");
    this.contentFormTextArea.setText("");
  }

  public void initCancelButton() {
    JButton cancelButton = new JButton("취소하기");
    cancelButton.addActionListener(event -> {
      emptyAllTextFields();

      this.setVisible(false);
    });

    buttonsPanel.add(cancelButton);
  }

  public void initSubmitButton() {
    JButton submitButton = new JButton("올리기");
    submitButton.addActionListener(event -> {
      switch (uniqueNumber) {
        case -1 -> {
          int createdUniqueNumber = writingRepository.createNewUniqueNumber();

          writingRepository.createNewWriting(
              this.writerFormTextField.getText(),
              this.subjectFormTextField.getText(),
              this.titleFormTextField.getText(),
              this.distanceFormTextField.getText(),
              this.stopoverPlacesFormTextField.getText(),
              this.contentFormTextArea.getText(),
              createdUniqueNumber
          );

          writingRepository.addUniqueNumber(createdUniqueNumber);
        }

        default -> {
          writingRepository.modifyWriting(
              uniqueNumber,
              this.writerFormTextField.getText(),
              this.subjectFormTextField.getText(),
              this.titleFormTextField.getText(),
              this.distanceFormTextField.getText(),
              this.stopoverPlacesFormTextField.getText(),
              this.contentFormTextArea.getText()
          );
        }
      }

      emptyAllTextFields();

      this.setVisible(false);

      mainPanel.reinitBulletinBoardPanel();
    });

    buttonsPanel.add(submitButton);
  }
}
