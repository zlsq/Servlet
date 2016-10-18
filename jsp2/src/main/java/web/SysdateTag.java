package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 自定义JSTL标签类，用来输出服务器时间。
 * 时间有默认的格式，也可以指定一个格式。
 */
public class SysdateTag extends SimpleTagSupport {

	//时间的格式，有默认值。
	//可以通过set方法修改其值。
	private String format = 
		"yyyy/MM/dd HH:mm:ss";
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//创建服务器时间
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat(format);
		String now = sdf.format(date);
		//将时间输出给浏览器
		//该方法声明返回JspContext，
		//该方法实际返回的是PageContext，
		//PageContext extends JspContext
		PageContext ctx = 
			(PageContext) getJspContext();
		JspWriter out = ctx.getOut();
		out.println(now);
		//此处的流不能关闭，因为JSP上还有
		//其他的标签要使用这个流。
	}

	
	
}











