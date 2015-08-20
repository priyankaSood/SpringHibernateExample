package main.java.com.journaldev.util;

import java.sql.Connection;

public interface DBUtil {
	 void createTable() throws Exception;
	Connection getConnection() throws Exception;
	
}
