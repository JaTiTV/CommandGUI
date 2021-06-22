package de.jatitv.commandguiv2.system.database;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.send;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;

public class MySQL {
    public static String ip = "localhost";
    public static Integer port = 3306;
    public static String database;
    public static String user = "root";
    public static String password = "";
    public static String url;
    public static Boolean SSL;

    public static void main(){
        Long long_ = Long.valueOf(System.currentTimeMillis());
        Calendar now = Calendar.getInstance();
        ZoneId timeZone = now.getTimeZone().toZoneId();
        send.debug("Server TimeZone is : " + timeZone);
        url = "jdbc:mysql://" + ip + ":" + port + "/" + database + "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone="+ timeZone;
        // Europe/Berlin
        if(SSL){
            url = url + "&useSSL=true";
        } else url = url + "&useSSL=false";
        send.debug(url);
        try(Connection con = DriverManager.getConnection(url,user, password)){
            Statement stmt = con.createStatement();
            stmt.close();
            send.console(Main.Prefix + " §2MySQL successfully connected." + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
        }catch(SQLException ex){
            send.console(Main.Prefix + " §4MySQL not connected." + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
            System.err.println(ex.getMessage() + " --- " + (System.currentTimeMillis() - long_.longValue()) + "ms");
        }
    }

public static void query(String query){
    try(Connection con = DriverManager.getConnection(url,user, password)){
        Statement stmt = con.createStatement();
        stmt.execute(query);
        stmt.close();
    }catch(SQLException ex){
        System.err.println(ex.getMessage());
    }
}


    public static ArrayList<String> selectAll(String query){
        ArrayList<String> Result = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,user, password)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next()) {
                Result.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return Result;
    }

    public static String select(String query){
        String Ausgabe = "";
        try(Connection con = DriverManager.getConnection(url,user, password)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next()) {
                Ausgabe = String.valueOf(rs.getString(1));
            }
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return Ausgabe;
    }

    public static int count(String query) {
        Integer count = 0;
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
              count++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return count;
    }
}

