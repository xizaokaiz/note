# Http补充
	1. 请求消息：客户端发送给服务器端数据
		* 数据格式：
			1. 请求行
			2. 请求头
			3. 请求空行
			4. 请求体
	2. 响应消息：服务器端发送给客户端的数据
		* 数据格式：
			1. 响应行
				1. 组成：协议/版本 响应状态码 状态码描述
				2. 响应状态码：服务器告诉客户端浏览器本次请求和响应的一个状态
					1. 状态码都是3位数字
					2. 分类：
						1. 1xx：服务器接收客户端消息，但没有接收完成，等待一段时间后发送1xx状态
						2. 2xx：成功，代表数字：200
						3. 3xx：重定向，代表数字：302(重定向)，302(访问缓存)
						4. 4xx：客户端错误
							* 代表数字：
								* 404：路径没有对应的资源
								* 405：请求方式没有对应的doXxx方法
						5. 5xx：服务器错误，代表数字：500(服务器内部出现异常)
			2. 响应头
				1. 格式：头名称： 值
				2. 常见的响应头：
					1. Content-Type:服务器告诉客户端本次响应体数据格式以及编码格式
					2. Content-dispostion：服务器告诉客户端以什么格式打开响应体数据
						* 值：
							* in-line:默认值，在当前页面内打开
							* attachment;filename=xxx:以附件形式打开响应体，文件下载中使用
			3. 响应空行
			4. 响应体：传输的数据
		* 响应字符串格式
			HTTP/1.1 200 OK
			Content-Type: text/html;charset=UTF-8
			Content-Length: 169
			Date: Sun, 01 Aug 2021 13:31:43 GMT

			<!DOCTYPE html>
			<html>
			<head>
			    <title>JSP - Hello World</title>
			</head>
			<body>
			<h1>Hello World!
			</h1>
			<br/>
			<a href="hello-servlet">Hello Servlet</a>
			</body>
			</html>
# Response
	* 功能：设置响应消息
		1. 设置响应行
			1. 格式：HTTP/1.1 200 ok
			2. 设置状态码：setStatus(int sc)
		2. 设置响应头:setHeader(String name,String value)
		3. 设置响应体:
			* 使用步骤：
				1. 获取输出流
					* 字符输出流：PrintWriter getWriter()
					* 字节输出流：ServletOutputStream getOutputStream()
				2. 使用输出流，将数据输出到客户端浏览器
	* 案例：
		1. 完成重定向
			* 重定向：资源跳转的方式
			* 代码实现：
				//1.设置状态码为302
		        response.setStatus(302);
		        //2.设置响应头location
		        response.setHeader("location","/response/responseDemo2");
		
		        //简单的重定向方法
		        response.sendRedirect("/response/responseDemo2");
			* 重定向(forward)的特点
				1. 地址栏发生变化
				2. 重定向可以访问其他站点(服务器)的资源
				3. 重定向是两次请求，不能使用request对象来共享数据
			* 转发(redirect)的特点
				1. 转发地址栏路径不变
				2. 转发只能访问当前服务器下的资源
				3. 转发是一次请求，可以使用request对象来共享数据
			* 路径写法:
				1. 路径的分类
					1. 相对路径：通过相对路径不可以确定唯一资源
						* 如：./index.html
						* 不以/开头，以.开头路径
						* 规则：找到当前资源和目标资源之间的相对位置关系
							* ./：当前目录
							* ../：后退一级目录
					2. 绝对路径：通过绝对路径可以确定唯一资源
						* 如：http://localhost:8888/response/responseDemo2	/response/responseDemo2
						* 以/开头的路径
						* 规则：判断定义的路径是给谁用的？判断请求将来从哪儿发出 
							* 给客户端浏览器使用：需要加虚拟目录(项目的访问路径)
								* 建议虚拟目录动态获取：request.getContestPath()
								* <a>,<form>,重定向...
							* 给服务器使用：不需要加虚拟目录
								* 转发路径
		2. 服务器输出字符数据到浏览器
			* 步骤：
				1. 获取字符输出流
				2. 输出数据
			* 注意：
				* 乱码问题：
					1. PrintWriter pw = response.getWriter(); 获取的流的默认编码是ISO-8859-1
					2. 设置该流的默认编码
					3. 告诉浏览器响应体使用的编码
					//简单的形式来设置编码
        			response.setContentType("text/html;charset=utf-8");
		3. 服务器输出字节数据到浏览器
			* 步骤：
				1. 获取字节输出流
					ServletOutputStream sos = response.getOutputStream();
				2. 输出数据
					sos.write("你好".getBytes("utf-8"));
		4. 验证码
			1. 本质：图片
			2. 目的：防止恶意表单注册