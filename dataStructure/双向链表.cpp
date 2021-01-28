#include<stdio.h>
#include<stdlib.h>

/*
	˫�����������ȡ
	��λ���ң���ֵ���Ҳ�����ֻ�ܱ���ʵ�֣����Ӷ�: O(n)
*/
typedef struct doubleNode {
	int data;
	struct doubleNode* prior;
	struct doubleNode* next;
}doubleNode, * doubleLinkList;

/*
	��ʼ��˫����
*/
bool initDoubleLinkList(doubleLinkList& L) {
	L = (doubleNode*)malloc(sizeof(doubleNode)); // ����һ��ͷ�ڵ�
	if (L == NULL) return false; // �ڴ治��
	L->prior = NULL; // ͷ�ڵ��prior��Զָ��null
	L->next = NULL; // ͷ�ڵ�֮����ʱ��û�нڵ�
	return true;
}

/*
	�ж�˫�����Ƿ�Ϊ�գ���ͷ�ڵ㣩
*/
bool empty(doubleLinkList L) {
	if (L->next == NULL) {
		return true;
	}
	else {
		return false;
	}
}

/*
	��p�ڵ�֮�����s�ڵ�
*/
bool error_insertNextDoubleNode(doubleNode* p, doubleNode* s) {
	s->next = p->next;
	p->next->prior = s;
	/*
		��p�����һ���ڵ�ʱ��p->next �� null
		null->prior ����ɿ�ָ���쳣
	*/
	s->prior = p;
	p->next = s;
	return true;
}
bool insertNextDoubleNode(doubleNode* p, doubleNode* s) {
	if (p == NULL || s == NULL) return false; // �Ƿ�����
	s->next = p->next;
	if (p->next != NULL) // ���p�ڵ���к�̽ڵ�
		p->next->prior = s;
	s->prior = p;
	p->next = s;
	return true;
}

/*
	ɾ��p�ĺ�̽ڵ�q
	- �Ҽ��ˣ�����ɾ���Ľڵ��ֵ
*/
bool deleteNextDoubleNode(doubleNode* p, int& data) {
	if (p == NULL) return false;
	doubleNode* q = p->next; // �ҵ�p�ĺ�̽ڵ�q
	data = q->data; // ����ɾ���Ľڵ��ֵ
	if (q == NULL) return false; // pû�к�̽ڵ�
	p->next = q->next;
	if (q->next != NULL) // ȷ��q�ڵ㲻�����һ���ڵ㣬�����ָ���쳣
		q->next->prior = p;
	free(q); // �ͷŽڵ�ռ�
	return true;
}

/*
	����˫����ѭ���ͷŸ������ݽڵ�
*/
void destoryList(doubleLinkList& L) {
	int e = 0; // eûɶ�ã��Ҹ���ɾ��������so��Ҫ��������
	while (L->next != NULL)
		deleteNextDoubleNode(L, e);
	free(L); // �ͷ�ͷ�ڵ� 
	L = NULL; // ͷָ��ָ��null 
}

int main() {
	doubleLinkList L;
	if (initDoubleLinkList(L))
		printf("��ʼ��˫����\n");

	// �п�
	if (empty(L))
		printf("˫����Ϊ�ձ�\n");
	else
		printf("˫�����ǿձ�\n");

	// ����Ԫ��
	doubleNode* q1 = (doubleNode*)malloc(sizeof(doubleNode));
	q1->data = 1;
	if (insertNextDoubleNode(L, q1))
		printf("��ͷ�ڵ�L�����q1��q��data=%d \n", q1->data);
	doubleNode* q2 = (doubleNode*)malloc(sizeof(doubleNode));
	q2->data = 2;
	if (insertNextDoubleNode(q1, q2))
		printf("�ڽڵ�q1�����q2��q2��data=%d \n", q2->data);
	doubleNode* q3 = (doubleNode*)malloc(sizeof(doubleNode));
	q3->data = 3;
	if (insertNextDoubleNode(q2, q3))
		printf("�ڽڵ�q2�����q3��q3��data=%d \n", q3->data);

	// ���������ڵ㣬��֤�������
	printf("----- ˫�����������ڵ�Ԫ��Ϊ ----- \n");
	doubleNode* p = L->next; // [��] pָ���һ���ڵ�
	/*
		��һ������doubleNode* p = L;
		[��] pָ��ͷ�ڵ㣬ͷ�ڵ㲻��null
		���ǽ���while��ͷ�ڵ�û��data
	*/
	while (p != NULL) {
		printf("%d \n", p->data);
		p = p->next;
	}

	// ɾ��p�ĺ�̽ڵ�
	int e = 0;
	if (deleteNextDoubleNode(q1, e))
		printf("ɾ���ڵ��ֵΪ��%d \n", e);

	// ����ǰ����������ͷ�ڵ㣩����֤ɾ������
	printf("----- ˫������ǰ�����ڵ�Ԫ��Ϊ ----- \n");
	p = q3;
	while (p->prior != NULL) {
		printf("%d \n", p->data);
		p = p->prior;
	}

	// �п�
	if (empty(L))
		printf("˫����Ϊ�ձ�\n");
	else
		printf("˫�����ǿձ�\n");

	destoryList(L);
	printf("˫���������٣�\n");

	return 0;
}