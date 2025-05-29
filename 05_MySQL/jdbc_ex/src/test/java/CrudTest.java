import common.JDBCUtil;
import org.junit.jupiter.api.*;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDowm() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "INSERT INTO users(id, password, name, role) VALUES(?, ?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate(); // SQL문 실행으로 영향을 받은 레코드 수를 반환하는 메서드
            Assertions.assertEquals(1, count); // 1개의 행이 올바르게 삽입되었느지 확인.
        }
    }

    @Test
    @DisplayName("user 목록을 추출한다.")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "SELECT * FROM users";
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);)
            {
                while(rs.next()) {
                    System.out.println(rs.getString("name")); // name만 출력
                }
            }
        }
    @Test
    @DisplayName("특정 user를 검색한다.")
    @Order(3)
    public void selectUserById() throws SQLException
    {
        String userid = "scoula";
        String sql = "SELECT * FROM users WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user를 수정한다.")
    @Order(4)
    public void updateUser() throws SQLException
    {
        String userid = "scoula";
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "스콜라 name 수정");
            pstmt.setString(2, userid);

            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql = "DELETE FROM users WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userid);

            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}