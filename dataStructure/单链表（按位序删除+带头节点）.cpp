#include<stdio.h>
#include<stdlib.h>

/*
  �ʣ�����ͷ�ڵ����Ҫ���������
  ����Ҫ����һ��Ԫ�ص�ɾ����Ҫ�����������ûд���л�����д����ʱ��2021-01-19 22:21��
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

// ��λ��ɾ��
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
	if (p == NULL) // i ֵ���Ϸ�
		return false;
	if (p->next == NULL) // ��i-1���ڵ�֮��û�������ڵ�
		return false;
	//listNode* q = p->next; // �ڵ�qָ��Ҫ��ɾ���Ľڵ�(i-1����һ���ڵ㣬Ҳ����i)
	//e = q->data; // ���ؼ���ɾ��������
	//p->next = q->next; // ��q�ӱ���ȥ��
	//free(q);
	e = p->next->data; // ���ϱ�ע�Ͳ��ֹ�����ȣ�����������ҵ�ֱ��������
	p->next = p->next->next;
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
	if (listInsert(L, 3, 2))
		printf("insert %d �ڵ�3���ڵ�! \n", L->next->next->next->data);
	// ��λɾ�� begin
	int e = NULL;
	if (listDelete(L, 2, e))
		printf("ɾ���˵�2��Ԫ�أ�%d \n", e);
	// end
	printf("--------------------��ӡ����------------------\n");
	for (int i = 0; i < 2; i++)
	{
		L = L->next;
		printf("�� %d ���ڵ�: %d \n", i + 1, L->data);
	}
	return 0;
}