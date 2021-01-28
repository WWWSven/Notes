#include<stdio.h>
#include<stdlib.h>

/*
	双链表不可随机存取
	按位查找，按值查找操作都只能遍历实现，复杂度: O(n)
*/
typedef struct doubleNode {
	int data;
	struct doubleNode* prior;
	struct doubleNode* next;
}doubleNode, * doubleLinkList;

/*
	初始化双链表
*/
bool initDoubleLinkList(doubleLinkList& L) {
	L = (doubleNode*)malloc(sizeof(doubleNode)); // 分配一个头节点
	if (L == NULL) return false; // 内存不足
	L->prior = NULL; // 头节点的prior永远指向null
	L->next = NULL; // 头节点之后暂时还没有节点
	return true;
}

/*
	判断双链表是否为空（带头节点）
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
	在p节点之后插入s节点
*/
bool error_insertNextDoubleNode(doubleNode* p, doubleNode* s) {
	s->next = p->next;
	p->next->prior = s;
	/*
		当p是最后一个节点时：p->next 是 null
		null->prior 会造成空指针异常
	*/
	s->prior = p;
	p->next = s;
	return true;
}
bool insertNextDoubleNode(doubleNode* p, doubleNode* s) {
	if (p == NULL || s == NULL) return false; // 非法参数
	s->next = p->next;
	if (p->next != NULL) // 如果p节点后有后继节点
		p->next->prior = s;
	s->prior = p;
	p->next = s;
	return true;
}

/*
	删除p的后继节点q
	- 我加了：返回删除的节点的值
*/
bool deleteNextDoubleNode(doubleNode* p, int& data) {
	if (p == NULL) return false;
	doubleNode* q = p->next; // 找到p的后继节点q
	data = q->data; // 返回删除的节点的值
	if (q == NULL) return false; // p没有后继节点
	p->next = q->next;
	if (q->next != NULL) // 确定q节点不是最后一个节点，避免空指针异常
		q->next->prior = p;
	free(q); // 释放节点空间
	return true;
}

/*
	销毁双链表，循环释放各个数据节点
*/
void destoryList(doubleLinkList& L) {
	int e = 0; // e没啥用，我改了删除操作，so，要两个参数
	while (L->next != NULL)
		deleteNextDoubleNode(L, e);
	free(L); // 释放头节点 
	L = NULL; // 头指针指向null 
}

int main() {
	doubleLinkList L;
	if (initDoubleLinkList(L))
		printf("初始化双链表！\n");

	// 判空
	if (empty(L))
		printf("双链表为空表！\n");
	else
		printf("双链表不是空表！\n");

	// 插入元素
	doubleNode* q1 = (doubleNode*)malloc(sizeof(doubleNode));
	q1->data = 1;
	if (insertNextDoubleNode(L, q1))
		printf("在头节点L后插入q1，q的data=%d \n", q1->data);
	doubleNode* q2 = (doubleNode*)malloc(sizeof(doubleNode));
	q2->data = 2;
	if (insertNextDoubleNode(q1, q2))
		printf("在节点q1后插入q2，q2的data=%d \n", q2->data);
	doubleNode* q3 = (doubleNode*)malloc(sizeof(doubleNode));
	q3->data = 3;
	if (insertNextDoubleNode(q2, q3))
		printf("在节点q2后插入q3，q3的data=%d \n", q3->data);

	// ！向后遍历节点，验证插入操作
	printf("----- 双链表向后遍历节点元素为 ----- \n");
	doubleNode* p = L->next; // [对] p指向第一个节点
	/*
		上一句若：doubleNode* p = L;
		[错] p指向头节点，头节点不是null
		但是进入while后头节点没有data
	*/
	while (p != NULL) {
		printf("%d \n", p->data);
		p = p->next;
	}

	// 删除p的后继节点
	int e = 0;
	if (deleteNextDoubleNode(q1, e))
		printf("删除节点的值为：%d \n", e);

	// ！向前遍历（跳过头节点），验证删除操作
	printf("----- 双链表向前遍历节点元素为 ----- \n");
	p = q3;
	while (p->prior != NULL) {
		printf("%d \n", p->data);
		p = p->prior;
	}

	// 判空
	if (empty(L))
		printf("双链表为空表！\n");
	else
		printf("双链表不是空表！\n");

	destoryList(L);
	printf("双链表已销毁！\n");

	return 0;
}