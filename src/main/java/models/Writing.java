package models;

public class Writing {
  private String writer;
  private String subject;
  private String title;
  private String distance;
  private String[] stopoverPlaces;
  private String content;

  private int uniqueNumber;

  public Writing(String writer, String subject, String title,
                 String distance, String[] stopoverPlaces, String content,
                 int uniqueNumber) {
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

  public int uniqueNumber() {
    return this.uniqueNumber;
  }

  public void modifyWriter(String writer) { this.writer = writer; }

  public void modifySubject(String subject) {
    this.subject = subject;
  }

  public void modifyTitle(String title) {
    this.title = title;
  }

  public void modifyDistance(String distance) {
    this.distance = distance;
  }

  public void modifyStopoverPlaces(String[] stopoverPlaces) {
    this.stopoverPlaces = stopoverPlaces;
  }

  public void modifyContent(String content) { this.content = content; }
}
