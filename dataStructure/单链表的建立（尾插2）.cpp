//#define _CRT_SECURE_NO_WARNINGS // 解决SDL checks对scanf的报错问题
//#include<stdio.h>
//#include<stdlib.h>
//
///*
//	此处只考虑带头节点的单链表，不带头节点的自己思考。
//*/
//typedef struct listNode {
//	int data;
//	struct listNode* next;
//}listNode, * linkList;
//
///*
//	带头节点的按位插入
//*/
//bool listInsert(linkList& L, int i, int e) {
//	if (i < 1) return false;
//	listNode* p;
//	int j = 0;
//	p = L;
//	while (p != NULL && j < i - 1) {
//		p = p->next;
//		j++;
//	}
//	if (p == NULL) return false;
//	listNode* s = (listNode*)malloc(sizeof(listNode));
//	s->data = e;
//	s->next = p->next;
//	p->next = s;
//	return true;
//}
///*
//	单链表的建立，尾插：v2
//	- O(n^2)
//	- 调用带头节点的按位插入
//	？引用类型的参数不用return链表了把
//	？不需要尾节点指针置为空的操作了把
//*/
//void listTailInsert2(linkList& L, int& length) {
//	L = (listNode*)malloc(sizeof(listNode)); // 建立头节点
//	length = 0;
//	int e = 0;
//	while (e != 999) {
//		printf("请输入第%d个元素的值：", length + 1);
//		scanf("%d", &e); // 输入节点的值
//		listInsert(L, length + 1, e);
//		length++;
//	}
//
//}
//
//int main() {
//	linkList L;
//	int length;
//	listTailInsert2(L, length);
//	printf("-------------------------------\n");
//	for (int i = 0; i < length; i++)
//	{
//		L = L->next;
//		printf("第 %d 个节点: %d \n", i + 1, L->data);
//	}
//	return 0;
//}