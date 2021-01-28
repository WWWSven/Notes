#include<stdio.h>
#include<stdlib.h>

typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

bool initList(linkList& L) {
	L = NULL;
	return true;
}

bool listInsert(linkList& L, int i, int e) {
	if (i < 1)
		return false;
	// 重点begin(不带头节点的单链表在第一个节点的操作与其他节点操作不同)
	if (i == 1)
	{
		listNode* s = (listNode*)malloc(sizeof(listNode));
		s->data = e;
		s->next = L;
		L = s; // 头节点指向malloc出来的新节点
		return true;
	}
	// 重点end
	listNode* p; // 当前扫描到的节点
	int j = 1; // 当前p指向的是第几个节点
	p = L; // p指向第一个节点，注意：不是头节点（不带头节点）
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

int main() {
	linkList L;
	if (initList(L))
		printf("init 成功! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d 在第1个节点! \n", L->data);
	if (listInsert(L, 2, 3))
		printf("insert %d 在第2个节点! \n", L->next->data);
	return 0;
}