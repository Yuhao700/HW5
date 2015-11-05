
package dbHelper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Badminton;

public class ReadRecord {
     
    private Connection conn;
    private ResultSet results;
    private Badminton member = new Badminton();
    private int memberID;
    
    public ReadRecord (int memberID){
    Properties props = new Properties(); //MWC
    InputStream instr =getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
       
    this.memberID = memberID;
    
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    public void doRead() {
    
        try {
            String query = "SELECT * FROM badminton WHERE memberID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, memberID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            member.setMember_ID(this.results.getInt("memberID"));
            member.setOfficial_Name(this.results.getString("officialname"));
            member.setPrefer_Name(this.results.getString("prefername"));
            member.setEmail(this.results.getString("email"));
            member.setPhone_Number(this.results.getString("phonenumber"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
        
        

}
    
    public Badminton getMember(){
    
            return this.member;
    
    }
}
