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
    public ArrayList<QuestionDTO> getListQuestion(int subjectId) throws SQLException, NamingException{
        ArrayList<QuestionDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "select questionId, question_content, answer_correct, createDate, questionStatus from question where subjectId = ? and questionStatus = 1";
                ps = con.prepareStatement(sql);
                ps.setInt(1, subjectId);
                rs = ps.executeQuery();
                while(rs.next()){
                int id = rs.getInt("questionId");
                String question_content = rs.getString("question_content");
                String answer_correct = rs.getString("answer_correct");
                int questionStatus = rs.getInt("questionStatus");
                Date createDate = rs.getDate("createDate");
                QuestionDTO questionDTO = new QuestionDTO(id, question_content, answer_correct, createDate, subjectId, questionStatus);
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
} 
