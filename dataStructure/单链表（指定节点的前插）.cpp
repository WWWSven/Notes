#include<stdio.h>
#include<stdlib.h>

/*
ǰ��ʵ�֣�
  1����Ҫ����ǰ��Ľڵ��ǰ���ڵ���к�����(�������զд����Ƶû�Űѣ�2021-01-20 13:03)
    - ʱ�临�Ӷ�O��n��������ѭ�����������ڵ� .
    - ��Ҫ����ͷָ�� ��insertPriorNode(linkList L,listNode* p,elemType e).
  2����Ҫ����ǰ��Ľڵ���к�壬�����ߵ�����Ԫ�ضԵ���
    - ʱ�临�Ӷ�O��1��
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
        // ����2�����ݽڵ�ʱ��insert(L,4,4)ʱ��p��ѭ��ִ���������ʱp��=null�ˣ�
        // �Ͳ�����while������
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

// ǰ�壺��p�ڵ�֮ǰ������Ԫ��e
bool insertPriorNode(listNode* p, int e) {
    if (p == NULL)
        return false;
    listNode* s = (listNode*)malloc(sizeof(listNode));
    if (s == NULL)
        return false;
    // ���������
    s->next = p->next;
    p->next = s;
    // ������
    s->data = p->data;
    p->data = e;
    return true;
}

int main() {
    linkList L;
    if (initList(L))
        printf("init �ɹ�! \n");
    if (listInsert(L, 1, 1))
		printf("insert %d �ڵ�1���ڵ�! \n",L->next->data);
    if (listInsert(L, 2, 3))
        printf("insert %d �ڵ�2���ڵ�! \n", L->next->next->data);
    // ǰ�忪ʼ
    if (insertPriorNode(L->next->next, 2))
        printf("insert 2 �ڵڶ���Ԫ��֮ǰ��\n");
    // ǰ�����
    printf("--------------------��ӡ����------------------");
    for (int i = 0; i < 3; i++)
    {
        L = L->next;
        printf("�� %d ���ڵ�: %d \n", i + 1, L->data);
    }
    return 0;
}