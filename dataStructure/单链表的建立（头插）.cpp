#define _CRT_SECURE_NO_WARNINGS // ���SDL checks��scanf�ı�������
#include<stdio.h>
#include<stdlib.h>

/*
	�˴�ֻ���Ǵ�ͷ�ڵ�ĵ���������ͷ�ڵ���Լ�˼����
*/
typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

/*
	ͷ�� v1
	- ������������
	? L���������ͣ�Ϊɶ��Ҫ����L
*/
linkList listHeadInsert(linkList& L, int& length) {
	length = 0;
	listNode* s;
	int x = 0;
	L = (listNode*)malloc(sizeof(listNode));
	L->next = NULL;
	while (x != 999) {
		printf("�����뵹����%d��Ԫ�ص�ֵ��", length + 1);
		scanf("%d", &x);
		s = (listNode*)malloc(sizeof(listNode));
		s->data = x;
		s->next = L->next;
		L->next = s;
		length++;
	}
	return L;
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