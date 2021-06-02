package javaJDBC;

import java.sql.*;

public class firstConnect {
    private static Connection con;
    private static Statement st;
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=demo2;"
            + "integratedSecurity=true";
    private static String USER_NAME = "oop";
    private static String PASSWORD = "123";

    public static void main(String[] args) {
        try {
            //Đăng ký Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            readData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n--------End Code--------");
    }

    private static void readData() {
        try {
            //Lấy chuỗi kết nối
            con= DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            //Lấy câu truy vẫn
            st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Thực thi câu truy vấn
            ResultSet rs= st.executeQuery("select * from Student");
            //in ra kq
           /* while (rs.next())
            {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3) + "\t"+ rs.getInt(3));
            }*/
            rs.absolute(3);
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
                    + "\t" + rs.getByte(3) + "\t"+ rs.getString(4)
                    + "\t"+ rs.getInt(5));
            st.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
