//
// Created by Sven on 2021/4/14.
//
// 假设以数组Q[m]存放循环队列中的元素，
// 同时设置一个标志tag，以tag=0和tag=1来区别在队头指针( front)和队尾指针(rear)相等时，队列状态为“空”还是“满”。
// 试写出该队列的类型定义和队列初始化（InitQueue）、插入( EnQueue))和删除( DeQueue)算法。

#include <stdio.h>

#define MaxSize 5
typedef struct sqQueue{
    int Q[MaxSize];
    int front,rear;
    int tag;
}sqQueue;
bool InitQueue(sqQueue &Q){
    Q.front = Q.rear = 0;
    Q.tag = 0;
}
bool EnQueue(sqQueue &Q, int x){
    if((Q.rear == Q.front) && (Q.tag == 1)) return false;
    Q.Q[Q.rear] = x;
    Q.rear = (Q.rear+1)%MaxSize;
    Q.tag = 1;
    return true;
}
bool DeQueue(sqQueue &Q, int &x){
    if((Q.front == Q.rear) && (Q.tag == 0)) return false;
    x = Q.Q[Q.front];
    Q.front = (Q.front+1)%MaxSize;
    Q.tag = 0;
    return true;
}
int main(){
    sqQueue sQ;
    printf(InitQueue(sQ)?"初始化循环队列成功！":"初始化循环队列失败！");
    printf(EnQueue(sQ,1)?"1入队成功！":"1入队失败,队列已经满了！");
    printf(EnQueue(sQ,2)?"2入队成功！":"2入队失败,队列已经满了！");
    printf(EnQueue(sQ,3)?"3入队成功！":"3入队失败,队列已经满了！");
    printf(EnQueue(sQ,4)?"4入队成功！":"4入队失败,队列已经满了！");
    printf(EnQueue(sQ,5)?"5入队成功！":"5入队失败,队列已经满了！");
    printf(EnQueue(sQ,6)?"6入队成功！":"6入队失败,队列已经满了！");
    printf("\n");
    int foo = 0;
    while (DeQueue(sQ, foo)){
        printf("%d出队成功！", foo);
    }
    int bar = 0;
    printf(DeQueue(sQ,bar)?"%d出队成功！":"出队失败，队列已经空了！", bar);

    return 0;
}
