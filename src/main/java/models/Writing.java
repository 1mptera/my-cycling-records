package models;

public class Writing {
  private String writer;
  private String subject;
  private String title;
  private String distance;
  private String[] stopoverPlaces;
  private String content;

  private String uniqueNumber;

  public Writing(String writer, String subject, String title,
                 String distance, String[] stopoverPlaces, String content,
                 String uniqueNumber) {
    this.writer = writer;
    this.subject = subject;
    this.title = title;
    this.distance = distance;
    this.stopoverPlaces = stopoverPlaces;
    this.content = content;

    this.uniqueNumber = uniqueNumber;
  }

  public String writer() {
    return this.writer;
  }

  public String subject() {
    return this.subject;
  }

  public String title() {
    return this.title;
  }

  public String distance() {
    return this.distance;
  }

  public String[] stopoverPlaces() {
    return this.stopoverPlaces;
  }

  public String content() {
    return this.content;
  }

  public String uniqueNumber() {
    return this.uniqueNumber;
  }
}
