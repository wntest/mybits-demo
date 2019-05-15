package jdbctest;

import java.sql.*;

/**
 * 回顾JDBC基础代码
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 建立连接
            String url = "jdbc:mysql://127.0.0.1:3306/ssmdemo";
            String username = "root";
            String password = "1";
            conn = DriverManager.getConnection(url, username, password);
            // 获取prepareddstatement
            String sql = "select * from tb_user where id=?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1,"1");
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果集
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id"));
                System.out.println("username: " + rs.getString("user_name"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println("birthday: " + rs.getString("birthday"));
                System.out.println("age: " + rs.getString("age"));
                System.out.println("created: " + rs.getString("created"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
