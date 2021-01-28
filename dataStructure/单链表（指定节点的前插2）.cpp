#include<stdio.h>
#include<stdlib.h>

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
// ������ͬ��
bool insertPriorNode(listNode* p, listNode* s) {
	if (p == NULL || s == NULL)
		return false;
	s->next = p->next;
	p->next = s;
	int temp = p->data;
	p->data = s->data;
	s->data = temp;
	return true;
}

int main() {
	linkList L;
	if (initList(L))
		printf("init �ɹ�! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d �ڵ�1���ڵ�! \n", L->next->data);
	if (listInsert(L, 2, 3))
		printf("insert %d �ڵ�2���ڵ�! \n", L->next->next->data);
	// ����һ���ڵ�
	listNode* S = (listNode*)malloc(sizeof(listNode));
	S->next = NULL;
	S->data = 2;
	// ǰ�忪ʼ
	if (insertPriorNode(L->next->next, S))
		printf("insert 2 �ڵڶ���Ԫ��֮ǰ��\n");
	// ǰ�����
	printf("--------------------��ӡ����------------------\n");
	for (int i = 0; i < 3; i++)
	{
		L = L->next;
		printf("�� %d ���ڵ�: %d \n", i + 1, L->data);
	}
	return 0;
}