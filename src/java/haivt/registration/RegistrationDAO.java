/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.registration;

import haivt.model.Account;
import haivt.role.RoleDAO;
import haivt.utils.DBUtil;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class RegistrationDAO implements Serializable {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account checkLogin(String email, String password) throws SQLException, ClassNotFoundException, NamingException {
        Account account =  new Account();
        String roleName = "";

        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "Select a.email, a.name, a.password, r.roleName From account a, role r Where email = ? And password = ? and status = 1 and a.role = r.roleId;";

                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);

                rs = ps.executeQuery();
                if (rs.next()) {
                   account.setEmail(rs.getString("email"));
                 account.setPassword(rs.getString("password"));
                 account.setName(rs.getString("name"));
                 account.setRole(rs.getString("roleName"));
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
        return account;
    }

    public boolean createAccount(String email, String name, String password) throws SQLException, NamingException, NoSuchAlgorithmException {

        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "Insert into account(email, name, password, role, status)"
                        + " Values(?,?,?,2,2)";

                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, name);
                ps.setString(3, password);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps!= null)//Prepare
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
}
