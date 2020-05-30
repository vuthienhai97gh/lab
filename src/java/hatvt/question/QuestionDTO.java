/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hatvt.question;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vuthi
 */
public class QuestionDTO implements Serializable{
    private int id;
    private String question_content;
    private String answer_correct;
    private Date createDate;
    private int subjectId;
    private int status;
    private String statusName;
    public QuestionDTO() {
    }

    public QuestionDTO(int id, String question_content, String answer_correct, Date createDate, int subjectId, int status, String statusName) {
        this.id = id;
        this.question_content = question_content;
        this.answer_correct = answer_correct;
        this.createDate = createDate;
        this.subjectId = subjectId;
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public String getAnswer_correct() {
        return answer_correct;
    }

    public void setAnswer_correct(String answer_correct) {
        this.answer_correct = answer_correct;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
