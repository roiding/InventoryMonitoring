## 别问为什么

python写起来就是不如java来的丝滑 所以做个java版 准备是做成一个小平台 慢慢来 先帮大家把冰墩墩搞定

## 注意

目前虽然前后端是分开开发的 但是通过github action打包时，是将前端打包进了后台包中（别问为什么，就是没资源再摆个nginx）

## fork步骤

只需要在仓库的secrets中添加自己的以下参数即可



|       字段名        |         解释         |
| :-----------------: | :------------------: |
|   DATASOURCE_URL    |     数据库连接串     |
| DATASOURCE_USERNAME |     数据库用户名     |
| DATASOURCE_PASSWORD |      数据库密码      |
|                     |                      |
| DOCKERHUB_USERNAME  |   DockerHub用户名    |
|   DOCKERHUB_TOKEN   | DockerHub密码或token |
|                     |                      |
|      MAIL_HOST      |   邮件POP服务域名    |
|    MAIL_USERNAME    |       邮箱地址       |
|    MAIL_PASSWORD    |   邮箱授权码或密码   |
|      MAIL_PORT      |   邮件POP服务端口    |
|      SERVE_URL      |     服务部署域名     |



java服务的docker容器启动端口默认是1096，自己通过docker端口映射到80端口吧
