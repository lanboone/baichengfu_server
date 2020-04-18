# baichengfu_server

## 项目打包命令
mvn clean package

## maven profiles配置
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