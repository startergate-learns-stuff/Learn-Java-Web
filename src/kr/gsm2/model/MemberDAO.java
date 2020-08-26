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
                MemberVO vo = new MemberVO(bun, name, tel, email, addr);
                list.add(vo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
