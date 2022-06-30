package repositories;

import models.Writing;

import java.util.ArrayList;
import java.util.List;

public class WritingRepository {
  private final List<Writing> writingsList;

  public WritingRepository() {
    writingsList = new ArrayList<>();

    writingsList.add(
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
                " 이제 8주차 주간 과제를 열심히 해서 잘 기능하는 프로그램을 만들고 싶다.",
            "ta68"
        )
    );
  }

  public int repositorySize() {
    return writingsList.size();
  }

  public Writing writing(int index) {
    return writingsList.get(index);
  }

  public void createNewWriting(
      String writer, String subject, String title,
      String distance, String stopoverPlaces, String content,
      String uniqueNumber) {
    String[] splitStopoverPlaces = stopoverPlaces.split(",");

    writingsList.add(
        new Writing(
            writer,
            subject,
            title,
            distance,
            splitStopoverPlaces,
            content,
            uniqueNumber
        )
    );
  }
}
