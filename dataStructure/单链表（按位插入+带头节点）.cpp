#include<stdio.h>
#include<stdlib.h>

typedef struct linkNode { // 定义单链表节点类型
	int data; // 每个节点存放一个数据元素
	struct linkNode* next; // 指针指向下一个节点
}linkNode, * linkList;

bool initList(linkList& L) {
	L = (linkNode*)malloc(sizeof(linkNode));
	if (L == NULL)
		return false;
	L->next = NULL;
	return true;
}

bool listInsert(linkList& L, int i, int e) {
	if (i < 1)
		return false;
	linkNode* p; // p指向当前扫描到的节点
	int j = 0; // 表示当前p指向的是第几个节点
	p = L; // L指向头节点，头节点是第0个节点，不存放数据
	while (p != NULL && j < i - 1) { // 循环找到第i-1个节点
		p = p->next;
		j++;
	}
	if (p == NULL) // i的值不合法
		return false;
	linkNode* s = (linkNode*)malloc(sizeof(linkNode));
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
		printf("insert %d 在第1个节点! \n", L->next->data);
	if (listInsert(L, 2, 3))
		printf("insert %d 在第2个节点! \n", L->next->next->data);
	return 0;
}