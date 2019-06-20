package edu.med.umich.michr.dao;

import edu.med.umich.michr.domain.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class QuestionDaoImplTest {

  @Autowired
  private TestEntityManager testEntityManager;

  private QuestionDao dao;

  @BeforeEach
  void setUp() {
    dao = new QuestionDaoImpl(testEntityManager.getEntityManager());
  }

  @AfterEach
  void tearDown() {
    dao = null;
  }

  @Test
  void testSave() {
    Question question = new Question("text");

    Long savedId = dao.save(question);

    Question savedQuestion = dao.getById(savedId);

    assertEquals(question.getText(), savedQuestion.getText());
  }

  @Test
  void testUpdate() {
    Question question = new Question("text");

    Long savedId = dao.save(question);

    Question questionToUpdate = new Question(savedId, "new text");

    dao.update(questionToUpdate);

    Question questionFetched = dao.getById(savedId);

    assertEquals(savedId.longValue(), questionFetched.getId());
    assertEquals("new text", questionFetched.getText());
  }

  @Test
  void testGetAll() {
    Question question1 = new Question("text1");
    Question question2 = new Question("text2");

    long id1 = dao.save(question1);
    long id2 = dao.save(question2);

    List<Question> expected = Arrays.asList(new Question(id1, question1.getText()));
                    new Question(id2, question2.getText());
    List<Question> questions = dao.getAll();

    assertEquals(expected, questions);

  }

  @Test
  void testDelete() {
    Question question = new Question("text");
    long id = dao.save(question);

    assertNotNull(dao.getById(id));

    dao.delete(dao.getById(id));

    assertNull(dao.getById(id));
  }
}