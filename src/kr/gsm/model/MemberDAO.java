package kr.gsm.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Connection createConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
            String user = "hr";
            String password = "hr";
            conn = DriverManager.getConnection(URL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int insert(MemberVO member) {
        conn = createConnection();
        String SQL = "INSERT INTO TBLMEM VALUES(?, ?, ?)";
        int cnt = 0;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, member.getId());
            ps.setString(2, member.getPwd());
            ps.setInt(3, member.getAge());
            cnt = ps.executeUpdate();
            return cnt;
        } catch (Exception e) {
            return 0;
        } finally {
            closeConnection();
        }

    }

    public int update(MemberVO member) {
        conn = createConnection();
        String SQL = "UPDATE TBLMEM SET PWD=?, AGE=? WHERE ID=?";
        int cnt = 0;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, member.getPwd());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getId());
            cnt = ps.executeUpdate();
            return cnt;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeConnection();
        }
    }

    public int delete(String id) {
        conn = createConnection();
        String SQL = "DELETE FROM TBLMEM WHERE ID=?";
        int cnt = 0;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, id);
            cnt = ps.executeUpdate();
            return cnt;
        } catch (Exception e) {
            return 0;
        } finally {
            closeConnection();
        }
    }

    public List<MemberVO> getAllList() {
        conn = createConnection();
        List<MemberVO> list = new ArrayList<>();

        String SQL = "SELECT * FROM TBLMEM ORDER BY AGE DESC";

        try {
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                int age = rs.getInt("age");
                MemberVO member = new MemberVO(id, pwd, age);
                list.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public MemberVO getById(String _id) {
        conn = createConnection();
        String SQL = "SELECT * FROM TBLMEM WHERE ID = ?";
        MemberVO member = null;

        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, _id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                int age = rs.getInt("age");
                member = new MemberVO(id, pwd, age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection();
        }
        return member;
    }

    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ignored) {

        }
    }
}
