package edu.med.umich.michr.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Question")
public class Question implements Serializable {

  private static final long serialVersionUID = 7476458559052451727L;

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private long id;

  @Column(name = "TEXT")
  private String text;

  public Question() {
  }

  public Question(long id, String text) {
    this.text = text;
    this.id = id;
  }

  public Question(String text) {
    this.text = text;
  }

  public long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Question)) {
      return false;
    }
    Question question = ((Question) obj);
    return this.id == question.getId()
        && this.text.equals(question.getText());
  }
}
