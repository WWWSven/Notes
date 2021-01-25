#include<stdio.h>
#include<stdlib.h>

/*
	����ͷ�ڵ�ĵ�����ĳ���ͳ�Ʋ����ۣ��Լ�˼����
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

// �����
int length(linkList L) {
	int len = 0;
	listNode* p = L;
	while (p->next != NULL) {
		p = p->next;
		len++;
	}
	return len;
}
// ����

int main() {
	linkList L;
	if (initList(L))
		printf("init �ɹ�! \n");
	if (listInsert(L, 1, 3))
		printf("insert %d �ڵ�1���ڵ�! \n", L->next->data);
	if (listInsert(L, 2, 2))
		printf("insert %d �ڵ�2���ڵ�! \n", L->next->next->data);
	if (listInsert(L, 3, 1))
		printf("insert %d �ڵ�3���ڵ�! \n", L->next->next->next->data);
	printf("---------��ӡ����-------\n");
	linkList foo = L;
	for (int i = 0; i < 3; i++)
	{
		foo = foo->next;
		printf("�� %d ���ڵ�: %d \n", i + 1, foo->data);
	}
	printf("-------------------------\n");
	// begin
	int len = length(L);
	printf("����%d", len);
	// end
	return 0;
}