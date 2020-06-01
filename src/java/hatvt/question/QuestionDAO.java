/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hatvt.question;

import haivt.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class QuestionDAO implements Serializable{
    public ArrayList<QuestionDTO> getListQuestion(int subjectId, int status, String searchValue) throws SQLException, NamingException{
        ArrayList<QuestionDTO> list = new ArrayList<>();
        if(searchValue ==null){
            searchValue = "";
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                if(subjectId == 0 && status == 0){
                    String sql = "select q.questionId, q.question_content, q.answer_correct, q.createDate, q.questionStatus, s.name from question q, status s where s.id = q.questionStatus and question_content like ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + searchValue + "%");
                }else if(subjectId !=0 && status == 0){
                    String sql = "select q.questionId, q.question_content, q.answer_correct, q.createDate, q.questionStatus, s.name from question q, status s where s.id = q.questionStatus and subjectId = ? and question_content like ?";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, subjectId);
                    ps.setString(2, "%" + searchValue + "%");
                }else if(subjectId ==0 && status != 0){
                     String sql = "select q.questionId, q.question_content, q.answer_correct, q.createDate, q.questionStatus, s.name from question q, status s where s.id = q.questionStatus and questionStatus = ? and question_content like ?";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, status);
                    ps.setString(2, "%" + searchValue + "%");
                }else{
                    String sql = "select q.questionId, q.question_content, q.answer_correct, q.createDate, q.questionStatus, s.name from question q, status s where s.id = q.questionStatus and questionStatus = ? and subjectId = ? and question_content like ?";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, status);
                    ps.setInt(2, subjectId);
                    ps.setString(3, "%" + searchValue + "%");
                }
                //ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                int id = rs.getInt("questionId");
                String question_content = rs.getString("question_content");
                String answer_correct = rs.getString("answer_correct");
                int questionStatus = rs.getInt("questionStatus");
                String statusName = rs.getString("name");
                Date createDate = rs.getDate("createDate");
                QuestionDTO questionDTO = new QuestionDTO(id, question_content, answer_correct, createDate, subjectId, questionStatus, statusName);
                list.add(questionDTO);
            }
            }
        } finally {//tạo sau đóng trc
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return list;
    }
    public boolean UpdateQuestion(String questionContent, String answerCorrect, int questionId) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "update question set question_content = ? , answer_correct = ? where questionId = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, questionContent);
                ps.setString(2, answerCorrect);
                ps.setInt(3, questionId);
                int row = ps.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {//tạo sau đóng trc
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return false;
    }
    public boolean UpdateAnswer(String answer, int questionId, String answerChoice) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                 con.setAutoCommit(false);
                String sql =  "update answer set answer_content = ? where answer_choice = ? and questionId = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, answer);
                ps.setString(2, answerChoice);
                ps.setInt(3, questionId);
                int row = ps.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {//tạo sau đóng trc
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
           
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return false;
    }
      public boolean deleteQuestion(int questionId) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "update question set questionStatus = 2 where questionId = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, questionId);
                int row = ps.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {//tạo sau đóng trc
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return false;
    }
      public boolean createQuestion(String questionContent, String answerCorrect, int subjectId, int questionStatus) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "insert into question(question_content, answer_correct, createDate, subjectId, questionStatus) values (?, ?, GETDATE() , ?, ? )";
                ps = con.prepareStatement(sql);
                ps.setString(1, questionContent);
                ps.setString(2, answerCorrect);
                ps.setInt(3, subjectId);
                ps.setInt(4, questionStatus);
                int row = ps.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {//tạo sau đóng trc
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return false;
    }
     public QuestionDTO getQuestionByQuestionContent(String questionContent) throws SQLException, NamingException{
          Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
         QuestionDTO qdto = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "select questionId, question_content, answer_correct, createDate, subjectId, questionStatus from question where question_content = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, questionContent);
                rs = ps.executeQuery();
                if(rs.next()){
                    qdto = new QuestionDTO();
                    qdto.setId(rs.getInt("questionId"));
                    qdto.setQuestion_content("question_content");
                    qdto.setAnswer_correct(rs.getString("answer_correct"));
                    qdto.setCreateDate(rs.getDate("createDate"));
                    qdto.setSubjectId(rs.getInt("subjectId"));
                    qdto.setStatus(rs.getInt("questionStatus"));
                }
            }
        } finally {//tạo sau đóng trc
            if (rs != null)//Result
            {
                rs.close();
            }
            if (ps != null)//Prepare
            {
                ps.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return qdto;
     }
} 
