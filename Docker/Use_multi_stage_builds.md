- whay

  - 多阶段构建优化了Dockerfile，使Dockerfile更容易阅读和维护

- why

  - 没有多阶段构建之前
    1 基于golang基础镜像，编译一个go程序

    ```dockerfile
    这是 Dockerfile.build
    # syntax=docker/dockerfile:1
    FROM golang:1.16
    WORKDIR /go/src/github.com/alexellis/href-counter/
    COPY app.go ./
    RUN go get -d -v golang.org/x/net/html \
      && CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o app .
    ```

    2 基于最小的linux，运行一个go程序

    ```dockerfile
    这是 Dockerfile.build
    # syntax=docker/dockerfile:1
    FROM alpine:latest  
    RUN apk --no-cache add ca-certificates
    WORKDIR /root/
    COPY app ./
    CMD ["./app"]  
    ```

    3 还需要使用脚本操作这两个Dockerfile

    ```shell
    #!/bin/sh
    echo Building alexellis2/href-counter:build
    # 构建第一个Dockerfile
    docker build --build-arg https_proxy=$https_proxy --build-arg http_proxy=$http_proxy \  
        -t alexellis2/href-counter:build . -f Dockerfile.build
    # 把第一个Dockerfile编译号的go程序copy到宿主机
    docker container create --name extract alexellis2/href-counter:build  
    docker container cp extract:/go/src/github.com/alexellis/href-counter/app ./app 
    # 删除第一个用作编译go程序的容器
    docker container rm -f extract
    
    echo Building alexellis2/href-counter:latest
    # 构建第二个Dockerfile，运行go程序
    docker build --no-cache -t alexellis2/href-counter:latest .
    rm ./app
    ```

  - 使用多阶段构建进行优化后

    > 只需要单个 Dockerfile，也不需要单独的构建脚本，不需要创建任何中间图像，也不需要将任何文件拷贝到宿主机。
    >
    > 只需要： docker build -t alexellis2/href-counter:latest .

    ```dockerfile
    # syntax=docker/dockerfile:1
    FROM golang:1.16
    WORKDIR /go/src/github.com/alexellis/href-counter/
    RUN go get -d -v golang.org/x/net/html  
    COPY app.go ./
    RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o app .
    
    FROM alpine:latest  
    RUN apk --no-cache add ca-certificates
    WORKDIR /root/
    # COPY下标为0的第一个FROM中的go程序
    COPY --from=0 /go/src/github.com/alexellis/href-counter/app ./
    CMD ["./app"]  
    ```

- how to use multi-stage builds

  - 可以对阶段取别名，避免使用整数下标来引用

    ```dockerfile
    # syntax=docker/dockerfile:1
    FROM golang:1.16 AS builder
    WORKDIR /go/src/github.com/alexellis/href-counter/
    RUN go get -d -v golang.org/x/net/html  
    COPY app.go    ./
    RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o app .
    
    FROM alpine:latest  
    RUN apk --no-cache add ca-certificates
    WORKDIR /root/
    COPY --from=builder /go/src/github.com/alexellis/href-counter/app ./
    CMD ["./app"]  
    ```

  - 构建镜像时，可以指定构建到那个阶段，可以应用的debug场景

    ```shell
     docker build --target builder -t alexellis2/href-counter:latest .
    ```

  - 多阶段构建时，不是只能从之前在 Dockerfile 中创建的阶段进行复制。

    > 可以使用该COPY --from指令从单独的镜像中复制
    >
    > 可以使用本地镜像名称、本地或 Docker 注册表上可用的标签或标签 ID
    >
    > 如有必要，Docker 客户端会拉取镜像并从镜像中复制。

    ```shell
    COPY --from=nginx:latest /etc/nginx/nginx.conf /nginx.conf
    ```

  - 使用前一个阶段作为新阶段

    > 使用FROM时，可以引用之前的阶段

    ```dockerfile
    # syntax=docker/dockerfile:1
    FROM alpine:latest AS builder
    RUN apk --no-cache add build-base
    
    FROM builder AS build1
    COPY source1.cpp source.cpp
    RUN g++ -o /binary source.cpp
    
    FROM builder AS build2
    COPY source2.cpp source.cpp
    RUN g++ -o /binary source.cpp
    ```



----------

- ref
  [官方文档](https://docs.docker.com/develop/develop-images/multistage-build/)