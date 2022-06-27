import models.Writing;
import panels.BulletinBoardPanel;
import panels.WritingPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyCyclingRecords {
  private JFrame frame;
  private JPanel bulletinBoardPanel;

  private List<Writing> writingList = List.of(
      new Writing(
          "황인우",
          "운동",
          "나의 21번째 라이딩",
          "41km",
          new String[]{
              "서울대입구역", "도림천", "안양천", "여의도한강공원", "반포한강공원", "잠실한강공원"
          },
          "월요일부터 5일 내내 장마기간이라고 하길래 오전에 얼른 나가서 자전거를 타고 왔다." +
              " 1시간 반 동안 열심히 라이딩을 해서 즐거웠다." +
              " 이제 8주차 주간 과제를 열심히 해서 잘 기능하는 프로그램을 만들고 싶다."
      )
  );

  public static void main(String[] args) {
    MyCyclingRecords application = new MyCyclingRecords();
    application.run();
  }

  public void run() {
    initFrame();

    initBulletinBoardPanel();

    JPanel writingPanel = initWritingPanel();

    addWritingPanelToBulletinBoardPanel(writingPanel);

    addBulletinBoardPanelToFrame();

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
    bulletinBoardPanel = new BulletinBoardPanel();
    bulletinBoardPanel.setLayout(new GridLayout(2, 1));
  }

  public JPanel initWritingPanel() {
    Writing writing = writingList.get(0);

    JPanel writingPanel = new WritingPanel(writing);

    writingPanel.setLayout(new GridLayout(6, 1));

    return writingPanel;
  }

  public void addWritingPanelToBulletinBoardPanel(JPanel writingPanel) {
    bulletinBoardPanel.add(writingPanel);
  }

  public void addBulletinBoardPanelToFrame() {
    frame.add(bulletinBoardPanel);
  }

  public void showFrame() {
    frame.setVisible(true);
  }
}
