//#define _CRT_SECURE_NO_WARNINGS // ���SDL checks��scanf�ı�������
//#include<stdio.h>
//#include<stdlib.h>
//
///*
//	�˴�ֻ���Ǵ�ͷ�ڵ�ĵ���������ͷ�ڵ���Լ�˼����
//*/
//typedef struct listNode {
//	int data;
//	struct listNode* next;
//}listNode, * linkList;
//
///*
//	��ͷ�ڵ�İ�λ����
//*/
//bool listInsert(linkList& L, int i, int e) {
//	if (i < 1) return false;
//	listNode* p;
//	int j = 0;
//	p = L;
//	while (p != NULL && j < i - 1) {
//		p = p->next;
//		j++;
//	}
//	if (p == NULL) return false;
//	listNode* s = (listNode*)malloc(sizeof(listNode));
//	s->data = e;
//	s->next = p->next;
//	p->next = s;
//	return true;
//}
///*
//	������Ľ�����β�壺v2
//	- O(n^2)
//	- ���ô�ͷ�ڵ�İ�λ����
//	���������͵Ĳ�������return�����˰�
//	������Ҫβ�ڵ�ָ����Ϊ�յĲ����˰�
//*/
//void listTailInsert2(linkList& L, int& length) {
//	L = (listNode*)malloc(sizeof(listNode)); // ����ͷ�ڵ�
//	length = 0;
//	int e = 0;
//	while (e != 999) {
//		printf("�������%d��Ԫ�ص�ֵ��", length + 1);
//		scanf("%d", &e); // ����ڵ��ֵ
//		listInsert(L, length + 1, e);
//		length++;
//	}
//
//}
//
//int main() {
//	linkList L;
//	int length;
//	listTailInsert2(L, length);
//	printf("-------------------------------\n");
//	for (int i = 0; i < length; i++)
//	{
//		L = L->next;
//		printf("�� %d ���ڵ�: %d \n", i + 1, L->data);
//	}
//	return 0;
//}