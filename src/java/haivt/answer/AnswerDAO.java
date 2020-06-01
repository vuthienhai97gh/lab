/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.answer;

import haivt.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
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
      public boolean createAnswer(int questionId, String answerA, String answerB, String answerC, String answerD) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement psA = null, psB = null, psC = null, psD = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sqlA = "insert into answer(answer_content, questionId, answer_choice) values (?,?,A)";
                String sqlB = "insert into answer(answer_content, questionId, answer_choice) values (?,?,B)";
                String sqlC = "insert into answer(answer_content, questionId, answer_choice) values (?,?,C)";
                String sqlD = "insert into answer(answer_content, questionId, answer_choice) values (?,?,D)";
                con.setAutoCommit(false);
                psA = con.prepareStatement(sqlA);
                psA.setString(1, answerA);
                psA.setInt(2, questionId);
                psB = con.prepareStatement(sqlB);
                psB.setString(1, answerB);
                psB.setInt(2, questionId);
                psC = con.prepareStatement(sqlC);
                psC.setString(1, answerC);
                psC.setInt(2, questionId);
                psD = con.prepareStatement(sqlD);
                psD.setString(1, answerD);
                psD.setInt(2, questionId);
                int rowA = psA.executeUpdate();
                int rowB = psB.executeUpdate();
                int rowC = psC.executeUpdate();
                int rowD = psD.executeUpdate();
                if(rowA > 0 && rowB > 0 && rowC > 0 && rowD > 0){
                    return true;
                }
            }
        } finally {//tạo sau đóng trc
            if (rs != null)//Result
            {
                rs.close();
            }
            if (psA != null)//Prepare
            {
                psA.close();
            }
            if (psB != null)//Prepare
            {
                psB.close();
            }
            if (psC != null)//Prepare
            {
                psC.close();
            }
            if (psD != null)//Prepare
            {
                psD.close();
            }
            if (con != null)//Connect
            {
                con.close();
            }
        }
        return false;
    }
}
