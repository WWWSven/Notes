### 保持merge的整洁(rebase 的一种用法)

```shell
1. checkout 到 dev
2. git rebase master
3. checkout 回 master
4. git merge dev 
```

### tag

```powershell
git tag -a v1.0 -m '版本描述'	   创建本地tag
git tag -d v1.0					 删除本地tag
git push origin  --tags          向远程仓库推送tag信息
git pull origin  --tags          将远程仓库的tag信息拉到本地
git checkout v.10                切换tag
git clone -b v0.1 地址			指定tag下载代码
```

### 免密码登陆

1. https

   ```
   git remote add origin https://用户名:密码@github.com/yh/test.git
   ```

2. ssh

   1. 手动模式

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

   2. 自动模式

      - sshConfig

         ```shell
         #########################################
         #  sshConfig for win (~/.ssh/config) #
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

   3. 测试连接

       - 对 GitHub 尝试 ssh

            ```shell
            $ ssh -T git@github.com
            > Hi username! You've successfully authenticated, but GitHub does not provide shell access.
            ```

### push empty folder

```shell
find . -type d -empty -exec touch {}/.gitkeep \;
```

- https://stackoverflow.com/questions/115983/how-can-i-add-an-empty-directory-to-a-git-repository