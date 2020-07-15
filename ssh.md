- 创建以所提供的电子邮件地址为标签的新 SSH 密钥
```shell
$ ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

- 在后台启动 ssh-agent
```shell
$ eval $(ssh-agent -s)
```

- 将 SSH 私钥添加到 ssh-agent
```shell
$ ssh-add ~/.ssh/yourId_rsa
##################################
# -D :删除ssh-agent中的所有密钥   #                                                
# -d :从ssh-agent中的删除密钥     #                                                 
# -L :显示ssh-agent中的公钥       #                                                
# -l :显示ssh-agent中的密钥       #                                         
###################################
```

- 对 GitHub 尝试 ssh
```shell
$ ssh -T git@github.com
> Hi username! You've successfully authenticated, but GitHub does not provide shell access.
```

- sshConfig
```shell
#########################################
#  sshConfig for github (~/.ssh/config) #
#########################################
Host github.com
    HostName github.com
    User chengaoang
    PreferredAuthentications publickey
    IdentityFile  ~/.ssh/github
    ProxyCommand "C:\Program Files\Git\mingw64\bin\connect.exe" -S 127.0.0.1:1080 %h %p

Host gitee.com
    HostName gitee.com
    User ChenGaoAng
    PreferredAuthentications publickey
    IdentityFile  ~/.ssh/gitee
```

 
