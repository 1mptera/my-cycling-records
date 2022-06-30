package repositories;

import models.Writing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingRepositoryTest {

  @Test
  void createNewWriting() {
    WritingRepository writingRepository = new WritingRepository();

    writingRepository.createNewWriting(
        "작성자 1",
        "주제 1",
        "제목 1",
        "이동거리 1",
        "경유지 1,경유지 2,경유지 3",
        "글 내용 1",
        "uaqt"
    );

    Writing createdWriting = writingRepository.writing(1);

    assertEquals("작성자 1", createdWriting.writer());
    assertEquals("주제 1", createdWriting.subject());
    assertEquals("제목 1", createdWriting.title());
    assertEquals("이동거리 1", createdWriting.distance());
    assertArrayEquals(new String[]{"경유지 1", "경유지 2", "경유지 3"}, createdWriting.stopoverPlaces());
    assertEquals("글 내용 1", createdWriting.content());
    assertEquals("uaqt", createdWriting.uniqueNumber());
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
        "uaqt"
    );

    writingRepository.modifyWriting(
        "uaqt",
        "일론머스크",
        "도지코인",
        "ㅋㅋ",
        "60000000km",
        "지구,화성,안드로메다은하",
        "화성 갈끄니까~~~~~~"
    );

    Writing createdWriting = writingRepository.writing(1);

    assertEquals("일론머스크", createdWriting.writer());
    assertEquals("도지코인", createdWriting.subject());
    assertEquals("ㅋㅋ", createdWriting.title());
    assertEquals("60000000km", createdWriting.distance());
    assertArrayEquals(new String[]{"지구", "화성", "안드로메다은하"}, createdWriting.stopoverPlaces());
    assertEquals("화성 갈끄니까~~~~~~", createdWriting.content());
    assertEquals("abcd", createdWriting.uniqueNumber());
  }

  @Test
  void createNewUniqueNumber() {
    WritingRepository writingRepository = new WritingRepository();

    //테스트 반복 수행 횟수
    for (int testCount = 0; testCount < 500; testCount += 1) {
      String uniqueNumber = writingRepository.createNewUniqueNumber();

      for (int i = 0; i < uniqueNumber.length(); i += 1) {
        char letter = uniqueNumber.charAt(i);

        //고유번호의 각 자리가 a~z인지
        assertTrue(letter >= 'a' && letter <= 'z');
      }

      writingRepository.addUniqueNumber(uniqueNumber);

      //다른 고유번호와 중복되지 않는지
      for (int i = 0; i < writingRepository.repositorySize(); i += 1) {
        assertFalse(uniqueNumber.equals(writingRepository.uniqueNumber(i)));
      }
    }
  }
}