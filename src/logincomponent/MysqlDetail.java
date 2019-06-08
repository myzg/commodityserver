package logincomponent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import logic.StructLanguage;

public class MysqlDetail extends Mysql implements StructLanguage{

	public MysqlDetail(HttpServletRequest request, ServletConfig config) {
		super(request, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Statement getStatement() {
		String sqlstatement = null;
		sqlstatement = getSqlStatement(request);
		if(sqlstatement != null) {
			 PreparedStatement functionstatement = null;
			 try {
				functionstatement = connection.prepareStatement(sqlstatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return functionstatement;
		}else {
			return null;
		}
	}

	@Override
	public Object execute() {
		statement = getStatement(); 
		return null;
	}

	@Override
	public String getSqlStatement(HttpServletRequest request) {
		if(request != null) {
			ServletContext context = null;
			String sqlstatement = null;
			String sqltype = null;
			sqltype = request.getParameter("sql_type");
	        context = request.getServletContext();
	        if(sqltype != null) {
	        	sqlstatement = getMessage(context,sqltype);
				return sqlstatement;
	        }
	        return null;
		}else {
			return null;
		}
	}
	
	private String getMessage(ServletContext context, String param) {
        String sqlstatement = null;
        sqlstatement = context.getInitParameter(param);
        if(sqlstatement != null) {
            return sqlstatement;
        }else {
            return null;
        }
    }
	
	private void setAttribute(Statement functionstatement, HttpServletRequest request) {
		PreparedStatement finalstatement = null;
		String sql_type = null;
		finalstatement = (PreparedStatement)functionstatement;
		sql_type = request.getParameter("sql_type");
		switch(sql_type) {
			
		}
	}


}




















