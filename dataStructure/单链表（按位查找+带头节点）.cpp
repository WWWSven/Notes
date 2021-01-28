#include<stdio.h>
#include<stdlib.h>

/*
	查找这一节只讨论带头节点的单链表。
	不带头节点的单链表的查找操作不讨论，自己思考。
*/

typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;
bool initList(linkList& L) {
	L = (listNode*)malloc(sizeof(listNode));
	if (L == NULL)return false;
	L->next = NULL;
	return true;
}
bool listInsert(linkList& L, int i, int e) {
	if (i < 1)return false;
	listNode* p;
	int j = 0;
	p = L;
	while (p != NULL && j < i - 1) {
		p = p->next;
		j++;
	}
	if (p == NULL) return false;
	listNode* s = (listNode*)malloc(sizeof(listNode));
	s->data = e;
	s->next = p->next;
	p->next = s;
	return true;
}

// 按位查找操作开始，返回第i个元素
listNode* getElem(linkList L, int i) {
	if (i < 0)return NULL;
	listNode* p;
	int j = 0;
	p = L;
	while (p != NULL && j < i) { // 循环找到第i个节点
		p = p->next;
		j++;
	}
	return p;
}
// 结束

// 按位查找的王道书上的版本
listNode* getElem2(linkList L, int i) {
	int j = 1;
	listNode* p = L->next; // 初始指向的不是头节点，是第1个节点
	if (i == 0) return L;
	if (i < 1) return NULL;
	while (p != NULL && j < i) {
		p = p->next;
		j++;
	}
	return p;
}
// 结束

int main() {
	linkList L;
	if (initList(L))
		printf("init 成功! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d 在第1个节点! \n", L->next->data);
	if (listInsert(L, 2, 2))
		printf("insert %d 在第2个节点! \n", L->next->next->data);
	if (listInsert(L, 3, 3))
		printf("insert %d 在第3个节点! \n", L->next->next->next->data);
	printf("---------打印链表-------\n");
	linkList foo = L;
	for (int i = 0; i < 3; i++)
	{
		foo = foo->next;
		printf("第 %d 个节点: %d \n", i + 1, foo->data);
	}
	printf("-------------------------\n");
	// 按位查找
	// begin
	listNode* e = getElem(L, 1);
	if (e != NULL)printf("查找到第1个元素：%d \n", e->data);
	listNode* e2 = getElem2(L, 3);
	if (e2 != NULL)printf("查找到第3个元素(王道书版本)：%d \n", e2->data);
	// end
	return 0;
}