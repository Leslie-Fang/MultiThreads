package com.intel.dcg;

import java.sql.*;

public class TradeHistory {
    private DBConfig dbConfig;
    TradeHistory(DBConfig dbConfig){
        this.dbConfig = dbConfig;
    }
    public void insertHistory(int number,String buyer,String seller){
        int id1,id2;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(this.dbConfig.getUrl(), this.dbConfig.getName(), this.dbConfig.getPassword());
            conn.setAutoCommit(false);
            try(PreparedStatement ps = conn.prepareStatement( "select ID from userAccount where name = ? " );
                PreparedStatement ps2 = conn.prepareStatement( "insert into userTradeHistory(buyerID,sellerID,amount) values(?,?,?) " ))
            {
                ps.setString(1, buyer);
                ResultSet rs = ps.executeQuery();
                rs.next();
                System.out.println(buyer+"'s ID is: "+rs.getInt(1));
                id1 = rs.getInt(1);

                ps.setString(1, seller);
                rs = ps.executeQuery();
                rs.next();
                System.out.println(seller+"'s ID is: "+rs.getInt(1));
                id2 = rs.getInt(1);
                ps2.setInt(1,id1);
                ps2.setInt(2,id2);
                ps2.setInt(3,number);
                ps2.executeUpdate();
            }
            conn.commit();
            conn.close();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void insertHistory(int number,String name){
        int id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(this.dbConfig.getUrl(), this.dbConfig.getName(), this.dbConfig.getPassword());
            conn.setAutoCommit(false);
            try(PreparedStatement ps = conn.prepareStatement( "select ID from userAccount where name = ? " );
                PreparedStatement ps2 = conn.prepareStatement( "insert into userTradeHistory(buyerID,amount) values(?,?) " ))
            {
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                rs.next();
                System.out.println(name+"'s ID is: "+rs.getInt(1));
                id = rs.getInt(1);
                ps2.setInt(1,id);
                ps2.setInt(2,number);
                ps2.executeUpdate();
            }
            conn.commit();
            conn.close();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
