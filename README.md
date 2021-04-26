### 开启dashboard
```
kubectl apply -f dashboard-deployment.yaml
// 开启proxy,可以本地访问
kubectl proxy
```
本地访问
> http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/ 

### pod操作
```
// 创建或者更新
kubectl apply -f xxx-deployment.yaml
// 删除
kubectl delete -f xxx-deployment.yaml
// 获取pods
kubectl get pods
// 获取描述
kubectl describe pod podName
// 获取日志
kubectl logs xxx
// 具体可以通过help命令查看
```

### deployment-folder

#### dashboard-deployment

dashboard is a web-based kubernets user interface.

#### javaweb2-deployement

depoly the war file to tomcat. user initContainers

#### two-containers-deployment

shared data in the pod

#### war-tomcat-deployment

我们打包时将war包打包到image中去，之后在运行pod时，通过initContainers将war拷贝至特定路径，并将该路径于containers 共享同一块volume。可以实现不需要打包频繁打包至tomcat中

### 安装ingress

```
​```shell
kubectl apply -f mandatory.yaml
kubectl apply -f service-nodeport.yaml
​```
```


### k8s 最佳实践
具体文件在deployment/k8s-demo
+ 我们需要先安装ingress,我个人感觉就是代理
+ 定义一个 deployment，deploy.yaml   配置了一个springboot 应用 localhost:8080/welcome/   => hello
+ 定义一个service. 能提供稳定的访问入口，我们还需要部署“服务”来接收请求，并屏蔽内部的弹性机制 .  service.yaml
+ 定义一个ingress  使用ingress实现服务对外暴露的需求       ingress.yaml


执行完后，我们通过kubectl get ingress。获取ip

```shell
NAME              CLASS    HOSTS   ADDRESS          PORTS   AGE
example-ingress      *       47.100.138.224   80      72s
```
访问 47.100.138.224/welcome/  => hello    
这个ingress 里面的path 有点像spring cloud gateway 模块    。 我在spring boot web项目后面加了一个 content-path  /welcome
如果出现错误，请查看日志，web项目里面加了特殊的日志