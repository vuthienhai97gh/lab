/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.role;

import haivt.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author vuthi
 */
public class RoleDAO implements Serializable{
    public String getRoleName(int roleId) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String roleName = "" ;
        try {
            con = DBUtil.makeConnection();

            if (con != null) {
                String sql = "Select roleName From role Where roleId = ?";

                ps = con.prepareStatement(sql);
                ps.setInt(1, roleId);

                rs = ps.executeQuery();
                if (rs.next()) {
                     roleName = rs.getString("roleName");
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
        return roleName;
    }
}
