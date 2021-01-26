#include<stdio.h>
#include<stdlib.h>

/*
	ɾ��ָ���ڵ�p��Ҫ�޸���ǰ���ڵ��nextָ�룻
	ָ���ڵ��ɾ����
	  1������ͷָ�룬ѭ��Ѱ��p��ǰ���ڵ㣻�����������Ƶû���ѣ�2021-01-20 13:02��
	    - ʱ�临�Ӷȣ�O��n��
	  2����p��p�ĺ�̽ڵ�������ݽ��������ɾ��p�ĺ�̽ڵ�
	    - �ŵ㣺ʱ�临�Ӷ�O��1��
		- ȱ�㣺���p�����һ���ڵ㣬Ҫʹ�õ�һ�ַ����������ָ���쳣��
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
	// һ��Сϸ�ڣ��������p==null���д��������p�����ûᾯ�棺��ʾȡ����nullָ��p������
	if (p == NULL)
		return false; 
	listNode* s = (listNode*)malloc(sizeof(listNode));
	s->data = e;
	s->next = p->next;
	p->next = s;
	return true;
}

// ����һ������Ѱ��p��ǰ���ڵ�
bool deleteNode1(listNode* p) {
	// TODO
	return false;
}

// ������������p��p��̽ڵ������
bool deleteNode2(listNode* p,int& e) {
	if (p == NULL)
		return false;
	e = p->data; // ���ر�ɾ��������
	/*
	p->data = p->next->data; // �Ȼ�����
	p->next = p->next->next;
	*/
	listNode* q = p->next; // qָ��p�ĺ�̽ڵ�
	p->data = q->data; // �Ƚ������ݣ����ָ��
	p->next = q->next; // ��ָ�룬��q�������жϿ�
	free(q);
	return true;
}

int main() {
	linkList L;
	if (initList(L))
		printf("init �ɹ�! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d �ڵ�1���ڵ�! \n", L->next->data);
	if (listInsert(L, 2, 2))
		printf("insert %d �ڵ�2���ڵ�! \n", L->next->next->data);
	if (listInsert(L, 3, 3))
		printf("insert %d �ڵ�3���ڵ�! \n", L->next->next->data);

	printf("-------��ӡ����------------------ \n");
	linkList Ltemp=L;
	for (int i = 0; i < 3; i++)
	{
		Ltemp = Ltemp->next;
		printf("�� %d ���ڵ�: %d \n", i + 1, Ltemp->data);
	}
	printf("-------��ӡ����------------------ \n");


	// ɾ����ʼ
	int e=NULL;
	if (deleteNode2(L->next->next, e))
		printf("delete ��2��Ԫ�أ�%d \n", e);
	// ɾ������

	printf("-------��ӡ����------------------ \n");
	for (int i = 0; i < 2; i++)
	{
		L = L->next;
		printf("�� %d ���ڵ�: %d \n", i + 1, L->data);
	}
	printf("-------��ӡ����------------------ \n");

	return 0;
}