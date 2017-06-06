记录：spring -boot自带tomcat容器，如果要在外部容器中运行，打包的时候需要过滤掉spring-boot-tomcat
或者将spring-boot-tomcat的scope设置为provide
(provided意味着打包的时候可以不用包进去，别的设施(Web Container)会提供。事实上该依赖理论上可以参与编译，测试，运行等周期。相当于compile，但是在打包阶段做了exclude的动作)
因为外部的web容器已经含有JavaEE运行的servlet-api,不能重复提供
springBoot项目的启动直接可以：Java -java demo(项目打包后的名称)
