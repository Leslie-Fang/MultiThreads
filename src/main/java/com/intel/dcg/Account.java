package com.intel.dcg;

import java.sql.*;

public class Account {
    private String accountName;
    private int balance;
    private DBConfig dbConfig;

    Account(){
        this.balance = 0;
    }
    Account(String accountName,int balance){
        this.balance = balance;
        this.accountName = accountName;
    }
    Account(String accountName,int balance,DBConfig dbConfig){
        this.balance = balance;
        this.accountName = accountName;
        this.dbConfig = dbConfig;
    }
    synchronized int add(){
        return ++balance;
    }
    synchronized int getAccount(){
        return this.balance;
    }
    synchronized boolean drawMoney(int number){
        if(number<=this.balance){
            this.balance -= number;
            return true;
        }else{
            return false;
        }
    }
    public String getAccountName(){
        return this.accountName;
    }
    public void drawMoneyFromDB(int number){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(this.dbConfig.getUrl(), this.dbConfig.getName(), this.dbConfig.getPassword());
            conn.setAutoCommit(false);
            try(PreparedStatement ps = conn.prepareStatement( "update userAccount SET balance = balance + ? where name = ?" ))
            {
                ps.setInt(1, number);
                ps.setString(2, this.accountName);
                ps.executeUpdate();
            }
            conn.commit();
            conn.close();

        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void lookupBalance(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(this.dbConfig.getUrl(), this.dbConfig.getName(), this.dbConfig.getPassword());
            conn.setAutoCommit(false);
            try(PreparedStatement ps = conn.prepareStatement( "select balance from userAccount where name = ?" ))
            {
                ps.setString(1, this.accountName);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    System.out.println(this.accountName+"'s bank balance is: "+rs.getInt(1));
                }
            }
            conn.commit();
            conn.close();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
//    public void transferMoney(String buyer){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(this.dbConfig.getUrl(), this.dbConfig.getName(), this.dbConfig.getPassword());
//            conn.setAutoCommit(false);
//            try(PreparedStatement ps = conn.prepareStatement( "select balance from userAccount where name = ?" ))
//            {
//                ps.setString(1, name);
//                ResultSet rs = ps.executeQuery();
//                while(rs.next()){
//                    System.out.println(name+"'s bank balance is: "+rs.getInt(1));
//                }
//            }
//            conn.commit();
//            conn.close();
//        }catch(ClassNotFoundException ex){
//            ex.printStackTrace();
//        }catch(SQLException ex){
//            ex.printStackTrace();
//        }
//    }
}
