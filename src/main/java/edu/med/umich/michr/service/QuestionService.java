package edu.med.umich.michr.service;

import edu.med.umich.michr.domain.Question;

import java.util.List;

public interface QuestionService {
  long saveQuestion(Question question);

  Question getQuestionById(long id);

  void updateQuestion(Question question);

  List<Question> getAllQuestions();

  void deleteQuestion(Question question);
}
