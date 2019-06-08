package interfaces;

import javax.servlet.http.HttpServletRequest;

public interface Server {
	/**
	 * @author myzg
	 * @param  需要请求来开始服务
	 * */
	public Object getserver(HttpServletRequest request);
}
