//
// Created by yh on 2021/4/10.
//
#include <stdio.h>
#include <stdlib.h>

#define STACK_SIZE 5

struct sqStack{
    int* base;
    int* top;
    int stackSize;
};
typedef struct sqStack sqStack;

bool InitStack(sqStack &S){
    // 构造一个空栈
    S.base = (int*) malloc(sizeof(int) * STACK_SIZE);
    if(!S.base) return false;
    S.top = S.base;
    S.stackSize = STACK_SIZE;
    return true;
}
bool Push(sqStack &S, int e){
    // 插入元素e为新的栈顶元素
    if(S.top - S.base >= S.stackSize) return false;
    *S.top++ = e;
    return true;
}
bool Pop(sqStack &S,int &e){
    // 如栈不空，删除栈顶元素，并通过e返回
    if(S.top==S.base) return false;
    e = *--S.top;
    return true;
}
/*
[算法设计] 设从键盘输入一整数的序列：a1,a2,a3,…,an
      试编写算法实现：用栈结构存储输入的整数，
      当ai≠-1时，将ai进栈；
      当ai=-1时，输出栈顶整数并出栈。
      算法应对异常情况(入栈满等)给出相应的信息。
*/
void foo(sqStack &S){
    int i; scanf("%u", &i);
    if(i == -1){
        int e;
        if(!Pop(S, e))
            printf("栈S空了! \n");
        else
            printf("栈顶数：%d! \n",e);
    }else{
        if(!Push(S, i))
            printf("栈S满了！\n");
        else
            printf("%d,入栈！\n",i);
    }
}
int main11(){
    sqStack S;
    if(InitStack(S)) printf("初始化stack S成功！\n");
    while (true){
        foo(S);
    }
}
