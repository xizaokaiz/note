package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account�� ɾ��һ����¼
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2.��ȡ���Ӷ���
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","123456");
            //3.����sql
            String sql = "delete from account where id = 3";
            //4.��ȡִ��sql����
            stmt = conn.createStatement();
            //5.ִ��sql
            int count = stmt.executeUpdate(sql);
            //6.������
            System.out.println(count);
            if(count>0){
                System.out.println("ɾ���ɹ�");
            }else{
                System.out.println("ɾ��ʧ��");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            //�ͷ���Դ
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
