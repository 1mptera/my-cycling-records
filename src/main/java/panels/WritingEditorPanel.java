package panels;

import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class WritingEditorPanel extends JPanel {
  private final MainPanel mainPanel;
  private final WritingRepository writingRepository;

  private JTextField writerFormTextField;
  private JTextField subjectFormTextField;
  private JTextField titleFormTextField;
  private JTextField distanceFormTextField;
  private JTextField stopoverPlacesFormTextField;
  private JTextArea contentFormTextArea;
  private JPanel buttonsPanel;

  public WritingEditorPanel(WritingRepository writingRepository,
                            MainPanel mainPanel) {
    this.writingRepository = writingRepository;
    this.mainPanel = mainPanel;
    
    this.setLayout(new GridLayout(7, 1));

    this.initWriterForm();
    this.initSubjectForm();
    this.initTitleForm();
    this.initDistanceForm();
    this.initStopoverPlacesForm();
    this.initContentForm();
    this.initButtonsPanel();

    this.setVisible(false);
  }

  public JPanel createFormPanel(String labelName) {
    JPanel formPanel = new JPanel();

    formPanel.setLayout(new GridLayout(1, 2));

    formPanel.add(new JLabel(labelName));

    return formPanel;
  }

  public void initWriterForm() {
    JPanel writerFormPanel = createFormPanel("작성자: ");

    writerFormTextField = new JTextField();
    writerFormPanel.add(writerFormTextField);

    this.add(writerFormPanel);
  }

  public void initSubjectForm() {
    JPanel subjectFormPanel = createFormPanel("주제: ");

    subjectFormTextField = new JTextField();
    subjectFormPanel.add(subjectFormTextField);

    this.add(subjectFormPanel);
  }

  public void initTitleForm() {
    JPanel titleFormPanel = createFormPanel("제목: ");

    titleFormTextField = new JTextField();
    titleFormPanel.add(titleFormTextField);

    this.add(titleFormPanel);
  }

  public void initDistanceForm() {
    JPanel distanceFormPanel = createFormPanel("주행거리: ");

    distanceFormTextField = new JTextField();
    distanceFormPanel.add(distanceFormTextField);

    this.add(distanceFormPanel);
  }

  public void initStopoverPlacesForm() {
    JPanel stopoverPlacesFormPanel = createFormPanel("경유장소: ");

    stopoverPlacesFormTextField = new JTextField();
    stopoverPlacesFormPanel.add(stopoverPlacesFormTextField);

    this.add(stopoverPlacesFormPanel);
  }

  public void initContentForm() {
    JPanel contentFormPanel = createFormPanel("상세 내용: ");

    contentFormTextArea = new JTextArea();
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
      writingRepository.createNewWriting(
          this.writerFormTextField.getText(),
          this.subjectFormTextField.getText(),
          this.titleFormTextField.getText(),
          this.distanceFormTextField.getText(),
          this.stopoverPlacesFormTextField.getText(),
          this.contentFormTextArea.getText()
      );

      emptyAllTextFields();

      this.setVisible(false);

      mainPanel.reinitBulletinBoardPanel();
    });

    buttonsPanel.add(submitButton);
  }
}
