#include<stdio.h>
#include<stdlib.h>

/*
	不带头节点的单链表的长度统计不讨论，自己思考。
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

// 求表长度
int length(linkList L) {
	int len = 0;
	listNode* p = L;
	while (p->next != NULL) {
		p = p->next;
		len++;
	}
	return len;
}
// 结束

int main() {
	linkList L;
	if (initList(L))
		printf("init 成功! \n");
	if (listInsert(L, 1, 3))
		printf("insert %d 在第1个节点! \n", L->next->data);
	if (listInsert(L, 2, 2))
		printf("insert %d 在第2个节点! \n", L->next->next->data);
	if (listInsert(L, 3, 1))
		printf("insert %d 在第3个节点! \n", L->next->next->next->data);
	printf("---------打印链表-------\n");
	linkList foo = L;
	for (int i = 0; i < 3; i++)
	{
		foo = foo->next;
		printf("第 %d 个节点: %d \n", i + 1, foo->data);
	}
	printf("-------------------------\n");
	// begin
	int len = length(L);
	printf("表长：%d", len);
	// end
	return 0;
}