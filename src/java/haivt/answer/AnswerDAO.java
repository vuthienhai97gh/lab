/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.answer;

import haivt.utils.DBUtil;
import hatvt.question.QuestionDTO;
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
public class AnswerDAO implements Serializable{
     public ArrayList<AnswerDTO> getAnswerByQuestionId(int questionId) throws SQLException, NamingException{
        ArrayList<AnswerDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "select answerId,answer_content, answer_choice from answer where questionId = ? order by answer_choice asc";
                ps = con.prepareStatement(sql);
                ps.setInt(1, questionId);
                rs = ps.executeQuery();
                while(rs.next()){
                AnswerDTO answer = new AnswerDTO();
                answer.setAnswerId(rs.getInt("answerId"));
                answer.setAnswerContent(rs.getString("answer_content"));
                answer.setAnswerChoice(rs.getString("answer_choice"));
                list.add(answer);
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
