package repositories;

import models.Writing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WritingRepository {
  private final List<Writing> writingsList;
  private final List<Integer> usedUniqueNumbersList;

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
            0
        )
    );

    usedUniqueNumbersList = new ArrayList<>();
    usedUniqueNumbersList.add(0);
  }

  public Writing writing(int index) {
    return writingsList.get(index);
  }

  public int uniqueNumber(int index) {
    return usedUniqueNumbersList.get(index);
  }

  public int repositorySize() {
    return writingsList.size();
  }

  public int usedUniqueNumbersListSize() {
    return usedUniqueNumbersList.size();
  }

  public void createNewWriting(
      String writer, String subject, String title,
      String distance, String stopoverPlaces, String content,
      int uniqueNumber) {
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

  public int createNewUniqueNumber() {
    int createdUniqueNumber = 0;

    boolean isUniqueNumber = false;

    for (int i = 0; i < usedUniqueNumbersListSize(); i += 1) {
      createdUniqueNumber = i;

      if (createdUniqueNumber != uniqueNumber(i)) {
        isUniqueNumber = true;
        break;
      }
    }

    if (!isUniqueNumber) {
      createdUniqueNumber += 1;
    }

    return createdUniqueNumber;
  }

  public void modifyWriting(
      int uniqueNumber,
      String writer, String subject, String title,
      String distance, String stopoverPlaces, String content) {
    int indexBeModifiedWriting = findWritingMatchingUniqueNumber(uniqueNumber);

    String[] splitStopoverPlaces = stopoverPlaces.split(",");

    writing(indexBeModifiedWriting).modifyWriter(writer);
    writing(indexBeModifiedWriting).modifySubject(subject);
    writing(indexBeModifiedWriting).modifyTitle(title);
    writing(indexBeModifiedWriting).modifyDistance(distance);
    writing(indexBeModifiedWriting).modifyStopoverPlaces(splitStopoverPlaces);
    writing(indexBeModifiedWriting).modifyContent(content);
  }

  public int findWritingMatchingUniqueNumber(int uniqueNumber) {
    int index = 0;

    for (index = 0; index < repositorySize(); index += 1) {
      if (uniqueNumber == writing(index).uniqueNumber()) {
        break;
      }
    }

    return index;
  }
  public void addUniqueNumber(int uniqueNumber) {
    usedUniqueNumbersList.add(uniqueNumber);
  }
}
