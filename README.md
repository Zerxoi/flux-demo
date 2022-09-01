# Spring WebFlux Demo

项目实践参考：[Spring WebFlux快速上手——响应式Spring的道法术器
](https://blog.csdn.net/get_set/article/details/79480233)

## 环境部署

安装 MongoDB

```shell
shell $ docker run --name some-mongo -p 27017:27017 -d mongo
shell $ docker exec -it some-mongo mongo
# @Tailable 仅支持有大小限制的 collection，而自动创建的 collection 是不限制大小的，因此我们需要先手动创建。
mongo > db.createCollection("event", { capped: true, size: 200 }) 
```
## 运行使用

```shell
flux-demo $ mvn spring-boot:run
```

## 测试接口

```http request
## 获取日期
GET http://localhost:8080/date

## 获取时间
GET http://localhost:8080/time

## 流式获取时间（间隔1s）
GET http://localhost:8080/times

## 创建用户
POST http://localhost:8080/user
Content-Type: application/json

{
"username": "zhangsan",
"phone": "13745218912",
"name": "张三",
"birthday": "2001-08-20"
}

## 查找根据用户名查找用户
GET http://localhost:8080/user/{{username}}

## 删除用户
DELETE http://localhost:8080/user/{{username}}

## 流式查找所有用户（每个用户间隔1s）
GET http://localhost:8080/user

## 执行 WebClientTest.postEvents 测试方法流式创建 event

## 流式 tail 方式获取 event
GET http://localhost:8080/event
```
