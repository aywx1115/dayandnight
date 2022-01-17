package org.dayandnight.repository;

import org.dayandnight.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {
    static final String DBURL ="jdbc:postgresql://localhost:5431/dayandnight";
    static final String USER = "admin";
    static final String PASS = "password";
    private Logger logger = LoggerFactory.getLogger(getClass());
    public List<Menu> getMenus(){
            List<Menu> menus = new ArrayList();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                //STEP 2: Open a connection
                logger.debug("open connection...");
                conn = DriverManager.getConnection(DBURL, USER, PASS);

                //STEP 3: Execute a query
                logger.info("create statement...");
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT * FROM menus";
                rs = stmt.executeQuery(sql);

                //STEP 4: Extract data from result set
                while(rs.next()) {
                    //Retrieve by column name
                    Long id  = rs.getLong("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");

                    //Fill the object
                    Menu menu = new Menu();
                    menu.setId(id);
                    menu.setName(name);
                    menu.setDescription(description);
                    menus.add(menu);
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            finally {
                //STEP 6: finally block used to close resources
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(conn != null) conn.close();
                }
                catch(SQLException se) {
                    se.printStackTrace();
                }
            }

            return menus;
    }
    public static void main(String[] args){
        MenuDao menuJDBCDDao=new MenuDao();
        System.out.println(menuJDBCDDao.getMenus());
    }
}
