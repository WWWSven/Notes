#include<stdio.h>
#include<stdlib.h>

typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

bool initList(linkList& L) {
	L = NULL;
	return true;
}

bool listInsert(linkList& L, int i, int e) {
	if (i < 1)
		return false;
	// �ص�begin(����ͷ�ڵ�ĵ������ڵ�һ���ڵ�Ĳ����������ڵ������ͬ)
	if (i == 1)
	{
		listNode* s = (listNode*)malloc(sizeof(listNode));
		s->data = e;
		s->next = L;
		L = s; // ͷ�ڵ�ָ��malloc�������½ڵ�
		return true;
	}
	// �ص�end
	listNode* p; // ��ǰɨ�赽�Ľڵ�
	int j = 1; // ��ǰpָ����ǵڼ����ڵ�
	p = L; // pָ���һ���ڵ㣬ע�⣺����ͷ�ڵ㣨����ͷ�ڵ㣩
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

int main() {
	linkList L;
	if (initList(L))
		printf("init �ɹ�! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d �ڵ�1���ڵ�! \n", L->data);
	if (listInsert(L, 2, 3))
		printf("insert %d �ڵ�2���ڵ�! \n", L->next->data);
	return 0;
}