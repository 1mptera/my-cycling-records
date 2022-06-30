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
        "uaq6"
    );

    Writing createdWriting = writingRepository.writing(1);

    assertEquals("작성자 1", createdWriting.writer());
    assertEquals("주제 1", createdWriting.subject());
    assertEquals("제목 1", createdWriting.title());
    assertEquals("이동거리 1", createdWriting.distance());
    assertArrayEquals(new String[]{"경유지 1", "경유지 2", "경유지 3"}, createdWriting.stopoverPlaces());
    assertEquals("글 내용 1", createdWriting.content());
    assertEquals("uaq6", createdWriting.uniqueNumber());
  }
}