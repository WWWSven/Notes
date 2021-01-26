#include<stdio.h>
#include<stdlib.h>

/*
	删除指定节点p需要修改其前驱节点的next指针；
	指定节点的删除：
	  1，传入头指针，循环寻找p的前驱节点；（这个方法视频没给把？2021-01-20 13:02）
	    - 时间复杂度：O（n）
	  2，对p和p的后继节点进行数据交换，随后删除p的后继节点
	    - 优点：时间复杂度O（1）
		- 缺点：如果p是最后一个节点，要使用第一种方法，否则空指针异常；
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
	// 一个小细节：如果不对p==null进行处理，下面对p的引用会警告：提示取消对null指针p的引用
	if (p == NULL)
		return false; 
	listNode* s = (listNode*)malloc(sizeof(listNode));
	s->data = e;
	s->next = p->next;
	p->next = s;
	return true;
}

// 方法一：遍历寻找p的前驱节点
bool deleteNode1(listNode* p) {
	// TODO
	return false;
}

// 方法二：调换p的p后继节点的数据
bool deleteNode2(listNode* p,int& e) {
	if (p == NULL)
		return false;
	e = p->data; // 返回被删除的数据
	/*
	p->data = p->next->data; // 先换数据
	p->next = p->next->next;
	*/
	listNode* q = p->next; // q指向p的后继节点
	p->data = q->data; // 先交换数据，后改指针
	p->next = q->next; // 该指针，将q从链表中断开
	free(q);
	return true;
}

int main() {
	linkList L;
	if (initList(L))
		printf("init 成功! \n");
	if (listInsert(L, 1, 1))
		printf("insert %d 在第1个节点! \n", L->next->data);
	if (listInsert(L, 2, 2))
		printf("insert %d 在第2个节点! \n", L->next->next->data);
	if (listInsert(L, 3, 3))
		printf("insert %d 在第3个节点! \n", L->next->next->data);

	printf("-------打印链表------------------ \n");
	linkList Ltemp=L;
	for (int i = 0; i < 3; i++)
	{
		Ltemp = Ltemp->next;
		printf("第 %d 个节点: %d \n", i + 1, Ltemp->data);
	}
	printf("-------打印结束------------------ \n");


	// 删除开始
	int e=NULL;
	if (deleteNode2(L->next->next, e))
		printf("delete 第2个元素：%d \n", e);
	// 删除结束

	printf("-------打印链表------------------ \n");
	for (int i = 0; i < 2; i++)
	{
		L = L->next;
		printf("第 %d 个节点: %d \n", i + 1, L->data);
	}
	printf("-------打印结束------------------ \n");

	return 0;
}