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
//	������Ľ�����β�壺v1
//	- O(n)
//	- ������������
//	- ָ��r�ĳ�������Ϊû�б�Ҫÿ�ζ����������һ��Ԫ��
//*/
//linkList listTailInsert(linkList& L,int& length) {
//	length = 0; // ��¼�ڵ����
//	int x; 
//	L = (listNode*)malloc(sizeof(listNode)); // ����ͷ�ڵ�
//	listNode* s;
//	listNode* r = L; // r Ϊ��βָ��
//	printf("�������%d��Ԫ�ص�ֵ��", length + 1);
//	scanf("%d", &x); // ����ڵ��ֵ
//	while (x != 999) {
//		s = (listNode*)malloc(sizeof(listNode));
//		s->data = x;
//		r->next = s; // ��r�ڵ�����Ԫ��x
//		r = s; // rָ���µı�β�ڵ㣬��Զ����rָ�����һ���ڵ�
//		length++;
//		printf("�������%d��Ԫ�ص�ֵ��", length + 1);
//		scanf("%d", &x);
//	}
//	r->next = NULL; //β�ڵ�ָ����Ϊ��
//	return L;
//}
//
//
//int main() {
//	linkList L;
//	int sumElem;
//	L = listTailInsert(L, sumElem);
//	printf("-------------------------------\n");
//	for (int i = 0; i < sumElem; i++)
//	{
//		L = L->next;
//		printf("�� %d ���ڵ�: %d \n", i + 1, L->data);
//	}
//	return 0;
//}