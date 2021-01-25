//#include<stdio.h>
//#include<stdlib.h>
//
///*
//	跟单链表的插入用的方法一样
//*/
//
//typedef struct listNode {
//	int data;
//	struct listNode* next;
//}listNode, * linkList;
//
//// 带头节点
//bool initList(linkList& L) {
//	L = (listNode*)malloc(sizeof(listNode));
//	if (L == NULL)
//		return false;
//	L->next = NULL;
//	return true;
//}
//
//// 后插：在p节点之后插入元素e
//bool insertNextNode(listNode* p,int e) {
//	if (p == NULL)
//		return false;
//	listNode* s = (listNode*)malloc(sizeof(listNode));
//	if (s == NULL) // 内存分配失败
//		return false;
//	s->data = e; // malloc出来的新节点保存元素e
//	s->next = p->next;
//	p->next = s; // 将新节点s连接到指定节点p
//	return true;
//}
//
//// 按位插入（其中调用后插实现插入）
//bool listInsert(linkList L, int i, int e) {
//	if (i < 1)
//		return false;
//	listNode* p;
//	int j = 0;
//	p = L; // L:第零个节点，头节点，不存数据
//	while (p != NULL && j < i - 1) {
//		p = p->next;
//		j++;
//	}
//	return insertNextNode(p, e);
//}
//
//int main() {
//	linkList L;
//	if(initList(L))
//		printf("init 成功! \n");
//	if (listInsert(L, 1, 1))
//		printf("insert %d 在第1个节点! \n",L->next->data);
//	if (listInsert(L, 2, 3))
//		printf("insert %d 在第2个节点! \n",L->next->next->data);
//	if (insertNextNode(L->next, 2)) // 进行后插
//		printf("在第1个节点后插入2！ \n");
//	printf("-------------------------------\n");
//	for (int i = 0; i < 3; i++)
//	{
//		L = L->next;
//		printf("第 %d 个节点: %d \n", i, L->data);
//	}
//	return 0;
//}