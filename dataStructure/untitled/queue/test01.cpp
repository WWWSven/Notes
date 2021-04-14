//
// Created by yh on 2021/4/14.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct QNode{
    int data;
    struct QNode *next;
}QNode, *QueuePointer;
typedef struct queue{
    QueuePointer front; // 队头指针
    QueuePointer rear; // 队尾指针
}LinkQueue;

bool InitQueue(LinkQueue &Q){
    // 初始化链式存储的队列
    Q.front = Q.rear = (QNode*) malloc(sizeof(QNode));
    if(!Q.front) return false;
    Q.front->next = NULL;
    return true;
}

bool DestoryQueue(LinkQueue &Q){
    // 销毁链式存储的队列
    while (Q.front){
        Q.rear = Q.front->next;
        free(Q.front);
        Q.front = Q.rear;
    }
    return true;
}

bool EnQueue(LinkQueue &Q,int e){
    QNode* p = (QNode*) malloc(sizeof(QNode));
    if(!p) return false;
    p->data = e; p->next = NULL;
    Q.rear->next = p;
    Q.rear = p;
    return true;
}

bool DeQueue(LinkQueue &Q,int &e){
    if(Q.front == Q.rear) return false;
    QNode* p = Q.front->next;
    e = p->data;
    Q.front->next = p->next;
    if()
    free(p);
    return true;
}

// 试写一个算法判别读入的一个以‘@’为结束符的字符序列是否是“回文”。
int main(){
    printf("fuck");
    return 0;
}