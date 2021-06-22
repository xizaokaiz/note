## DOM简单学习：为了满足案例要求
	* 功能：控制html文档的内容
	* 代码：获取页面标签(元素)对象 Element
		* document.getElementById("ID值")：通过元素的ID获取元素对象
	* 操作Element对象
		1. 修改属性值
			1. 明确获取的对象是哪一个
			2. 查看API文档，找其中有哪些属性可以设置
		2. 修改标签体内容
			* 属性：innerHTML
			1. 获取元素对象
			2. 使用innerHTML属性修改标签体内容
## 事件简单学习
	* 功能：某些组件被执行了某些操作后，触发某些代码的执行。
		* 造句：xxx被xxx，我就xxx
			* 我方水晶被摧毁后，我就责备队友
			* 地方水晶被摧毁后，我就夸奖自己
	* 如何绑定事件
		1. 直接在html标签上，指定事件的属性，属性值就是js代码
			1. 事件：onclick --单击事件
		2. 通过js获取元素对象，指定事件属性，设置一个函数
			* 代码
				<img  id="light" src="img/off.gif" onclick="fun();">
				<img  id="light2" src="img/off.gif">
				<script>
				  function fun(){
				    alert('我被点了');
				    alert('我又被点了');
				  }
				
				  function fun2(){
				    alert('咋老点我？');
				  }
				
				  //1. 获取light2对象
				  var light2 = document.getElementById("light2");
				  //2. 绑定事件
				  light2.onclick = fun2;
				</script>
	* 案例1：灯泡开关
		<p align="center">
		 <img id="light" src="img/off.gif" >
		</p>
		<script>
		/*
		分析：
		  1. 获取图片对象
		  2. 绑定单击事件
		  3. 每次点击切换图片
		    * 规则：
		      * 如果灯是开的 on，切换图片为 off
		      * 如果灯是关的 off，切换图片为 on
		    * 使用标记flag来完成
		*/
		
		//1. 获取图片对象
		var light = document.getElementById("light");
		
		var flag = false;//代表灯是灭的 off图片
		//2. 绑定单击事件
		light.onclick = function (){
		if(flag){//判断如果灯是开的，则灭掉
		  light.src = "img/off.gif";
		  flag = false;
		}else {//如果灯是灭的，则打开
		  light.src = "img/on.gif";
		  flag = true;
		}
		}


## BOM
	1. 概念：Browser Object Model 浏览器对象模型
		* 将浏览器的各个组成部分封装成对象
	2. 组成
		* Navigator：浏览器对象
		* Screen：显示器屏幕对象
		* History：历史记录对象
		* Location：地址栏对象
	3. Window：窗口对象
			1. 创建
			2. 方法
				1. 与弹出框有关的方法：
					* alert()：显示带有一段消息和一个确认按钮的警告框。
					* confirm()：显示带有一段消息以及确认按钮和取消按钮的对话框。
					  * 如果用户点击确定按钮，则方法返回true
					  * 如果用户点击取消按钮，则方法返回false
					* prompt()：显示可提示用户输入的对话框。
					  * 返回值：获取用户输入的值
			2. 与打开关闭有关的方法
				* close():关闭浏览器窗口。
				    * 谁调用我，我关谁
				* open():打开一个新的浏览器窗口或查找一个已命名的窗口。
				    * 返回新的Window对象
			3. 与定时器有关的方法
				* setTimeout():在指定的毫秒数后调用函数或计算表达式。
				    * 参数：
				        1. js代码或者方法对象
				        2. 毫秒值
				    * 返回值：唯一表示，用于取消定时器
				* clearTimeout():取消由 setTimeout() 方法设置的 timeout。
				* setInterval():按照指定的周期（以毫秒计）来调用函数或计算表达式。
				* clearInterval():取消由 setInterval() 设置的 timeout。
			3. 属性
			4. 特点
				* Window对象不需要创建可以直接使用 window使用，window.方法名();
				* window引用可以省略，方法名();
	4. Location：地址栏对象
		1. 创建（获取）：
			1. window.location
			2. location
		2. 方法：
			* reload()：重新加载当前文档。
		3. 属性
			* href：设置或返回完整的 URL。
	5. History：历史记录对象
	    1. 创建(获取)：
	        1. window.history
	        2. history
	
	    2. 方法：
	        * back():加载 history 列表中的前一个 URL。
	        * forward():加载 history 列表中的下一个 URL。
	        * go(参数):加载 history 列表中的某个具体页面。
	            * 参数：
	                * 正数：前进几个历史记录
	                * 负数：后退几个历史记录
	    3. 属性：
	        * length:返回当前窗口历史列表中的 URL 数量。
	* 案例3：自动跳转
		<style>
			p{
			  text-align: center;
			}
			span{
			  color: red;
			}
			</style>
		<p>
		  <span id="time">5</span>秒之后，自动跳转到首页...
		</p>
		<script>
		  /*
		    分析：
		      1. 显示页面效果 <p>
		      2. 秒数倒计时
		        2.1 定义一个方法，获取span标签，修改span标签体的内容，时间--
		        2.2 定义一个定时器，一秒执行一次该方法
		      3. 在方法中判断时间如果<=0，则跳转到首页
		   */
		
		  //2.显示倒计时效果
		  var second = 5;
		  var time = document.getElementById("time");//获取id为time
		  //2.1 定义一个方法，获取span标签，修改span标签体的内容，时间--
		  function showTime(){
		    second--;
		    // 在方法中判断时间如果<=0，则跳转到首页
		    if(second<=0){
		      location.href = "https://www.baidu.com";
		    }
		    time.innerHTML = second+"";//innerHTML：修改标签体内容；转为字符串类型
		
		  }
		  //2.2 定义一个定时器，一秒执行一次该方法
		  setInterval(showTime,1000);
		</script>

## DOM
	* 概念：Document Object Model 文档对象模型
		* 将标记语言文档的各个组成部分，封装为对象。可以使用这些对象，对标记语言文档进行CRUD的动态操作
	* W3C DOM 标准被分为 3 个不同的部分：
		* 核心 DOM - 针对任何结构化文档的标准模型
			* Document:文档对象
			* Element:元素对象
			* Attribute:属性对象
			* Text:文本对象
			* Comment:注释对象
			* Node:节点对象，其他5个的父对象
		* XML DOM - 针对 XML 文档的标准模型
		* HTML DOM - 针对 HTML 文档的标准模型
	* 核心DOM模型：
		* Document:文档对象
			1. 创建（获取）：在html dom模型中可以使用window对象来获取
				1. window.document
				2. document
			2. 方法
			
				1. 获取Element对象：
					1. getElementById()：根据id属性值获取元素对象。id属性值一般唯一
					2. getElementByTagName():根于元素名称获取元素对象们，返回值是一个数组
					3. getElementsByClassName():根据class属性值获取元素对象们，返回值是一个数组
					4. getElementByName():根据name属性值获取元素对象们，返回值是一个数组
				2. 创建其他对象
					1. createAttribute(name)：创建拥有指定名称的属性节点，并返回新的 Attr 对象。
			        2. createComment()：创建注释节点。
			        3. createElement()：创建元素节点。
			        4. createTextNode()：创建文本节点。
			3. 属性
		* Element:元素对象
			1. 获取/创建：通过document来获取和创建
			2. 方法
				1. removeAttribute()：删除指定的属性。
				2. setAttribute()：添加新属性。
		* Node:节点对象，其他5个的父对象
			* 特点：所有dom对象都可以被认为是一个节点
			* 方法：
				* CRUD dom树：
					* appendChild()：向节点的子节点列表的结尾添加新的子节点。
					* removeChild()：删除（并返回）当前节点的指定子节点。
					* replaceChild()：用新节点替换一个子节点。
			* 属性：
				* parentNode：返回当前节点的父节点
	* 案例4：动态表格
		* 分析：
			1. 添加
				1. 给添加按钮绑定单击事件
				2. 获取文本框的内容
				3. 创建td，设置td的文本为文本框的内容
				4. 创建tr
				5. 将td添加到tr中
				6. 获取table，将tr添加到table中
			2. 删除
				1. 确定点击的是哪一个超链接
					* <td><a href="javascript:void(0);" onclick="delTr(this);">删除</a></td>
				2. 怎么去删除？
					* removeChild():通过父节点删除子节点
		* 代码：
			<script>
			  //1.获取按钮
			  document.getElementById("btn_add").onclick = function (){
			    //2.获取文本框的内容
			    var id = document.getElementById("id").value;
			    var name = document.getElementById("name").value;
			    var gender = document.getElementById("gender").value;
			
			    //3.创建td，赋值td的标签体
			    //id 的 td
			    var td_id = document.createElement("td");
			    var text_id = document.createTextNode(id);
			    td_id.appendChild(text_id);
			    //name 的 td
			    var td_name = document.createElement("td");
			    var text_td_name = document.createTextNode(name);
			    td_name.appendChild(text_td_name);
			    //gender 的 td
			    var td_gender = document.createElement("td");
			    var text_td_gender = document.createTextNode(gender);
			    td_gender.appendChild(text_td_gender);
			
			    //a标签的td
			    var td_a = document.createElement("td");
			    var ele_a = document.getElementById("a");
			    //javascript:void(0)
			    ele_a.setAttribute("href","javascript:void(0);");
			    ele_a.setAttribute("onclick","delTr(this)");
			    var text_a = document.createTextNode("删除");
			    ele_a.appendChild(text_a);
			    td_a.appendChild(ele_a);
			
			    //4.创建tr
			    var tr = document.createElement("tr");
			
			    //5.添加td到tr中
			    tr.appendChild(td_id);
			    tr.appendChild(td_name);
			    tr.appendChild(td_gender);
			    tr.appendChild(td_a);
			
			    //6.获取table
			    var table = document.getElementsByTagName("table")[0];
			    table.appendChild(tr);
			
			  }
			
			//删除方法
			function delTr(obj){
			  var table = obj.parentNode.parentNode.parentNode;
			  var tr = obj.parentNode.parentNode;
			
			  table.removeChild(tr);
			
			}
		</script>
	* HTML DOM
		1. 标签体的设置和获取：innerHTML
			//使用innerHTML添加
			document.getElementById("btn_add").onclick = function () {
			//2.获取文本框的内容
			var id = document.getElementById("id").value;
			var name = document.getElementById("name").value;
			var gender = document.getElementById("gender").value;
			
			//获取table
			var table = document.getElementsByTagName("table")[0];
			
			//追加一行
			table.innerHTML += "<tr>\n" +
			      "    <td>"+id+"</td>\n" +
			      "    <td>"+name+"</td>\n" +
			      "    <td>"+gender+"</td>\n" +
			      "    <td><a href=\"javascript:void(0);\" onclick=\"delTr(this);\">删除</a></td>\n" +
			      "  </tr>";
			}
		2. 使用html元素对象的属性（查文档）
		3. 控制元素样式
			1. 使用元素的style属性来设置
				* 如：
				//修改样式方式1
				div1.style.border = "1px solid red";
				
				div1.style.width = "200px";
				
				//font-size --> fontSize
				div1.style.fontStyle = "20px";
			2. 提前定义好类选择器的样式，通过元素的className属性来设置其class属性值
## 事件监听机制
	* 概念：某些组件被执行了某些操作后，触发某些代码的执行。
		* 事件：某些操作，如：单击，双击，键盘按下了，鼠标移动了
		* 事件源：组件，如：按钮，文本输入框
		* 监听器：代码
		* 注册监听：将事件，事件源，监听器结合在一起。当事件源上发生了某个事件，则触发执行某个监听器代码。
	* 常见的事件
		1. 点击事件
			1. onclick:单击事件
			2. ondblclick:双击事件
		2. 焦点事件
			1. onblur:元素失去焦点
				* 一般用于表单验证
			2. onfocus:元素获得焦点
		3. 加载事件
			1. onload:一张页面或一幅图像完整加载
		4. 鼠标事件
			1. onmousedown:鼠标按钮被按下。
				* 定义方法时，定义一个形参，接收event对象
				* event对象的button属性可以获取鼠标哪个键被点击了
			2. onmousemove:鼠标被移动。
			3. onmouseout:鼠标从某元素移开。
			4. onmouseover:鼠标移到某元素之上。
			5. onmouseup:鼠标按键被松开。
		5. 键盘事件
			1. onkeyup:某个键盘按键被松开。
			2. onkeydown:某个键盘按键被按下。
			3. onkeypress:某个键盘按键被按下并松开。
		6. 选中和改变
			1. onchange:域的内容被改变。
			2. onselect:文本被选中。
		7. 表单事件
			1. onsubmit:确认按钮被点击。
				* 可以阻止表单的提交：方法要返回false则表单被阻止提交
			2. onreset:重置按钮被点击。
	* 案例5：表格全选
		* 代码：
		//1.在页面加载完后绑定事件
	    window.onload = function (){
	      //2.给全选按钮绑定单击事件
	      document.getElementById("selectAll").onclick = function (){
	        //全选
	        //1.获取所有的checkbox
	        var cbs = document.getElementsByName("cb");
	        //2.遍历
	        for(var i=0;i<cbs.length;i++){
	          //3.设置每一个cb的状态为选中  checked
	          cbs[i].checked = true;
	        }
	      }
	
	      document.getElementById("unSelectAll").onclick = function (){
	        //全不选
	        //1.获取所有的checkbox
	        var cbs = document.getElementsByName("cb");
	        //2.遍历
	        for(var i=0;i<cbs.length;i++){
	          //3.设置每一个cb的状态为选中  checked
	          cbs[i].checked = false;
	        }
	
	        document.getElementById("selectRev").onclick = function (){
	          //反选
	          //1.获取所有的checkbox
	          var cbs = document.getElementsByName("cb");
	          //2.遍历
	          for(var i=0;i<cbs.length;i++){
	            //3.设置每一个cb的状态为相反  checked
	            cbs[i].checked = !cbs[i].checked;
	          }
	          }
	
	        document.getElementById("firstCb").onclick = function (){
	          //第一个cb点击
	          //1.获取所有的checkbox
	          var cbs = document.getElementsByName("cb");
	          //获取第一个cb
	
	          //2.遍历
	          for(var i=0;i<cbs.length;i++){
	            //3.设置每一个cb的状态和第一个cb的状态一样  checked
	            cbs[i].checked = this.checked;
	          }
	        }
	
	        //给所有tr绑定鼠标移到元素之上和移出元素事件
	        var trs = document.getElementsByTagName("tr");
	        //2.遍历
	        for(var i=0;i<trs.length;i++){
	          //移到元素之上
	          trs[i].onmouseover = function (){
	            this.className = "out";
	          }
	          //移出元素
	          trs[i].onmouseout = function (){
	            this.className = "over";
	          }
	        }
	
	      }
	    }
	* 案例6：表单校验
		* 分析：
			1. 给表单绑定onsubmit事件，监听器中判断每一个方法校验的结果
				* 如果都为true，则监听器方法返回true
				* 如果有一个false，则监听器方法返回false
			2. 定义一些方法分别校验各个表单项
			3. 给各个表单项绑定onblur事件
		* 代码：
			window.onload = function (){
		      //1.给表单绑定onsubmit事件
		      document.getElementById("form").onsubmit = function (){
		        //调用用户校验方法  checkUsername();
		        //调用密码校验方法  checkPassword();
		        // return checkUsername() && checkPassword;
		
		        return checkUsername() && checkPassword;
		      }
		
		      //给用户名和密码框分别绑定离焦事件
		      document.getElementById("username").onblur = checkUsername;
		      document.getElementById("password").onblur = checkPassword;
		    }
		
		    //校验用户名
		    function checkUsername(){
		      //1.获取用户名的值
		      var username = document.getElementById("username").value;
		
		      //2.定义正则表达式
		      var reg_username = /^\w(6,12)$/;
		      //3.判断值是否符合正则表达式的规则
		      var flag = reg_username.test(username);
		      //4.提示信息
		      var s_username = document.getElementById("s_username");
		
		      if(flag){
		        //提示绿色对勾
		        s_username.innerHTML = "<img width='35' height='25' src='img/gou.png' />";
		      }else{
		        //提示红色用户名有误
		        s_username.innerHTML = "用户名格式有误";
		      }
		      return false;
		
		    }
		
		    //校验密码
		    function checkPassword(){
		      //1.获取用户名的值
		      var password = document.getElementById("password").value;
		
		      //2.定义正则表达式
		      var reg_password = /^\w(6,12)$/;
		      //3.判断值是否符合正则表达式的规则
		      var flag = reg_password.test(password);
		      //4.提示信息
		      var s_password = document.getElementById("s_password");
		
		      if(flag){
		        //提示绿色对勾
		        s_password.innerHTML = "<img width='35' height='25' src='img/gou.png' />";
		      }else{
		        //提示红色用户名有误
		        s_password.innerHTML = "密码格式有误";
		      }
		      return false;
		
		    }