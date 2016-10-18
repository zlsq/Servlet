# Servlet 基础学习
# 一、WEB应用的发展
## 1.规律
- 由单机程序向网络程序发展
- 由CS程序向BS程序发展

## 2.CS和BS的区别
### CS
- Client Server
- 客户端服务程序，客户端由程序员开发，用户需要安装

### BS
- Browser Server
- 浏览器服务程序，不需要单独开发及安装

# 二、 Servlet介绍
## 1.服务器如何给浏览器返回网页？
### 1）返回静态网页
- 百度百科、新闻等
- 内容不变，任何人看都一样
- 服务器保存的一个HTML，访问时直接返回它

### 2）返回动态网页
- 微博、淘宝
- 每个人看的内容有差别
- 服务器保存一个组件，用它来拼一个动态网页
- 在Java项目中，这个组件就是Servlet
> 组件：就是满足规范的对象

## 2.Servlet具备的特征
- Servlet是存储在服务器上的
- Servlet满足sun的规范
- 它可以拼动态资源（网页、图片等）
> 可以处理HTTP协议

## 3.什么事Servlet
- 是sun推出的用来在服务器端处理HTTP协议的组件

# 三、服务器
## 1.名称
- Java服务器
- WEB服务器
- Java WEB服务器
- Servlet容器

## 2.本质
- 是一个软件：能够运行Java项目的软件
- 和浏览器相对应、平级

## 3.举例
- Tomcat
- JBoss
- WebLogic
- WebSphere

# 四、如何使用tomcat
## 1.单独使用
### 1)配置JAVA_HOME
- tomcat依赖于Java

### 2)下载及安装
- 在apache官网下载
- 直接解压缩(释放)即可，这是绿色免安装软件

### 3)启动tomcat
- Linux：打开/tomcat/bin目录，输入./startup.sh
- window：打开/tomcat/bin目录，双击startup.bat
> 给目录加权限：chmod +x *sh

### 4)访问tomcat
- 打开浏览器，输入http://localhost:8080

### 5)关闭tomcat
- Linux：打开/tomcat/bin目录，输入./shutdown.sh
- windows：打开/tomcat/bin目录，双击shutdown.bat

## 2.用Eclipse管理tomcat(开发时)
- 配置失败需要重来：
- window->preference->server->runtime
- 选择tomcat点击remove
- Eclipse左侧点击Servers项目将其删除

# 五、Servlet开发步骤
## 1.创建WEB项目
- WEB项目有标准的WEB目录：
- webapp/WEB-INF/web.xml

## 2.导入jar包
### 1)用maven搜javaee
- 在搜索结果中选择javaee-api.jar

### 2)使用tomcat内置的jar包
- 右键项目->properties->targeted runtimes->勾选tomcat->apply

## 3.开发Servlet
- 继承于HttpServlet
- 间接实现了Servlet接口(sun的规范)

## 4.配置Servlet
- 在web.xml中加以配置

## 5.部署项目
- 在Servers下点击tomcat
- 右键点击Add and Remove
- 弹出框中将项目从左侧移动到右侧
- 启动tomcat
> 部署：就是拷贝

## 6.访问Servlet
- http://localhost:8080/servlet1/ts

![](1.png)

# 六、代码执行过程及错误
![](2.png)

# 补充
## 一、端口占用错误
### 1.出现问题的情况
- 报错：Address already in user,JVM_BIND:8080

### 2.原因及解决方案
#### 1)tomcat启动了2次，造成端口冲突
- 打开/tomcat/bin目录，执行shutdown命令，强制关闭它

#### 2)其他软件占用了此端口(Oracle)
- 修改tomcat的端口
- 打开tomcat配置文件server.xml
- 在65行修改port="8080"，建议改为8088、8089等
- 注意：关闭tomcat时修改，然后重新启动
> 在Servers项目下可以找到server.xml配置文件


# 一、HTTP协议
## 1.什么是HTTP协议
- 就是一个规范(w3c)
- 规定了：浏览器和服务器如何通信及数据格式

## 2.如何通信
- 建立连接
- 发送请求
- 接收响应
- 关闭连接

## 3.数据格式
### 1)请求数据(浏览器向服务器发送的数据)
- 请求行：请求的基本信息
- 消息头：请求数据的描述信息
- 实体内容：请求的业务数据

### 2)响应数据(服务器向浏览器发送的数据)
- 状态行：响应的基本信息
- 消息头：响应数据的描述信息
- 实体内容：响应的业务数据

## 4.对开发的要求
### 1)不需要管的地方
- 通信的过程已经由浏览器和服务器实现了
- 请求数据的组装由浏览器实现了
- 响应数据的组装由服务器实现了

### 2)需要处理的地方
- 请求的业务数据由开发者提供
- 响应的业务数据由开发者提供
> 使用request处理请求数据，使用response处理响应数据

# 二、注册案例
![](3.png)

# 三、Servlet运行原理
![](4.png)

# 四、请求方式
## 1.什么是请求方式
- 浏览器向服务器发送数据的方式
- 包括很多种方式，需要掌握的是GET和POST

## 2.GET和POST方式的区别
### 1)GET
- 采用路径传参，参数在传递过程中可见(地址栏)
- 隐私性差
- 传参能力有限，只能传少量参数
- 所有的请求默认都是GET请求

### 2)POST
- 采用实体内容传参，参数在传递过程中不可见
- 隐私性好
- 实体内容专门用来传参，大小不受限制
- 在form上加method="post"

## 3.如何选择请求方式
- 一般查询时使用GET请求，因为查询条件一般比较少
- 一般保存时使用POST请求，因为保存的数据一般较多

# 五、乱码解决方案
![](5.png)

# 六、案例
## 1.查询员工
![](6.png)

## 2.增加员工
![](7.png)

# 补充
## 1.什么是JavaBean
- 满足如下规范的类：
- 有package
- 有默认构造器
- 实现序列化接口
- 有get/set方法


# 一、重定向
## 1.重定向在增加员工中的应用
```java
response.sendRedirect(String url);
```
![](8.png)


## 2.重定向的作用及原理
![](9.png)
在重定向的过程中，影响浏览器做出动作的关键点即响应中的状态码及Location这个消息头。302状态就像一道命令一样，使得浏览器做出新的一次请求，而请求的地址会从头信息中查找。由于这个新的请求动作是由浏览器发出的，所以浏览器的地址栏上的地址会变成Location消息头中的地址。

# 二、路径
## 1.路径是什么
![](10.png)

## 2.如何获取路径
- 项目名：req.getContextPath()
- Servlet路径：req.getServletPath()
- 绝对路径：req.getRequestURI()
- 完整路径：req.getRequestURL()

## 3.URI(Uniform Resource Identifier)和URL(Uniform Resource Locator)的区别
### 1)狭义的理解(Java项目)
- URI(统一资源标识符)是绝对路径，而URL是完整路径
- URL(全球资源定位器)包含了URI

### 2)广义的理解(Web项目) *
- URI是资源的名字
- URL是资源的真名
- URI包含了URL
> 真名只有一个，名字可以有多个

## 4.Servlet访问路径的配置方案
### 1)精确匹配(/hello)
- 只有这一个路径可以访问此Servlet
- 此Servlet只能处理一个请求

### 2)通配符(/*)
- 所有的路径都可以访问此Servlet
- 此Servlet能处理所有请求

### 3)后缀(*.abc)
- 所有以abc为后缀的路径都可以访问此Servlet
- 此Serlvet能处理多个请求

### 4)用1个Servlet处理多个请求的方案
![](11.png)

### 5)通配符和后缀的典型应用场景
![](12.png)

# 三、Servlet生命周期
Servlet容器如何创建Servlet对象、如何为Servlet对象分配、准备资源、如何调用对应的方法来处理请求以及如何销毁Servlet对象的整个过程即Servlet的生命周期。
## 1.生命周期相关方法的调用顺序
![](13.png)
###阶段一、实例化
```
<servlet>
    <servlet-name>someServlet</servlet-name>
    <servlet-class>test/SomeServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping> 
    <servlet-name>someServlet</servlet-name>
    <url-pattern>/*</url-pattern>
</servlet-mapping>
```

配置文件中的**load-on-startup**节点用于设置该Servlet的创建时机。
当其中的值**大于等于0**时，表示容器在启动时就会创建实例
**小于0时或没有指定**时，代表容器在该Servlet被请求时再执行**创建
正数的值越小，优先级越高，应用启动时就越先被创建。**

###阶段二、初始化

在初始化阶段，init（）方法会被调用。这个方法在javax.servlet.Servlet接口中定义。其中，方法以一个ServletConfig类型的对象作为参数。ServletConfig对象由Servlet引擎负责创建，从中可以读取到事先在web.xml文件中通过<init-param>节点配置的多个name-value名值对。ServletConfig对象还可以让Servlet接受一个ServletContext对象。
一般情况下，init方法不需要编写，因GenericServlet已经提供了init方法的实现，并且提供了getServletConfig方法来获得ServletConfig对象。
**注：init方法只被执行一次。**

###阶段三、就绪

Servlet被初始化以后就处于能够响应请求的就绪状态。每个对Servlet的请求由一个ServletRequest对象代表，Servlet给客户端的响应由一个ServletResponse对象代表。当客户端有一个请求时，容器就会将请求与响应对象转给Servlet，以参数的形式传给service方法。service方法由javax.servlet.Servlet定义，由具体的Servlet实现。

###阶段四、销毁

Servlet容器在销毁Servlet对象时会调用destroy方法来释放资源。通常情况下Servlet容器停止或者重新启动都会引起销毁Servlet对象的动作，但除此之外，Servlet容器也有自身管理Servlet对象的准则，整个生命周期并不需要人为进行干预。

## 2.config和context的联系和区别
![](14.png)

## 3.ServletConfig
![](15.png)

## 4.ServletContext
![](16.png)



# 一、context的特殊用法
## 1.使用场景
- 之前使用config和context读取的都是web.xml中配置的常量
- 有时候我们需要存取的可能是变量
- context支持存取变量，给多个Servlet共用

## 2.案例
- 给软件做一个统计流量(访问量)的功能
- 流量是一个变量，无论访问哪个Servlet，流量+1
![](17.png)

# 二、线程安全问题
## 1.什么时候会出现线程安全问题
- 多人同时修改同一份数据时有此问题
- 局部变量存储在栈里，每个线程有自己的栈帧，没有问题
- 成员变量存储在堆里，所有线程共享这个数据，可能有问题
> 多个人同时修改成员变量

## 2.如何解决线程安全问题
- 加锁
![](18.png)

# 三、HttpServlet介绍(了解)
- sun这样设计是为了让开发者有更多选择的空间
- 制定的这种规范在实际使用中发现，并不会扩展为HTTP协议之外，所以有了过度设计的缺陷，也为在编写HTTP协议的Web应用时添加了一些不必要的操作。
![](19.png)

# 四、JSP
JSP（Java Server Page）是Sun公司制定的一种服务器端动态页面技术的组件规范，以“.jsp”为后缀的文件中既包含HTML静态标记用于表现页面，也包含特殊的代码，用于生成动态内容。
JSP作为简化Servlet开发的一种技术，实质上最终依然要转变为Servlet才可能运行，只不过这个转变过程由Servlet容器来完成。所以遵循JSP的编写规范才能使得JSP转变为需要的Servlet。
## JSP页面中的Java代码
###JSP表达式（方便输出）
```jsp
<%=3+5%>
<%=add()%>
<%=xx.getName()%>
<%=xx.getName()+“abc”%>
```
这种形式的Java代码在转译成Servlet时，会成为service（）方法中使用out.print语句的输出。
```java
out.print(3+5);
out.print(add());
out.print(xx.getName());
out.print(xx.getName()+“abc”));
```
###JSP小脚本（完成相对较长的逻辑运算）
```jsp
table>
<%
List<User>  allUser = (List<User>)request.getAttribute(“users“);
for(User u : allUser){
%>
          <tr>
              <td> <%=u.getId()%>    </td>
              <td> <%=u.getName()%>  </td>
          </tr>
<%
    }
%>
</table>
```
```java
public void service(…){
out.write(“<table>”);
List<User>  allUser = (List<User>)request.getAttribute(“users“);
for(User u : allUser){
out.write(“<tr> <td>”);
out.print(u.getId());
out.write(“</td><td>”);
out.print(u.getName());
out.write(“</td></tr>”);
     }
        out.write(“</table>”);
}
```
###JSP声明（添加属性或方法）
```jsp
<%!
    public void fun(){
        //…  方法体
}
%>
```
```java
public class XXX_JSP extends JSPBase{
public void fun(){
   // … 方法体
     }
          public void  service(… …){
}
}
```
###JSP指令
####page指令
#####导包
```jsp
<%-- 导包 --%>
<%@ page import=“java.util.*“%>
<%@ page import=“java.util.*,java.sql.*“%>
```
#####设置response.setContentType（）方法的参数值
```JSP
<%-- 设置response.setConentType方法的参数值 --%>
<%@ page contentType=“text/html;charset=utf-8“%>
```
#####设置容器读取该文件时的解码方法
```JSP
<%-- 设置容器读取该文件时的解码方式 --%>
<%@ page pageEncoding=“UTF-8“%>
```
####include指令
```jsp
<%@ include file=“header.html” %>
```
![](20.png)

## JSP运行原理
![](21.png)

## 隐含(内置)对象
### 什么是隐含对象
- 就是在JSP上可以直接使用的对象
- 这些对象是在service方法一开始就声明的
![](22.png)

### 有哪些隐含对象
#### 1) request
- HttpServletRequest

#### 2) response 
- HttpServletResponse

#### 3) out
- JSPWriter
- 等价于PrintWriter

#### 4) config
- ServletConfig

#### 5) application
- ServletContext

#### 6) exception
- Throwable
- 是JSP生成的Servlet所报的错

#### 7) session
- HttpSession

#### 8) page
- Object
- 相当于this

#### 9) pageContext
- PageContext
- 管理者，引用了其他8个隐含对象

### 总结
- 上述9个对象的名字是固定的
- 它们都可以在JSP上直接使用

### 使用的例子
```
<%String user = request.getParameter("user");%>
<%=request.getParameter("user")%>
```


# 一、开发模式
## 1. Model 1
- 使用一个组件(Servlet/JSP)处理请求
- 缺点：该组件将java和HTML高度耦合在一起
![](23.png)

## 2. Model 2(MVC)
- 使用2个组件协同处理请求
- 优点：将java和HTML代码解耦
![](24.png)

# 二、转发和重定向
## 1.它们的相同点
- 都是用来解决web组件之间的跳转问题
- web组件：Servlet/JSP

## 2.它们的区别
![](25.png)

## 3.它们的一般使用场景
- 一般查询时从查询Servlet转发到查询JSP
- 一般增加、修改、删除(Servlet)后重定向到查询(Servlet)

# 三、EL和JSTL
## 1.作用
![](26.png)

## 2.案例
![](27.png)

## 3.JSTL运行原理
![](28.png)