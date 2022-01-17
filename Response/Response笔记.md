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
				* 代码：
					//转发
        			request.getRequestDispatcher("/responseDemo2").forward(request,response);
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
			* 代码：
				//获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
		        //response.setCharacterEncoding("utf-8");
		        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
		        response.setHeader("content-type","text/html;charset=utf-8");
		
		        //简单的形式来设置编码
		        response.setContentType("text/html;charset=utf-8");
		
		        //1.获取字符输出流
		        PrintWriter pw = response.getWriter();
		        //2.输出数据
		        pw.write("<h1>hello response</h1>");
		        pw.write("你好 response");
		3. 服务器输出字节数据到浏览器
			* 步骤：
				1. 获取字节输出流
					ServletOutputStream sos = response.getOutputStream();
				2. 输出数据
					sos.write("你好".getBytes("utf-8"));
			* 代码：
				response.setContentType("text/html;charset=utf-8");
		        //1.获取字节输出流
		        ServletOutputStream sos = response.getOutputStream();
		        //2.输出数据
		        sos.write("你好".getBytes("utf-8"));
		4. 验证码
			1. 本质：图片
			2. 目的：防止恶意表单注册
			* 代码：
				int width = 100;
		        int height = 50;
		        //1.创建一个对象，在内存中去画图(验证码图片对象)
		        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		        //2.美化图片
		        //2.1 填充背景色
		        Graphics g = image.getGraphics();//画笔对象
		        g.setColor(Color.PINK);//设置画笔颜色
		        g.fillRect(0,0,width,height);
		
		        //2.2 画边框
		        g.setColor(Color.blue);
		        g.drawRect(0,0,width-1,height-1);
		
		        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		        //生成随机角标
		        Random ran = new Random();
		
		        for(int i=0;i<4;i++){
		            int index = ran.nextInt(str.length());
		            //获取字符
		            char ch = str.charAt(index);//随机字符
		            //2.3 写验证码
		            g.drawString(ch+"",width/5*i,height/2);
		        }
		
		        //2.4 画干扰线
		        g.setColor(Color.GREEN);
		
		        //随机生成坐标点
		        int x1 = ran.nextInt(width);
		        int x2 = ran.nextInt(width);
		        int y1 = ran.nextInt(height);
		        int y2 = ran.nextInt(height);
		        for(int i=0;i<10;i++){
		            g.drawLine(x1,y1,x2,y2);
		        }
		
		        //3.将图片输出到页面展示
		        ImageIO.write(image,"jpg",response.getOutputStream());
# ServletContext对象
	1. 概念：代表整个web应用，可以和程序的容器(服务器)来通信
	2. 获取：
		1. 通过request对象获取
			request.getServletContext();
		2. 通过HttpServlet获取
		    this.getServletContext();
		* 代码：
			//1. 通过request对象获取
	        ServletContext servletContext = request.getServletContext();
	        //2. 通过HttpServlet获取
	        ServletContext servletContext1 = this.getServletContext();
	3. 功能：
		1. 获取MIME类型：
			* MIME类型:在互联网通信过程中定义的一种文件数据类型
				* 格式：大类型/小类型		tet/html	image/jpg
			* 获取：String getMimeType(String file)
			* 代码：
				//2. 通过HttpServlet获取
		        ServletContext context = this.getServletContext();
		        //3. 定义文件名称
		        String filename = "a.jpg";//image/jpeg
		        //4. 获取MIME类型
		        String mimeType = context.getMimeType(filename);
		        System.out.println(mimeType);
		2. 域对象：共享数据
			1. serAttribute(String name,Object value)
			2. getAttribute(String name)
			3. removeAttribute(String name)
			* ServletContext对象范围：所有用户所有请求的数据
			* 代码：
				//2. 通过HttpServlet获取
		        ServletContext context = this.getServletContext();
		        //设置数据
		        context.setAttribute("msg","haha");
		3. 获取文件的真实路径(服务器路径)
			1. 方法：String getRealPath(String path)
				String b = context.getRealPath("/b.txt");//web目录下资源访问
		        System.out.println(b);
		        //File file = new File(realPath);
		
		        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
		        System.out.println(c);
		
		        String a = context.getRealPath("a.txt");//resources目录下的资源访问
		        System.out.println(a);
# 案例：文件下载
	* 文件下载需求：
		1. 页面显示超链接
		2. 点击超链接后弹出下载提示框
		3. 完成图片文件下载
	* 分析：
		1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框。不满足需求
		2. 任何资源都必须弹出下载提示框
		3. 使用响应头设置资源的打开方式：
			* content-disposition:attachment;filename=xxx
	* 步骤：
		1. 定义页面，编辑超链接的href属性，指向Servlet，传递资源的名称filename
		2. 定义Servlet
			1. 获取文件名称
			2. 使用字节输入流加载文件进内存
			3. 指定response的响应头：content-disposition:attachment;filename=xxx
			4. 将数据写出到response输出流
	* 代码：
		//1.获取请求参数：文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("Content-Type",mimeType);
        //3.2设置响应头打开方式：content-disposition
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024* 8];//缓冲区
        int len = 0;
        while((len = fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();
	* 中文文件问题：
		* 解决思路：
			1. 获取客户端使用的浏览器版本信息
			2. 根据不同的版本信息，设置filename不同的编码方式
		* 代码
			//解决中文文件名问题
	        //1.获取user-agent请求头
	        String agent = request.getHeader("user-agent");
	        //2.使用工具类方法编码文件名即可
	        filename = DownLoadUtils.getFileName(agent, filename);