import javax.swing.*;
import java.awt.*;

public class MyCyclingRecords {
  private JFrame frame;
  private JPanel boardPanel;

  public static void main(String[] args) {
    MyCyclingRecords application = new MyCyclingRecords();
    application.run();
  }

  public void run() {
    initFrame();

    initBoardPanel();

    showFrame();
  }

  public void initFrame() {
    frame = new JFrame("My Cycling Application");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(150, 150);
    frame.setSize(450, 600);
    frame.setLayout(new GridLayout(1, 1));
  }

  public void initBoardPanel() {
    boardPanel = new JPanel();

    JTextField contentField = new JTextField("게시글 내용 textfield");
    contentField.setEditable(false);
    boardPanel.add(contentField);

    frame.add(boardPanel);
  }

  public void showFrame() {
    frame.setVisible(true);
  }
}
