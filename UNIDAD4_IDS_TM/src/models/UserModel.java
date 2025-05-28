package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class UserModel {

    public ArrayList<Users> get() {
        ArrayList<Users> lista = new ArrayList<>();
        String query = "SELECT * FROM users";
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String role = rs.getString(4);
                String phone = rs.getString(5);
                Date fecha = rs.getDate(6);

                lista.add(new Users(id, name, email, role, phone, fecha));

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
    public boolean add(String name, String email, String role)
	{
		String query = "INSERT INTO `users` (`id`, `name`, `email`, `role`, `phone`, `create_at`, `update_at`) VALUES (NULL, '"+name+"', '"+email+"', '"+role+"', NULL, NULL, NULL);";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
    public boolean update(Users users) {
        String query = "UPDATE `users` SET "
                     + "`name` = '" + users.getName() + "', "
                     + "`email` = '" + users.getEmail() + "', "
                     + "`role` = '" + users.getRole() + "', "
                     + "`phone` = '" + users.getPhone() + "', "
                     + "`update_at` = NOW() "
                     + "WHERE `users`.`id` = " + users.getId() + ";";
                     
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            stmt = conn.createStatement();
            
            int rs = stmt.executeUpdate(query);
            
            if (rs > 0) 
                return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return false;
    }

    
}
