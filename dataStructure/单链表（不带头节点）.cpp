#include<stdio.h>
typedef struct listNode listNode; // ����������������ǿ������һ���ڵ㣩
typedef struct listNode* linkList; // ����������������ǿ������һ��������
/*
ע��
��ͷ�ڵ㣺ͷָ��ָ�����һ���ڵ㣨ͷ�ڵ㣩�������ʵ�ʵ�����Ԫ�أ�ͷ�ڵ���һ�����ʵ�ʵ�����Ԫ�ء�
����ͷ�ڵ㣺ͷָ��ָ�����һ���ڵ����ʵ�����ڴ�����ݵĽڵ㡣
*/
struct listNode // ���嵥����ڵ�����
{
	int data; // ÿ���ڵ���һ������Ԫ��
	listNode* next; // ָ��ָ����һ���ڵ�
};

// ��ʼ��һ���յĵ�����
bool initList(linkList& L) {
	L = NULL; // �ձ���ʱû�нڵ㣨��ֵΪnull��ֹ�����ݣ�
	return true;
}

// �жϵ������Ƿ�Ϊ��
bool empty(linkList L) {
	return L == NULL;
}

int main() {
	linkList L; // ����һ��ָ�������ָ��
	initList(L); // ��ʼ��һ���ձ�
	printf("%d", empty(L));
	return 0;
}
