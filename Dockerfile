# 构建前端
FROM node:alpine3.15 AS fronted
RUN npm install --force --global yarn
COPY notifying-fronted/ /app/notifying-fronted/
WORKDIR /app/notifying-fronted
RUN ls -al && yarn install && yarn run build
#  构建后台
FROM maven:3.8.4-openjdk-8-slim AS backend
COPY notifying-backend/ /app/notifying-backend/
COPY --from=fronted /app/notifying-fronted/dist/ /app/notifying-backend/src/main/resources/static/
WORKDIR /app/notifying-backend
RUN mvn package
# 启动容器
FROM openjdk:8u232-slim
COPY --from=backend /app/notifying-backend/target/notifying.jar /notifying.jar
EXPOSE 1096

CMD ["java","-jar","/notifying.jar"]
