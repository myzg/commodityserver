package logic;

import javax.servlet.http.HttpServletRequest;

public interface StructLanguage {
	public String getSqlStatement(HttpServletRequest request);
}
