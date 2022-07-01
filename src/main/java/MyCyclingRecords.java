import panels.HeaderPanel;
import panels.MainPanel;
import repositories.WritingRepository;

import javax.swing.*;
import java.awt.*;

public class MyCyclingRecords {
  private JFrame frame;
  private HeaderPanel headerPanel;
  private MainPanel mainPanel;

  private WritingRepository writingRepository;

  public static void main(String[] args) {
    MyCyclingRecords application = new MyCyclingRecords();
    application.run();
  }

  public MyCyclingRecords() {
    writingRepository = new WritingRepository();
  }

  public void run() {
    initFrame();

    initHeaderPanel();
    initMainPanel();

    showFrame();
  }

  public void initFrame() {
    frame = new JFrame("My Cycling Application");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(new BorderLayout());
  }

  public void initHeaderPanel() {
    headerPanel = new HeaderPanel();
    frame.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void initMainPanel() {
    mainPanel = new MainPanel(writingRepository);

    headerPanel.setButtonActionListener(mainPanel);

    frame.add(mainPanel);
  }

  public void showFrame() {
    frame.setVisible(true);
  }
}
