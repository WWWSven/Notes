#include<stdio.h>
#include<stdlib.h>
/*

ע��
��ͷ�ڵ㣺д��������㡣
����ͷ�ڵ㣺�Ե�һ�����ݽڵ�ͺ������ݽڵ�Ĵ�����Ҫ�ò�ͬ�Ĵ����߼�
			�Կձ�ͷǿձ�Ĵ�����Ҫ�ò�ͬ�Ĵ����߼���
*/
typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

// ��ʼ��һ����������ͷ�ڵ㣩
bool initList(linkList& L) {
	L = (listNode*)malloc(sizeof(listNode)); // ����һ��ͷ�ڵ㣬ͷ�ڵ㲻�洢����
	if (L == NULL) // �ڴ治�㣬����ʧ��
		return false;
	L->next = NULL; // ͷ�ڵ�֮����ʱ��û�нڵ�
	return true;
}

// �жϵ������Ƿ�Ϊ�գ���ͷ�ڵ㣩
bool empty(linkList L) {
	return L->next == NULL;
}

int main() {
	linkList L; // ����һ��ָ�������ָ��
	initList(L); // ��ʼ��һ��������
	return 0;
}
/*
	�� ��
+------------+
|            |
|            |
|            |
|            |
|            |
+------------+
|    DATA    +<-------------+
|   ͷ�ڵ�   |              |
| �������ݣ� |              |
+------------+              |
| next(null) |              |
+------------+              |
|            |              |
|            |              |
|            |              |
|            |              |
|            |              |
+---------+--+              |
|  ͷָ��L   |+-------------+
+---------+--+
|            |
|            |
|            |
+------------+

*/