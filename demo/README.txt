记录：spring -boot自带tomcat容器，如果要在外部容器中运行，打包的时候需要过滤掉spring-boot-tomcat
或者将spring-boot-tomcat的scope设置为provide
(provided意味着打包的时候可以不用包进去，别的设施(Web Container)会提供。事实上该依赖理论上可以参与编译，测试，运行等周期。相当于compile，但是在打包阶段做了exclude的动作)
因为外部的web容器已经含有JavaEE运行的servlet-api,不能重复提供
springBoot项目的启动直接可以：Java -java demo(项目打包后的名称)
<exclusion>
	  <groupId>org.springframework.boot</groupId>
	  <artifactId>spring-boot-starter-tomcat</artifactId>     		
</exclusion>
注：过滤掉sprngboot自带的tomcat时候，只能在外部容器中部署。也可以使用spring-boot-jeety（使用jeety容器）
springBoot默认的项目是打成jar包直接运行（既然使用springBoot就采用这种方式最好,使用内置的tomcat），如果要打包在外部tomcat
容器中运行，需要打成war包，应为tomcat容器只能对war包直接运性，jar包需要找到对应的classPath，且要修改对应的springBoot启动类
springBoot的运行环境：Java jdk maven 环境  
Application.java放在包路径下面对应的是其默认的扫描路径，如果需要放到其他路径下面需要指明其扫描包路径@
②自定义静态资源的访问路径。
	在springmvc时候我们直接可以通过配置文件 <mvc:resources mapping="/static/**" location="/static/" cache-period="31536000"/>
	为了提高对于静态资源的访问速度我们直接可以使用将静态资源添加到niginx反向代理服务器中，
	springBoot对于静态资源的访问通过@config自定义配置类添加
	springBoot提供了一套供springmvc运性的IOC，如果我们需要自己定义自己的mvc运行环境可以使用注解
	如果Spring Boot提供的Sping MVC不符合要求，则可以通过一个配置类（注解有@Configuration的类）加上@EnableWebMvc注解来实现完全自己控制的MVC配置
	WebMvcConfigurerAdapter这个类能够扩展mvcweb常见的配置
	对于WEB/INFO下面的jsp页面我们不能直接访问，需要请求转发，对于不需要直接经过controller访问的可以在mvc在配置<mvc:view-controller>，而对
	于springboot我们需要extends WebMvcConfigurerAdapter 进行访问addViewControllers();
	
	
