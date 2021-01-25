#define _CRT_SECURE_NO_WARNINGS // 解决SDL checks对scanf的报错问题
#include<stdio.h>
#include<stdlib.h>

/*
	此处只考虑带头节点的单链表，不带头节点的自己思考。
*/
typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

/*
	头插 v1
	- 逆向建立单链表
	? L是引用类型，为啥还要返回L
*/
linkList listHeadInsert(linkList& L, int& length) {
	length = 0;
	listNode* s;
	int x = 0;
	L = (listNode*)malloc(sizeof(listNode));
	L->next = NULL;
	while (x != 999) {
		printf("请输入倒数第%d个元素的值：", length + 1);
		scanf("%d", &x);
		s = (listNode*)malloc(sizeof(listNode));
		s->data = x;
		s->next = L->next;
		L->next = s;
		length++;
	}
	return L;
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