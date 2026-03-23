# 使用多阶段构建
# 第一阶段：构建应用
FROM maven:3.8-jdk-11 AS build

# 设置工作目录
WORKDIR /app

# 复制 pom.xml 和 settings.xml 文件
COPY pom.xml .
# COPY settings.xml /root/.m2/

# 下载所有依赖项
# 这一步骤将被缓存，除非 pom.xml 发生变化
RUN mvn dependency:go-offline -B -Dspotless.skip=true

# 复制源代码
COPY src ./src
COPY DevStyleHtml.prefs .
COPY DevStyleXml.prefs .
COPY .keystore .

# 构建应用
RUN mvn package -DskipTests -Dspotless.skip=true

# 第二阶段：运行应用
FROM openjdk:8u342

# 设置工作目录
WORKDIR /app

# 复制构建好的 JAR 文件
COPY --from=build /app/target/*.war app.war

# 暴露应用端口
EXPOSE 8080

# 运行应用
ENTRYPOINT ["java", "-jar", "app.war"]
