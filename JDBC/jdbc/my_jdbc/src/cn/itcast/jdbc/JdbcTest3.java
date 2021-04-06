package cn.itcast.jdbc;

import cn.itcast.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * �������
 */
public class JdbcTest3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            //1.��ȡ����
            conn = JdbcUtils.getConnection();
            //��������
            conn.setAutoCommit(false);
            //2.����sql
            //2.1 ���� - 500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2 ���� + 500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3.��ȡִ��sql����
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4.���ò���
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);

            //5.ִ��sql
            pstmt1.executeUpdate();

            //�ֶ������쳣
            int i = 3/0;

            pstmt2.executeUpdate();
            //�ύ����
            conn.commit();

        } catch (Exception e) {
            try {
                if(conn!=null) {
                    //����Ļع�
                    conn.rollback();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt1,conn);
            JdbcUtils.close(pstmt2,null);
        }


    }
}
