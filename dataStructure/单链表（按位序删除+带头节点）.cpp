#include<stdio.h>
#include<stdlib.h>

/*
  问：不带头节点的需要特殊操作吗？
  答：需要，第一个元素的删除需要特殊操作，我没写，有机会再写（计时：2021-01-19 22:21）
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

// 按位序删除
bool listDelete(linkList& L, int i, int& e) {
	if (i < 1)
		return false;
	listNode* p;
	int j = 0;
	p = L;
	while (p != NULL && j < i - 1) {
		p = p->next;
		j++;
	}
	if (p == NULL) // i 值不合法
		return false;
	if (p->next == NULL) // 第i-1个节点之后没有其他节点
		return false;
	//listNode* q = p->next; // 节点q指向要背删除的节点(i-1的下一个节点，也就是i)
	//e = q->data; // 返回即将删除的数据
	//p->next = q->next; // 将q从表中去除
	//free(q);
	e = p->next->data; // 与上边注释部分功能相等，我这个符合我的直觉，，，
	p->next = p->next->next;
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
	if (listInsert(L, 3, 2))
		printf("insert %d 在第3个节点! \n", L->next->next->next->data);
	// 按位删除 begin
	int e = NULL;
	if (listDelete(L, 2, e))
		printf("删除了第2个元素：%d \n", e);
	// end
	printf("--------------------打印链表------------------\n");
	for (int i = 0; i < 2; i++)
	{
		L = L->next;
		printf("第 %d 个节点: %d \n", i + 1, L->data);
	}
	return 0;
}