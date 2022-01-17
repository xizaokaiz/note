<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <!-- 单击验证码切换 -->
    <script>
      window.onload = function (){//当页面加载完毕
        document.getElementById("img").onclick = function (){//绑定单击事件

          this.src = "/cookie_session_war_exploded/checkCodeServlet?time"+new Date().getTime();
        }
      }
    </script>

  <style>
    div{
      color: red;
    }
  </style>
</head>
<body>

  <from action="/cookie_session_war_exploded/loginServlet" method="post">
    <table>
      <tr>
        <td>用户名</td>
        <td><input type="text" name="username"></td>
      </tr>

      <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
      </tr>

      <tr>
        <td>验证码</td>
        <td><input type="text" name="checkCode"></td>
      </tr>

      <tr>
        <td colspan="2"><img id="img" src="/cookie_session_war_exploded/checkCodeServlet"></td>
      </tr>

      <tr>
        <td colspan="2"><input type="submit" value="登录"></td>
      </tr>

    </table>
  </from>

  <!-- 获取数据 -->
  <div><%=request.getAttribute("cc_error")==null ? "" : request.getAttribute("cc_error")%></div>
  <div><%=request.getAttribute("login_error")==null? "":request.getAttribute("login_error")%></div>
</body>
</html>
