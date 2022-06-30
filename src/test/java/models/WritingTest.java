package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingTest {
  @Test
  void creationTest() {
    Writing writing = new Writing(
        "작성자 1",
        "주제 1",
        "제목 1",
        "이동거리 1",
        new String[]{"경유지 1", "경유지 2", "경유지 3"},
        "글 내용 1",
        1
    );

    assertEquals("작성자 1", writing.writer());
    assertEquals("주제 1", writing.subject());
    assertEquals("제목 1", writing.title());
    assertEquals("이동거리 1", writing.distance());
    assertArrayEquals(new String[]{"경유지 1", "경유지 2", "경유지 3"}, writing.stopoverPlaces());
    assertEquals("글 내용 1", writing.content());
    assertEquals(1, writing.uniqueNumber());
  }

  @Test
  void modifyTest() {
    Writing writing = new Writing(
        "작성자 1",
        "주제 1",
        "제목 1",
        "이동거리 1",
        new String[]{"경유지 1", "경유지 2", "경유지 3"},
        "글 내용 1",
        1
    );

    writing.modifyWriter("일론머스크");
    writing.modifySubject("도지코인");
    writing.modifyTitle("ㅋㅋ");
    writing.modifyDistance("60000000km");
    writing.modifyStopoverPlaces(new String[]{"지구", "화성", "안드로메다은하"});
    writing.modifyContent("화성 갈끄니까~~~~~~");

    assertEquals("일론머스크", writing.writer());
    assertEquals("도지코인", writing.subject());
    assertEquals("ㅋㅋ", writing.title());
    assertEquals("60000000km", writing.distance());
    assertArrayEquals(new String[]{"지구", "화성", "안드로메다은하"}, writing.stopoverPlaces());
    assertEquals("화성 갈끄니까~~~~~~", writing.content());
    assertEquals(1, writing.uniqueNumber());
  }
}
