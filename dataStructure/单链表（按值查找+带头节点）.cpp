#include<stdio.h>
#include<stdlib.h>

/*
	查找这一节只讨论带头节点的单链表。
	不带头节点的单链表的查找操作不讨论，自己思考。
*/

typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;
bool initList(linkList& L) {
	L = (listNode*)malloc(sizeof(listNode));
	if (L == NULL)return false;
	L->next = NULL;
	return true;
}
bool listInsert(linkList& L, int i, int e) {
	if (i < 1)return false;
	listNode* p;
	int j = 0;
	p = L;
	while (p != NULL && j < i - 1) {
		p = p->next;
		j++;
	}
	if (p == NULL) return false;
	listNode* s = (listNode*)malloc(sizeof(listNode));
	s->data = e;
	s->next = p->next;
	p->next = s;
	return true;
}

// 按值查找操作开始，返回第i个元素
listNode* locateElem(linkList L, int e) {
	listNode* p = L->next; // p代表当前扫描到的节点
	if (p != NULL && p->data != e) p = p->next; // 从第一个节点开始查找数据为e的节点
	//注意：如果元素类型不是int，是复杂的结构类型等，需要额外操作判断是否相等
	//      如书写equals方法，运算符重载等。
	return p;  // 找到即返回节点，否则返回null
}
// 结束

int main() {
	linkList L;
	if (initList(L))
		printf("init 成功! \n");
	if (listInsert(L, 1, 3))
		printf("insert %d 在第1个节点! \n", L->next->data);
	if (listInsert(L, 2, 2))
		printf("insert %d 在第2个节点! \n", L->next->next->data);
	if (listInsert(L, 3, 1))
		printf("insert %d 在第3个节点! \n", L->next->next->next->data);
	printf("---------打印链表-------\n");
	linkList foo = L;
	for (int i = 0; i < 3; i++)
	{
		foo = foo->next;
		printf("第 %d 个节点: %d \n", i + 1, foo->data);
	}
	printf("-------------------------\n");
	// 按值查找
	// begin
	listNode* e = locateElem(L, 3);
	if (e != NULL)printf("查找到值为3的下一个元素是 %d  \n", e->next->data);
	e = locateElem(L, 2);
	if (e != NULL)printf("查找到值为2的下一个元素是 %d  \n", e->next->data);
	// end
	return 0;
}