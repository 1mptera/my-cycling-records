package repositories;

import models.Writing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingRepositoryTest {

  @Test
  void createNewWritingTest() {
    WritingRepository writingRepository = new WritingRepository();

    writingRepository.createNewWriting(
        "작성자 1",
        "주제 1",
        "제목 1",
        "이동거리 1",
        "경유지 1,경유지 2,경유지 3",
        "글 내용 1",
        1
    );

    Writing createdWriting = writingRepository.writing(1);

    assertEquals("작성자 1", createdWriting.writer());
    assertEquals("주제 1", createdWriting.subject());
    assertEquals("제목 1", createdWriting.title());
    assertEquals("이동거리 1", createdWriting.distance());
    assertArrayEquals(new String[]{"경유지 1", "경유지 2", "경유지 3"}, createdWriting.stopoverPlaces());
    assertEquals("글 내용 1", createdWriting.content());
    assertEquals(1, createdWriting.uniqueNumber());
  }

  @Test
  void createNewUniqueNumberTest1() {
    WritingRepository writingRepository = new WritingRepository();

    writingRepository.addUniqueNumber(1);
    writingRepository.addUniqueNumber(2);
    writingRepository.addUniqueNumber(3);
    writingRepository.addUniqueNumber(4);
    writingRepository.addUniqueNumber(5);
    writingRepository.addUniqueNumber(6);

    int uniqueNumber = writingRepository.createNewUniqueNumber();

    System.out.println("uniqueNumber: " + uniqueNumber);

    //다른 고유번호와 중복되지 않는지
    for (int i = 0; i < writingRepository.usedUniqueNumbersListSize(); i += 1) {
      System.out.print(writingRepository.uniqueNumber(i) + " ");

      assertFalse(uniqueNumber == writingRepository.uniqueNumber(i));
    }
  }

  @Test
  void createNewUniqueNumberTest2() {
    WritingRepository writingRepository = new WritingRepository();

    writingRepository.addUniqueNumber(1);
    writingRepository.addUniqueNumber(2);
    writingRepository.addUniqueNumber(5);
    writingRepository.addUniqueNumber(6);

    int uniqueNumber = writingRepository.createNewUniqueNumber();

    System.out.println("uniqueNumber: " + uniqueNumber);

    for (int i = 0; i < writingRepository.usedUniqueNumbersListSize(); i += 1) {
      System.out.print(writingRepository.uniqueNumber(i) + " ");

      assertFalse(uniqueNumber == writingRepository.uniqueNumber(i));
    }
  }

  @Test
  void findWritingMatchingUniqueNumberTest() {
    WritingRepository writingRepository = new WritingRepository();

    writingRepository.createNewWriting(
        "작성자 1",
        "주제 1",
        "제목 1",
        "이동거리 1",
        "경유지 1,경유지 2,경유지 3",
        "글 내용 1",
        1
    );
    writingRepository.createNewWriting(
        "작성자 2",
        "주제 2",
        "제목 2",
        "이동거리 2",
        "경유지 4,경유지 5,경유지 6",
        "글 내용 2",
        2
    );
    writingRepository.createNewWriting(
        "작성자 3",
        "주제 3",
        "제목 3",
        "이동거리 3",
        "경유지 7,경유지 8,경유지 9",
        "글 내용 3",
        45
    );
    writingRepository.createNewWriting(
        "작성자 4444",
        "주제 4444",
        "리포지토리에 기본 글이 하나 들어있잖아 그러니까 기대값이 2가 아니라 3이지",
        "이동거리 4444",
        "경유지 10,경유지 11,경유지 12",
        "글 내용 4444",
        7
    );

    assertEquals(3, writingRepository.findWritingMatchingUniqueNumber(45));
  }

  @Test
  void modifyWriting() {
    WritingRepository writingRepository = new WritingRepository();

    writingRepository.createNewWriting(
        "작성자 1",
        "주제 1",
        "제목 1",
        "이동거리 1",
        "경유지 1,경유지 2,경유지 3",
        "글 내용 1",
        1
    );

    writingRepository.modifyWriting(
        1,
        "일론머스크",
        "도지코인",
        "화성 갈끄니까~~~~~",
        "60000000km",
        "지구,화성,안드로메다은하",
        "아능하스요~~~ 일런 머스컵니다 응 방갑습니다 " +
            "어이 저따라서 비트코인했다가 어 피본사랗 많저? 에흐흐흐 " +
            "나는 돈이 많으니까 상관없는데! 으러분은 조심하셔야 혜! " +
            "어이 암튼 테슬라 쥬식 얼렁 사 화성 갈끄니까~~~? " +
            "어흐흐흐흐흐흐희ㅣ~~~~"
    );

    Writing createdWriting = writingRepository.writing(1);

    assertEquals("일론머스크", createdWriting.writer());
    assertEquals("도지코인", createdWriting.subject());
    assertEquals("화성 갈끄니까~~~~~", createdWriting.title());
    assertEquals("60000000km", createdWriting.distance());
    assertArrayEquals(new String[]{"지구", "화성", "안드로메다은하"}, createdWriting.stopoverPlaces());
    assertEquals("아능하스요~~~ 일런 머스컵니다 응 방갑습니다 " +
        "어이 저따라서 비트코인했다가 어 피본사랗 많저? 에흐흐흐 " +
        "나는 돈이 많으니까 상관없는데! 으러분은 조심하셔야 혜! " +
        "어이 암튼 테슬라 쥬식 얼렁 사 화성 갈끄니까~~~? " +
        "어흐흐흐흐흐흐희ㅣ~~~~", createdWriting.content());
    assertEquals(1, createdWriting.uniqueNumber());
  }
}
