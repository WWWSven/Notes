#define _CRT_SECURE_NO_WARNINGS // 解决SDL checks对scanf的报错问题
#include<stdio.h>
#include<stdlib.h>

typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

/*
	指定节点的后插：在p节点后插入元素e
*/
bool insertNextNode(listNode* p, int e) {
	if (p == NULL) return false;
	listNode* s = (listNode*)malloc(sizeof(listNode));
	if (s == NULL) return false;
	s->data = e;
	s->next = p->next;
	p->next = s;
	return true;
}

/*
	头插 V2
	- 调用指定节点的后插操作
	? 引用类型的L，不用return 链表L了把
*/
linkList listHeadInsert(linkList& L, int& length) {
	// 初始化单链表
	L = (listNode*)malloc(sizeof(listNode));
	L->next = NULL;
	//初始化表长
	length = 0;
	// x存储scanf出来的元素
	int x = 0;
	while (x != 999) {
		printf("请输入倒数第%d个元素的值：", length + 1);
		scanf("%d", &x);
		insertNextNode(L, x); // 对头节点进行后插操作
		length++;
	}
	return L; // ?
}


int main() {
	linkList L;
	int length;
	listHeadInsert(L, length);
	printf("-------------------------------\n");
	for (int i = 0; i < length; i++)
	{
		L = L->next;
		printf("第 %d 个节点: %d \n", i + 1, L->data);
	}
	return 0;
}