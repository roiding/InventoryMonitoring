# 构建前端
FROM node:alpine3.15 AS fronted
RUN npm install --global yarn
WORKDIR ./notifying-fronted
RUN yarn install && yarn build
#  构建后台
FROM maven:3.8.4-openjdk-8-slim AS backend
COPY --from=fronted dist/* ../notifying-backend/src/main/resources/static/
WORKDIR ../notifying-backend
RUN maven package
# 启动容器
FROM openjdk:8u232-slim
COPY ./target/notifying.jar /notifying.jar
CMD ["java","-jar","/notifying.jar"]
