#include<stdio.h>
#include<stdlib.h>

/*
前插实现：
  1，对要进行前插的节点的前驱节点进行后插操作(这个方法咋写？视频没放把？2021-01-20 13:03)
    - 时间复杂度O（n），必须循环遍历各个节点 .
    - 需要传入头指针 ，insertPriorNode(linkList L,listNode* p,elemType e).
  2，将要进行前插的节点进行后插，将两者的数据元素对调。
    - 时间复杂度O（1）
*/

typedef struct listNode {
    int data;
    struct listNode* next;
}listNode, * linkList;

bool initList(linkList& L) {
    L = (listNode*)malloc(sizeof(listNode));
    if (L == NULL)
        return false;
    L->next = NULL;
    return true;
}

bool listInsert(linkList& L, int i, int e) {
    if (i < 1)
        return false;
    listNode* p;
    int j = 0;
    p = L;
    while (p != NULL && j < i - 1) { 
        // 当有2个数据节点时，insert(L,4,4)时，p在循环执行完第三次时p就=null了，
        // 就不符合while条件了
        p = p->next;
        j++;
    }
    if (p == NULL)
        return false;
    listNode* s = (listNode*)malloc(sizeof(listNode));
    s->data = e;
    s->next = p->next;
    p->next = s;
    return true;
}

// 前插：在p节点之前插入新元素e
bool insertPriorNode(listNode* p, int e) {
    if (p == NULL)
        return false;
    listNode* s = (listNode*)malloc(sizeof(listNode));
    if (s == NULL)
        return false;
    // 先正常后插
    s->next = p->next;
    p->next = s;
    // 换数据
    s->data = p->data;
    p->data = e;
    return true;
}

int main() {
    linkList L;
    if (initList(L))
        printf("init 成功! \n");
    if (listInsert(L, 1, 1))
		printf("insert %d 在第1个节点! \n",L->next->data);
    if (listInsert(L, 2, 3))
        printf("insert %d 在第2个节点! \n", L->next->next->data);
    // 前插开始
    if (insertPriorNode(L->next->next, 2))
        printf("insert 2 在第二个元素之前！\n");
    // 前插结束
    printf("--------------------打印链表------------------");
    for (int i = 0; i < 3; i++)
    {
        L = L->next;
        printf("第 %d 个节点: %d \n", i + 1, L->data);
    }
    return 0;
}