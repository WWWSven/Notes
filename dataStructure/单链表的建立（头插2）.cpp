#define _CRT_SECURE_NO_WARNINGS // ���SDL checks��scanf�ı�������
#include<stdio.h>
#include<stdlib.h>

typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

/*
	ָ���ڵ�ĺ�壺��p�ڵ�����Ԫ��e
*/
bool insertNextNode(listNode* p, int e) {
	if (p == NULL) return false;
	listNode* s = (listNode*)malloc(sizeof(listNode));
	if (s == NULL) return false;
	s->data = e;
	s->next = p->next;
	p->next = s;
	return true;
}

/*
	ͷ�� V2
	- ����ָ���ڵ�ĺ�����
	? �������͵�L������return ����L�˰�
*/
linkList listHeadInsert(linkList& L, int& length) {
	// ��ʼ��������
	L = (listNode*)malloc(sizeof(listNode));
	L->next = NULL;
	//��ʼ����
	length = 0;
	// x�洢scanf������Ԫ��
	int x = 0;
	while (x != 999) {
		printf("�����뵹����%d��Ԫ�ص�ֵ��", length + 1);
		scanf("%d", &x);
		insertNextNode(L, x); // ��ͷ�ڵ���к�����
		length++;
	}
	return L; // ?
}


int main() {
	linkList L;
	int length;
	listHeadInsert(L, length);
	printf("-------------------------------\n");
	for (int i = 0; i < length; i++)
	{
		L = L->next;
		printf("�� %d ���ڵ�: %d \n", i + 1, L->data);
	}
	return 0;
}