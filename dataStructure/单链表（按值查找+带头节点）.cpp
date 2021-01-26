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

// ��ֵ���Ҳ�����ʼ�����ص�i��Ԫ��
listNode* locateElem(linkList L, int e) {
	listNode* p = L->next; // p����ǰɨ�赽�Ľڵ�
	if (p != NULL && p->data != e) p = p->next; // �ӵ�һ���ڵ㿪ʼ��������Ϊe�Ľڵ�
	//ע�⣺���Ԫ�����Ͳ���int���Ǹ��ӵĽṹ���͵ȣ���Ҫ��������ж��Ƿ����
	//      ����дequals��������������صȡ�
	return p;  // �ҵ������ؽڵ㣬���򷵻�null
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
	// ��ֵ����
	// begin
	listNode* e = locateElem(L, 3);
	if (e != NULL)printf("���ҵ�ֵΪ3����һ��Ԫ���� %d  \n", e->next->data);
	e = locateElem(L, 2);
	if (e != NULL)printf("���ҵ�ֵΪ2����һ��Ԫ���� %d  \n", e->next->data);
	// end
	return 0;
}