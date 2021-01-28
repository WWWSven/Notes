#include<stdio.h>
#include<stdlib.h>

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
// 王道书同款
bool insertPriorNode(listNode* p, listNode* s) {
	if (p == NULL || s == NULL)
		return false;
	s->next = p->next;
	p->next = s;
	int temp = p->data;
	p->data = s->data;
	s->data = temp;
	return true;
}

int main() {
	linkList L;
	if (initList(L))
		printf("init 成功! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d 在第1个节点! \n", L->next->data);
	if (listInsert(L, 2, 3))
		printf("insert %d 在第2个节点! \n", L->next->next->data);
	// 构造一个节点
	listNode* S = (listNode*)malloc(sizeof(listNode));
	S->next = NULL;
	S->data = 2;
	// 前插开始
	if (insertPriorNode(L->next->next, S))
		printf("insert 2 在第二个元素之前！\n");
	// 前插结束
	printf("--------------------打印链表------------------\n");
	for (int i = 0; i < 3; i++)
	{
		L = L->next;
		printf("第 %d 个节点: %d \n", i + 1, L->data);
	}
	return 0;
}