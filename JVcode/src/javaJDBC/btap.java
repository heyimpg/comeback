package javaJDBC;

import java.sql.*;

public class btap {
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
            //Lấy chuỗi kết nối
            con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            //Lấy câu truy vẫn
            st = con.createStatement();
/*Truy vấn*/
            //Tạo bảng
            if ( !queryExect("Create table Class(IDClass int primary key, NameClass nvarchar(10))"))
            {
                System.out.println("Tạo bảng Class thành công");
                if ( !queryExect("Create table Student(Msv int primary key," +
                        "Name nvarchar(50)," +
                        "Gender bit," +
                        "PhoneNumber char(5)," +
                        "IDClass int FOREIGN KEY REFERENCES Class(IDClass)" +
                        ")"))
                    System.out.println("Tạo bảng Student thành công");
                else
                    System.out.println("Tạo bảng Student thất bại");
            }
            else
                System.out.println("Tạo bảng Class thất bại");
            //Thêm data
            //Cho bảng Class
            if(queryExecuteUpdate("INSERT INTO Class VALUES(1,N'Văn')") !=0 && queryExecuteUpdate("INSERT INTO Class VALUES(2,N'Toán')") !=0)
                System.out.println("Thêm dữ liệu cho Class thành công");
            else
                System.out.println("Thêm dữ liệu cho Class thất bại");
            //Cho bảng Student
            if(queryExecuteUpdate("INSERT INTO Student VALUES(1,N'Ng Phương', 1, '245', 2)") !=0
                    && queryExecuteUpdate("INSERT INTO Student VALUES(2,N'Minh Lê', 1, '147', 2)") !=0
                    && queryExecuteUpdate("INSERT INTO Student VALUES(3,N'Huyền Lê', 0, '205', 1)") !=0
                    && queryExecuteUpdate("INSERT INTO Student VALUES(4,N'Kim Họa', 0, '205', 1)") !=0
                )
                System.out.println("Thêm dữ liệu cho Student thành công");
            else
                System.out.println("Thêm dữ liệu cho Student thất bại");
            //Join 2 bảng, in ra tt
            System.out.println("All Data:");
            querySelect("SELECT Msv, Name, Gender, phoneNumber, Class.IDClass, NameClass \n" +
                    "FROM Student inner join class on Student.IDClass = class.IDClass");
            //Xem những sinh viên nào học Toán
            System.out.println("Ds sinh viên lớp Toán");
            querySelect("SELECT Msv, Name, Gender, phoneNumber, Class.IDClass, NameClass \n" +
                    "FROM Student inner join class on Student.IDClass = class.IDClass\n" +
                    "WHERE NameClass=N'Toán'");
            //Sinh viên là nam giới
            System.out.println("Sinh viên là nam giới: ");
            querySelect("SELECT * FROM Student WHERE Gender = 1");
            //Thêm 1 sinh viên mới
            if (queryExecuteUpdate("INSERT INTO Student VALUES(5,N'Trần Hòa', 1, '369', 2)") !=0)
                System.out.println("Đã thêm 1 sinh viên mới");
            else
                System.out.println("Thêm sinh viên thất bại");
            //Sửa SDT của sinh viên có msv = 3
            if(queryExecuteUpdate("UPDATE Student SET phoneNumber='789' WHERE Msv= 3")!=0)
                System.out.println("Sửa SDT thành công");
            else
                System.out.println("Sửa SDT thất bại");
            //Xóa sinh viên mới thêm
            if(queryExecuteUpdate("DELETE FROM Student WHERE Msv = 5")!=0)
                System.out.println("Đã xóa sinh viên có msv = 5 thành công");
            else
                System.out.println("Sinh viên có MSV = 5 không tồn tại");

            closeConnect();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("\n\n\n--------End Code--------");
    }

    private static void closeConnect() {
        try {
            st.close();
            con.close();
            System.out.println("Đã đóng kết nối");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static boolean queryExect(String sql) {
        try {
            return st.execute(sql);
        } catch (SQLException throwables) {
           return  true;
        }
    }

    private static int queryExecuteUpdate(String sql) {
        try {
            return st.executeUpdate(sql);
        } catch (SQLException throwables) {
           return  0;
        }

    }
    //Show Data
    private static void querySelect(String sql) {
        try {
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmt = rs.getMetaData();

            for (int i=1;i<=rsmt.getColumnCount(); i++)
            {
                System.out.print( rsmt.getColumnName(i)+"\t");
            }
            System.out.println();

            for (int i=1;i<=rsmt.getColumnCount(); i++)
            {
                System.out.print( rsmt.getColumnTypeName(i)+"\t");
            }
            System.out.println();

            while (rs.next())
            {
                for (int i=1;i<=rsmt.getColumnCount(); i++)
                    System.out.print(rs.getString(i)+"\t");
                System.out.println();
            }
            System.out.println("--------------------------------");

            rs.close();
        } catch (SQLException throwables) {
            System.out.println("Truy vấn dữ liệu thất bại");
        }
    }
}
