
package dbHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Badminton;

/**
 *
 * @author Drake
 */
public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery()  {
        
        Properties props = new Properties(); //MWC
    InputStream instr =getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void doUpdate(Badminton member) {
        
        try {
            String query = "UPDATE badminton SET officialname = ?, prefername = ?, email = ?, phonenumber = ? WHERE memberid = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, member.getOfficial_Name());
            ps.setString(2, member.getPrefer_Name());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getPhone_Number());
            ps.setInt(5, member.getMember_ID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
