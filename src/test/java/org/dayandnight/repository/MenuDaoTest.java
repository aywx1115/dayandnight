package org.dayandnight.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuDaoTest {
    private MenuDao menuJDBCDao;
    @Before
    public void setUp(){
        menuJDBCDao = new MenuDao();
    }
    @After
    public void tearDown(){
        menuJDBCDao = null;
    }
    @Test
    public void getMenusTest(){
        MenuDao menuJDBCDDao=new MenuDao();
        assertEquals(4, menuJDBCDDao.getMenus().size());
    }
}
