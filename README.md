#txlcn 5.0 oracle DB demo


##使用说明:
原始demo代码地址为 https://github.com/codingapi/txlcn-demo
TM因本身设计原因（原设计只支持mysql），所以沿用原设计，事物记录数据存储入mysql数据库存储，但是业务模块a,b,c全部使用oracle DB,保证业务数据存储入oracle数据中
1. 本Demo基于[txlcn-最新发布](https://github.com/codingapi/tx-lcn)版本,修改的使用oracleDB版本
2. 启动Demo前需先启动Consul,启动redis事务管理器TM（txlcn-demo-tm）。
3. 更多信息见官网 [https://www.txlcn.org](https://www.txlcn.org)   
4. 原DEMO版本的[性能测试报告](https://txlcn.org/zh-cn/docs/test.html)
##测试环境搭建
1.下载Consul，[官网地址](https://www.consul.io/)
2.启动命令为（高可用版本可以自行google）
consul agent -server -bootstrap-expect 1  -bind=127.0.0.1 -client 0.0.0.0 -data-dir ./tmp
3.本机安装docker
4.下载redis镜像
docker pull redis
5.运行redis
docker run -p 6379:6379 -d redis
6.下载oracle DB镜像
docker pull store/oracle/database-enterprise:12.2.0.1
7.运行oracle DB容器
docker run -d -it --name oracledb -P store/oracle/database-enterprise:12.2.0.1
8.登录DBA用户
sqlplus sys/Oradoc_db1@ORCLCDB as sysdba
9.创建用户
10.创建T_demo表
CREATE TABLE  
   (	"ID" NUMBER NOT NULL ENABLE, 
	"KID" VARCHAR2(45 BYTE), 
	"DEMO_FIELD" VARCHAR2(255 BYTE), 
	"GROUP_ID" VARCHAR2(64 BYTE), 
	"UNIT_ID" VARCHAR2(32 BYTE), 
	"APP_NAME" VARCHAR2(128 BYTE), 
	"CREATE_TIME" TIMESTAMP (6), 
	 CONSTRAINT "T_DEMO_PK" PRIMARY KEY ("ID")
	 ）;
11.创建mysql DB
12.按照tx-manager.sql脚本在mysql DB中创建事物记录表