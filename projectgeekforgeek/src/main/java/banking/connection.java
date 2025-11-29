package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
    // Biến static để giữ kết nối duy nhất
    private static Connection conn = null;

    /**
     * Phương thức static để lấy/thiết lập kết nối DB (Singleton pattern đơn giản).
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Thiết lập kết nối SQLite
                String url = "jdbc:sqlite:bank.db";
                conn = DriverManager.getConnection(url);
                System.out.println("Kết nối đến SQLite đã được thiết lập.");
            } catch (SQLException e) {
                System.out.println("Lỗi kết nối DB: " + e.getMessage());
                // Thoát chương trình nếu không kết nối được
                System.exit(1);
            }
        }
        return conn;
    }

    /**
     * Phương thức static để tạo bảng customer (Đã sửa lỗi cú pháp SQL cho SQLite).
     */
    public static void createTables() {
        // Cú pháp SQL ĐÃ SỬA cho SQLite: 
        // 1. Sử dụng INTEGER PRIMARY KEY AUTOINCREMENT.
        // 2. Sử dụng TEXT thay cho VARCHAR/CHAR, INTEGER thay cho INT.
        // 3. Thêm IF NOT EXISTS để tránh lỗi khi chạy lại.
        String sqlKhachHang = "CREATE TABLE IF NOT EXISTS customer ("
                + "ac_no INTEGER PRIMARY KEY AUTOINCREMENT," // Khóa chính tự động tăng chuẩn SQLite
                + "cname TEXT UNIQUE NOT NULL,"              
                + "balance INTEGER DEFAULT 1000,"            
                + "pass_code INTEGER NOT NULL"
                + ");";

        try {
            Connection currentConn = getConnection();
            try (Statement stmt = currentConn.createStatement()) {
                stmt.execute(sqlKhachHang);
                System.out.println("Các bảng đã được tạo thành công.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tạo bảng: " + e.getMessage());
        }
    }
}