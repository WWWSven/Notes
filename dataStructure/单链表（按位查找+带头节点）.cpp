#include<stdio.h>
#include<stdlib.h>

/*
	������һ��ֻ���۴�ͷ�ڵ�ĵ�����
	����ͷ�ڵ�ĵ�����Ĳ��Ҳ��������ۣ��Լ�˼����
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

// ��λ���Ҳ�����ʼ�����ص�i��Ԫ��
listNode* getElem(linkList L, int i) {
	if (i < 0)return NULL;
	listNode* p;
	int j = 0;
	p = L;
	while (p != NULL && j < i) { // ѭ���ҵ���i���ڵ�
		p = p->next;
		j++;
	}
	return p;
}
// ����

// ��λ���ҵ��������ϵİ汾
listNode* getElem2(linkList L, int i) {
	int j = 1;
	listNode* p = L->next; // ��ʼָ��Ĳ���ͷ�ڵ㣬�ǵ�1���ڵ�
	if (i == 0) return L;
	if (i < 1) return NULL;
	while (p != NULL && j < i) {
		p = p->next;
		j++;
	}
	return p;
}
// ����

int main() {
	linkList L;
	if (initList(L))
		printf("init �ɹ�! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d �ڵ�1���ڵ�! \n", L->next->data);
	if (listInsert(L, 2, 2))
		printf("insert %d �ڵ�2���ڵ�! \n", L->next->next->data);
	if (listInsert(L, 3, 3))
		printf("insert %d �ڵ�3���ڵ�! \n", L->next->next->next->data);
	printf("---------��ӡ����-------\n");
	linkList foo = L;
	for (int i = 0; i < 3; i++)
	{
		foo = foo->next;
		printf("�� %d ���ڵ�: %d \n", i + 1, foo->data);
	}
	printf("-------------------------\n");
	// ��λ����
	// begin
	listNode* e = getElem(L, 1);
	if (e != NULL)printf("���ҵ���1��Ԫ�أ�%d \n", e->data);
	listNode* e2 = getElem2(L, 3);
	if (e2 != NULL)printf("���ҵ���3��Ԫ��(������汾)��%d \n", e2->data);
	// end
	return 0;
}