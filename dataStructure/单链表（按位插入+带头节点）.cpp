#include<stdio.h>
#include<stdlib.h>

typedef struct linkNode { // ���嵥����ڵ�����
	int data; // ÿ���ڵ���һ������Ԫ��
	struct linkNode* next; // ָ��ָ����һ���ڵ�
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
	linkNode* p; // pָ��ǰɨ�赽�Ľڵ�
	int j = 0; // ��ʾ��ǰpָ����ǵڼ����ڵ�
	p = L; // Lָ��ͷ�ڵ㣬ͷ�ڵ��ǵ�0���ڵ㣬���������
	while (p != NULL && j < i - 1) { // ѭ���ҵ���i-1���ڵ�
		p = p->next;
		j++;
	}
	if (p == NULL) // i��ֵ���Ϸ�
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
		printf("init �ɹ�! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d �ڵ�1���ڵ�! \n", L->next->data);
	if (listInsert(L, 2, 3))
		printf("insert %d �ڵ�2���ڵ�! \n", L->next->next->data);
	return 0;
}