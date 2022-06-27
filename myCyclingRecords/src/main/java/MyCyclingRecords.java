import javax.swing.*;
import java.awt.*;

public class MyCyclingRecords {
  private JFrame frame;
  private JPanel bulletinBoardPanel;
  private JPanel writingPanel1;
  private JPanel writingPanel2;

  public static void main(String[] args) {
    MyCyclingRecords application = new MyCyclingRecords();
    application.run();
  }

  public void run() {
    initFrame();

    initBulletinBoardPanel();

    showFrame();
  }

  public void initFrame() {
    frame = new JFrame("My Cycling Application");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(150, 150);
    frame.setLayout(new GridLayout(1, 1));
    frame.setSize(450, 600);
  }

  public void initBulletinBoardPanel() {
    bulletinBoardPanel = new JPanel();
    bulletinBoardPanel.setLayout(new GridLayout(2, 1));

    writingPanel1 = new JPanel();

    writingPanel1.setLayout(new GridLayout(6, 1));

    JLabel writerLabel1 = new JLabel("작성자 label 1");
    writingPanel1.add(writerLabel1);

    JLabel subjectLabel1 = new JLabel("주제 label 1");
    writingPanel1.add(subjectLabel1);

    JLabel titleLabel1 = new JLabel("제목 label 1");
    writingPanel1.add(titleLabel1);

    JLabel distanceLabel1 = new JLabel("이동거리 label 1");
    writingPanel1.add(distanceLabel1);

    JPanel stopoverPlacesPanel1 = new JPanel();
    stopoverPlacesPanel1.setLayout(new FlowLayout());

    JLabel stopoverPlace1Label1 = new JLabel("경유 장소 1 label 1");
    stopoverPlacesPanel1.add(stopoverPlace1Label1);
    JLabel stopoverPlace2Label1 = new JLabel("경유 장소 2 label 1");
    stopoverPlacesPanel1.add(stopoverPlace2Label1);

    writingPanel1.add(stopoverPlacesPanel1);

    JTextField contentField1 = new JTextField("게시글 내용 textfield 1");
    contentField1.setEditable(false);
    writingPanel1.add(contentField1);

    bulletinBoardPanel.add(writingPanel1);

    writingPanel2 = new JPanel();

    writingPanel2.setLayout(new GridLayout(6, 1));

    JLabel writerLabel2 = new JLabel("작성자 label 2");
    writingPanel2.add(writerLabel2);

    JLabel subjectLabel2 = new JLabel("주제 label 2");
    writingPanel2.add(subjectLabel2);

    JLabel titleLabel2 = new JLabel("제목 label 2");
    writingPanel2.add(titleLabel2);

    JLabel distanceLabel2 = new JLabel("이동거리 label 2");
    writingPanel2.add(distanceLabel2);

    JPanel stopoverPlacesPanel2 = new JPanel();
    stopoverPlacesPanel2.setLayout(new FlowLayout());

    JLabel stopoverPlace1Label2 = new JLabel("경유 장소 1 label 2");
    stopoverPlacesPanel2.add(stopoverPlace1Label2);
    JLabel stopoverPlace2Label2 = new JLabel("경유 장소 2 label 2");
    stopoverPlacesPanel2.add(stopoverPlace2Label2);

    writingPanel2.add(stopoverPlacesPanel2);

    JTextField contentField2 = new JTextField("게시글 내용 textfield 2");
    contentField2.setEditable(false);
    writingPanel2.add(contentField2);

    bulletinBoardPanel.add(writingPanel2);

    frame.add(bulletinBoardPanel);
  }

  public void showFrame() {
    frame.setVisible(true);
  }
}
