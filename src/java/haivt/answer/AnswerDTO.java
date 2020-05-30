/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.answer;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class AnswerDTO implements Serializable{
    private int answerId;
    private int questionId;
    private String answerContent;
    private String answerChoice;

    public AnswerDTO() {
    }

    public AnswerDTO(int answerId, int questionId, String answerContent, String answerChoice) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answerContent = answerContent;
        this.answerChoice = answerChoice;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerChoice() {
        return answerChoice;
    }

    public void setAnswerChoice(String answerChoice) {
        this.answerChoice = answerChoice;
    }
    
}
