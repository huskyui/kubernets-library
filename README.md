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