//#include<stdio.h>
//#include<stdlib.h>
//
///*
//	��������Ĳ����õķ���һ��
//*/
//
//typedef struct listNode {
//	int data;
//	struct listNode* next;
//}listNode, * linkList;
//
//// ��ͷ�ڵ�
//bool initList(linkList& L) {
//	L = (listNode*)malloc(sizeof(listNode));
//	if (L == NULL)
//		return false;
//	L->next = NULL;
//	return true;
//}
//
//// ��壺��p�ڵ�֮�����Ԫ��e
//bool insertNextNode(listNode* p,int e) {
//	if (p == NULL)
//		return false;
//	listNode* s = (listNode*)malloc(sizeof(listNode));
//	if (s == NULL) // �ڴ����ʧ��
//		return false;
//	s->data = e; // malloc�������½ڵ㱣��Ԫ��e
//	s->next = p->next;
//	p->next = s; // ���½ڵ�s���ӵ�ָ���ڵ�p
//	return true;
//}
//
//// ��λ���루���е��ú��ʵ�ֲ��룩
//bool listInsert(linkList L, int i, int e) {
//	if (i < 1)
//		return false;
//	listNode* p;
//	int j = 0;
//	p = L; // L:������ڵ㣬ͷ�ڵ㣬��������
//	while (p != NULL && j < i - 1) {
//		p = p->next;
//		j++;
//	}
//	return insertNextNode(p, e);
//}
//
//int main() {
//	linkList L;
//	if(initList(L))
//		printf("init �ɹ�! \n");
//	if (listInsert(L, 1, 1))
//		printf("insert %d �ڵ�1���ڵ�! \n",L->next->data);
//	if (listInsert(L, 2, 3))
//		printf("insert %d �ڵ�2���ڵ�! \n",L->next->next->data);
//	if (insertNextNode(L->next, 2)) // ���к��
//		printf("�ڵ�1���ڵ�����2�� \n");
//	printf("-------------------------------\n");
//	for (int i = 0; i < 3; i++)
//	{
//		L = L->next;
//		printf("�� %d ���ڵ�: %d \n", i, L->data);
//	}
//	return 0;
//}