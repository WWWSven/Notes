汇编语言从0开始 重制版 自学必备(配套王爽汇编语言第三版或第四版)

- https://www.bilibili.com/video/BV1mt411R7Xv

王爽教材练习题相关的仓库

- https://github.com/NekoSilverFox/Assembly

IDE

- https://github.com/Dman95/SASM

组成原理概念

- 操作码 + 操作数
- CPU 寄存器 主存 辅存
  - 地址线 数据线 控制线cccc we


debug.exe 参数

```
r 查看、修改CPU寄存器的内容；
d 查看内存中的内容；
e 改写内存中的内容；
u 将内存中的机器指令翻译成汇编指令；
t 执行一条机器指令；
a 以汇编指令的格式在内存中写入一条机器指令。
```

dosbox-0.74.conf  挂载工程目录配置

```
mount c: c:\My_ASM\ 
c:
```

一些工具

```
masm.exe: 將 .asm 組譯成 .obj 檔案
link.exe: 將 .obj 檔案連結後變成 .exe 執行檔
ml.exe: masm.exe + link.exe 方便我們快速組譯和連結 (这个我没找到)
dosxnt.exe: 使用 masm.exe 組譯時需要（这个我没用到）
debug.exe: debug 會用到
```

test.asm 的 编译 链接 运行

```
masm test
link test
test
```

