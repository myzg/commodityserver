package logincomponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import interfaces.DataBase;

public abstract class Mysql implements DataBase {
	protected Connection connection;
    protected Statement statement;
    private ServletConfig config;
    protected HttpServletRequest request;
    
    public Mysql(HttpServletRequest request, ServletConfig config) {
    	this.request = request;
    	this.config = config;
    }
	
	/**
	 * @author myzg
	 * @param  
	 **/
	@Override
	public Object getserver(HttpServletRequest request) {
		getLink();
		getStatement();
		execute();
		close();
		return null;
	}

	@Override
	public Connection getLink() {
		if(config != null) {
	           try {
	               Class.forName(config.getInitParameter("mysql_driver"));
	               Properties props = new Properties();
	               Enumeration<String> parameternames= config.getInitParameterNames();
	               while (parameternames.hasMoreElements()) {
	                   String oneparameter = null;
	                   oneparameter = parameternames.nextElement();
	                   if(oneparameter != null && !oneparameter.equals("mysql_driver") && !oneparameter.equals("url")) {
	                       props.setProperty(oneparameter,config.getInitParameter(oneparameter));
	                   }
	               }
	               connection = DriverManager.getConnection(config.getInitParameter("url"),props);
	           } catch (ClassNotFoundException e) {
	               e.printStackTrace();
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	           if(connection != null) {
	               return connection;
	           }else {
	               return null;
	           }
	       }else {
	           return null;
	       }
	}

	@Override
	public abstract Statement getStatement();

	@Override
	public abstract Object execute();
	
	@Override
	public void close() {
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}else if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
