package kr.gsm2.model;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String user = "hr";
        String password = "hr";
        try {
            conn = DriverManager.getConnection(URL, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public int insert(MemberVO vo) {
        conn = getConnection();
        String SQL = "INSERT INTO TBLMEM2 VALUES (SEQ_NUM.nextval, ?, ?, ?, ?, ?)";
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, vo.getBun());
            ps.setString(2, vo.getName());
            ps.setString(3, vo.getTel());
            ps.setString(4, vo.getEmail());
            ps.setString(5, vo.getAddr());
            cnt = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    public ArrayList<MemberVO> list() {
        ArrayList<MemberVO> list = new ArrayList<>();
        conn = getConnection();

        String SQL = "SELECT * FROM TBLMEM2 ORDER BY NUM DESC";

        try {
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("num");
                int bun = rs.getInt("bun");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String addr = rs.getString("addr");
                MemberVO vo = new MemberVO(num, bun, name, tel, email, addr);
                list.add(vo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public int delete(int num) {
        conn = getConnection();

        String SQL = "DELETE FROM TBLMEM2 WHERE NUM = ?";

        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, num);
            cnt = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }

    public MemberVO content(int num) {
        conn = getConnection();
        String SQL = "SELECT * FROM TBLMEM2 WHERE NUM = ?";
        MemberVO vo = null;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            if (rs.next()) {
                num = rs.getInt("num");
                int bun = rs.getInt("bun");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String addr = rs.getString("addr");
                vo = new MemberVO(num, bun, name, tel, email, addr);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vo;
    }

    public int update(MemberVO vo) {
        conn = getConnection();
        String SQL = "UPDATE TBLMEM2 SET TEL=?, EMAIL=?, ADDR=? WHERE NUM=?";
        int count = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, vo.getTel());
            ps.setString(2, vo.getEmail());
            ps.setString(3, vo.getAddr());
            ps.setInt(4, vo.getNum());
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
