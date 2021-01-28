#include<stdio.h>
typedef struct listNode listNode; // 数据类型重命名（强调这是一个节点）
typedef struct listNode* linkList; // 数据类型重命名（强调这是一个单链表）
/*
注：
带头节点：头指针指向的下一个节点（头节点），不存放实际的数据元素，头节点下一个存放实际的数据元素。
不带头节点：头指针指向的下一个节点就是实际用于存放数据的节点。
*/
struct listNode // 定义单链表节点类型
{
	int data; // 每个节点存放一个数据元素
	listNode* next; // 指针指向下一个节点
};

// 初始化一个空的单链表
bool initList(linkList& L) {
	L = NULL; // 空表，暂时没有节点（赋值为null防止脏数据）
	return true;
}

// 判断单链表是否为空
bool empty(linkList L) {
	return L == NULL;
}

int main() {
	linkList L; // 声明一个指向单链表的指针
	initList(L); // 初始化一个空表
	printf("%d", empty(L));
	return 0;
}
