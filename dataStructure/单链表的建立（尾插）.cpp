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
//	单链表的建立，尾插：v1
//	- O(n)
//	- 正向建立单链表
//	- 指针r的出现是因为没有必要每次都遍历到最后一个元素
//*/
//linkList listTailInsert(linkList& L,int& length) {
//	length = 0; // 记录节点个数
//	int x; 
//	L = (listNode*)malloc(sizeof(listNode)); // 建立头节点
//	listNode* s;
//	listNode* r = L; // r 为表尾指针
//	printf("请输入第%d个元素的值：", length + 1);
//	scanf("%d", &x); // 输入节点的值
//	while (x != 999) {
//		s = (listNode*)malloc(sizeof(listNode));
//		s->data = x;
//		r->next = s; // 在r节点后插入元素x
//		r = s; // r指向新的表尾节点，永远保持r指向最后一个节点
//		length++;
//		printf("请输入第%d个元素的值：", length + 1);
//		scanf("%d", &x);
//	}
//	r->next = NULL; //尾节点指针置为空
//	return L;
//}
//
//
//int main() {
//	linkList L;
//	int sumElem;
//	L = listTailInsert(L, sumElem);
//	printf("-------------------------------\n");
//	for (int i = 0; i < sumElem; i++)
//	{
//		L = L->next;
//		printf("第 %d 个节点: %d \n", i + 1, L->data);
//	}
//	return 0;
//}