# baichengfu_server

## 项目打包
### 执行命令
mvn clean package

### linux启动，停止，重启
sh bin/startup.sh   启动项目
sh bin/shutdown.sh  停止服务
sh bin/restart.sh   重启服务

#### 如果遇到类似报错
: not foundn.sh: 2: bin/startup.sh: 
: not foundn.sh: 11: bin/startup.sh: 
: not foundn.sh: 14: bin/startup.sh: 
: not foundn.sh: 17: bin/startup.sh: 
bin/shutdown.sh: 26: bin/startup.sh: Syntax error: "fi" unexpected (expecting "then")
#### 则执行以下命令
1、vi startup.sh  2、:set ff=unix

### maven profiles配置
```xml
<!--MAVEN打包选择运行环境-->
<!-- 1:local(默认) 本地 2:dev:开发环境 3:test 4:uat 用户验收测试 5.pro:生产环境-->
<profiles>
    <profile>
        <id>local</id>
        <properties>
            <profileActive>local</profileActive>
        </properties>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
    </profile>
    <profile>
        <id>dev</id>
        <properties>
            <profileActive>dev</profileActive>
        </properties>
        <activation>
            <activeByDefault>false</activeByDefault>
        </activation>
    </profile>
    <profile>
        <id>test</id>
        <properties>
            <profileActive>test</profileActive>
        </properties>
        <activation>
            <activeByDefault>false</activeByDefault>
        </activation>
    </profile>
    <profile>
        <id>uat</id>
        <properties>
            <profileActive>uat</profileActive>
        </properties>
        <activation>
            <activeByDefault>false</activeByDefault>
        </activation>
    </profile>
    <profile>
        <id>prod</id>
        <properties>
            <profileActive>prod</profileActive>
        </properties>
        <activation>
            <activeByDefault>false</activeByDefault>
        </activation>
    </profile>
</profiles>
```
### linux解压tar.gz

```bash
tar -zxvf spring-boot-assembly-local-1.0.RELEASE.tar.gz
```

### 解压后的目录结构
```text
└─spring-boot-assembly
    │  LICENSE
    │  NOTICE
    │  README.md
    │
    ├─bin
    │      restart.sh
    │      shutdown.sh
    │      startup.bat
    │      startup.sh
    │
    ├─boot
    │      spring-boot-assembly.jar
    │
    ├─config
    │  │  application-dev.yml
    │  │  application.yml
    │
    └─lib
            jackson-databind-2.9.7.jar
            jackson-datatype-jdk8-2.9.7.jar
            jackson-datatype-jsr310-2.9.7.jar
            jackson-module-parameter-names-2.9.7.jar
            javax.annotation-api-1.3.2.jar
            jboss-logging-3.3.2.Final.jar
            jul-to-slf4j-1.7.25.jar
            log4j-api-2.11.1.jar
            log4j-to-slf4j-2.11.1.jar
            logback-classic-1.2.3.jar
            logback-core-1.2.3.jar
            slf4j-api-1.7.25.jar
            snakeyaml-1.23.jar
            spring-aop-5.1.2.RELEASE.jar
            spring-beans-5.1.2.RELEASE.jar
            spring-boot-2.1.0.RELEASE.jar
            spring-boot-autoconfigure-2.1.0.RELEASE.jar
            spring-boot-starter-2.1.0.RELEASE.jar
            spring-boot-starter-json-2.1.0.RELEASE.jar
            .....
```

