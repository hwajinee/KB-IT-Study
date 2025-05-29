package dao;

import common.JDBCUtil;
import domain.UserVO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

class UserDaoTest {
    UserDao dao = new UserDaoImpl();

    @AfterAll
    static void tearDown(){
        JDBCUtil.close();
    }
    @Test
    @DisplayName("user 등록.")
    @Order(1)
    void create() throws SQLException {
        UserVO user = new UserVO("ssamz3", "ssamz123", "쌤즈", "ADMIN");
        int count  = dao.create(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("UserDao User 목록 추출.")
    @Order(2)
    void getList() throws SQLException {
        List<UserVO> list = dao.getList();
        for(UserVO vo : list) {
            System.out.println(vo);
        }
    }

    @Test
    @DisplayName("특정 user 1건 추출.")
    @Order(3)
    void get() throws SQLException {
        UserVO user = dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("user 정보 수정.")
    @Order(4)
    void update() throws SQLException {
        UserVO user = dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        user.setName("쌤즈3");

        int count = dao.update(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("user 삭제.")
    @Order(5)
    void delete() throws SQLException {
        int count = dao.delete("ssamz3");
        Assertions.assertEquals(1, count);
    }
}