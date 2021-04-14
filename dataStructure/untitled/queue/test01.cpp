//
// Created by yh on 2021/4/14.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct QNode{
    char data;
    struct QNode *next;
}QNode, *QueuePointer;
typedef struct queue{
    QueuePointer front; // 队头指针
    QueuePointer rear; // 队尾指针
}LinkQueue;

void palindrome();

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

bool EnQueue(LinkQueue &Q,char e){
    QNode* p = (QNode*) malloc(sizeof(QNode));
    if(!p) return false;
    p->data = e; p->next = NULL;
    Q.rear->next = p;
    Q.rear = p;
    return true;
}

bool DeQueue(LinkQueue &Q,char &e){
    if(Q.front == Q.rear) return false;
    QNode* p = Q.front->next;
    e = p->data;
    Q.front->next = p->next;
    if(Q.rear == p) Q.rear = Q.front;
    free(p);
    return true;
}
void palindrome(char string[]) {
    // 试写一个算法判别读入的一个以‘@’为结束符的字符序列是否是“回文”。
    LinkQueue Q;
    InitQueue(Q); // 倒序排列
    int i = 0;
    while (string[i] != '@') i++;
    for (int j = i-1; j >= 0; j--) {
        char foo = string[j];
        EnQueue(Q, foo);
        // printf("%c 入队, ", foo);
    }
    LinkQueue Q1;
    InitQueue(Q1); // 正序排列
    for (int j = 0; j < i; ++j) {
        char foo = string[j];
        EnQueue(Q1, foo);
    }
    char foo = '\0';
    char bar = '\0';
    bool tag = false;
    while (DeQueue(Q1, foo) && DeQueue(Q, bar) && foo == bar) {
//        printf("%c, ", foo); printf("%c - ", bar);
        tag = true;
    }
    printf(tag && !(DeQueue(Q,foo) && DeQueue(Q1,bar)) ? "是回文串！" : "不是回文串！");
}

int main(){
    char string[] = "ssass@";
    palindrome(string);

    return 0;
}


