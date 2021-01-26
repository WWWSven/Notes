#include<stdio.h>
#include<stdlib.h>
/*

注：
带头节点：写代码更方便。
不带头节点：对第一个数据节点和后续数据节点的处理需要用不同的代码逻辑
			对空表和非空表的处理需要用不同的代码逻辑。
*/
typedef struct listNode {
	int data;
	struct listNode* next;
}listNode, * linkList;

// 初始化一个单链表（带头节点）
bool initList(linkList& L) {
	L = (listNode*)malloc(sizeof(listNode)); // 分配一个头节点，头节点不存储数据
	if (L == NULL) // 内存不足，分配失败
		return false;
	L->next = NULL; // 头节点之后暂时还没有节点
	return true;
}

// 判断单链表是否为空（带头节点）
bool empty(linkList L) {
	return L->next == NULL;
}

int main() {
	linkList L; // 声明一个指向单链表的指针
	initList(L); // 初始化一个单链表
	return 0;
}
/*
	内 存
+------------+
|            |
|            |
|            |
|            |
|            |
+------------+
|    DATA    +<-------------+
|   头节点   |              |
| 不存数据！ |              |
+------------+              |
| next(null) |              |
+------------+              |
|            |              |
|            |              |
|            |              |
|            |              |
|            |              |
+---------+--+              |
|  头指针L   |+-------------+
+---------+--+
|            |
|            |
|            |
+------------+

*/