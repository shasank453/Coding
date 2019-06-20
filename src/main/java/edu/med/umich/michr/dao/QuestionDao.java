package edu.med.umich.michr.dao;

import edu.med.umich.michr.domain.Question;

import java.util.List;

public interface QuestionDao {
  Long save(Question question);

  Question getById(long id);

  void update(Question question);

  List<Question> getAll();

  void delete(Question question);
}
