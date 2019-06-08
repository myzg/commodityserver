package interfaces;

import java.sql.Connection;
import java.sql.Statement;

public interface DataBase extends Server {
	/**
	 * @author xhkj
	 * 此接口实现的是数据库操作，分别为：连接，得到具柄，具体操作，关闭资源
	 * **/
	public Connection getLink();
    public Statement getStatement();
    public Object execute();
    public void close();
}
