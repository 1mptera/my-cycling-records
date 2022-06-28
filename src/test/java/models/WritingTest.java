package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingTest {
  @Test
  void creation() {
    Writing writing = new Writing(
        "작성자 1",
        "주제 1",
        "제목 1",
        "이동거리 1",
        new String[]{"경유지 1", "경유지 2", "경유지 3"},
        "글 내용 1"
    );

    assertEquals("작성자 1", writing.writer());
    assertEquals("주제 1", writing.subject());
    assertEquals("제목 1", writing.title());
    assertEquals("이동거리 1", writing.distance());
    assertArrayEquals(new String[]{"경유지 1", "경유지 2", "경유지 3"}, writing.stopoverPlaces());
    assertEquals("글 내용 1", writing.content());
  }
}