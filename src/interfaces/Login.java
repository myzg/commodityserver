package interfaces;

public interface Login extends Server {
	
	/**
	 * @author xhkj
	 * 本接口实现的登陆操作，需要得到用户名和id 然后给出功能权限
	 * */
	
	public String getName();
	
	public String getPassword();
	
	public Object getLimit();
}
