package kr.gsm2.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberMyBatisDAO {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public List<MemberVO> memberList() {
        SqlSession session = sqlSessionFactory.openSession();
        List<MemberVO> list = session.selectList("memberList");
        session.close();
        return list;
    }

    public int memberInsert(MemberVO vo) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("memberInsert", vo);
        session.commit();
        session.close();
        return cnt;
    }

    public int memberDelete(int num) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.delete("memberDelete", num);
        session.commit();
        session.close();
        return cnt;
    }

    public MemberVO memberContent(int num) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberVO vo = session.selectOne("memberContent", num);
        session.close();
        return vo;
    }

    public int memberUpdate(MemberVO vo) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.update("memberUpdate", vo);
        session.commit();
        session.close();
        return cnt;
    }
}
