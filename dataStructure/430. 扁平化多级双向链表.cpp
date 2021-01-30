#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;

typedef struct Node {
	int data;
	struct Node* next;
	struct Node* prev;
	struct Node* child;
}dNode, * dLinkList;

bool initList(dLinkList& L) {
	L = (Node*)malloc(sizeof(Node));
	L->next = NULL;
	L->prev = NULL;
	L->child = NULL;
	return true;
}

int getLength(dLinkList L) {
	int length = 0;
	dLinkList temp = L;
	while (temp->next != NULL) {
		length++;
		temp = temp->next;
	}
	return length;
}

bool printList(dLinkList L) {
	if (L == NULL) return false;
	int length = getLength(L);
	dLinkList temp = L->next;
	for (int i = 0; i < length; i++)
	{
		if (i==0)
			printf("%d", temp->data);
		else
			printf(", %d", temp->data);
		temp = temp->next;
	}
	printf(" !");
	return true;
}
// 带头节点的双链表的后插入新节点s
bool listInsertOnEnd(dLinkList L,int data) {
	Node* p = L;
	int i = getLength(L);
	int j = 0;
	while (p != NULL && j<i) { // and 后边这个参数简直无敌，，，wdtmd
		p = p->next;
		j++;
	}
	if (p == NULL) return false;
	Node* s = (Node*)malloc(sizeof(Node));
	s->data = data;
	s->next = NULL;
	s->prev = p;
	p->next = s;
	return true;
}


Node* flatten(Node* head) {
	if (!head)return nullptr;
	Node* cur = head;
	while (cur) {
		Node* nxt = cur->next;
		if (cur->child) {
			//1、存在孩子节点，将child与cur之间的孩子连接改为双向连接
			Node* _child = cur->child;
			cur->next = _child;
			_child->prev = cur;
			cur->child = nullptr;
			//2、获取child这一子链表的尾节点，便于插入到cur的后面
			Node* tail = _child;
			while (tail && tail->next) {
				tail = tail->next;
			}
			//3、将[child,tail]这段链表插入到cur和nxt之间的位置
			tail->next = nxt;
			if (nxt) {
				nxt->prev = tail;
			}
		}
		cur = cur->next;
	}
	return head;
}


int main() {
	dLinkList L;
	if (initList(L)) cout << "初始化成功! " << endl;
	cout << "length=" << getLength(L) << endl;
	//输入：[1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12]
	listInsertOnEnd(L, 1);
	listInsertOnEnd(L, 2);
	listInsertOnEnd(L, 3);
	listInsertOnEnd(L, 4);
	listInsertOnEnd(L, 5);
	listInsertOnEnd(L, 6);
	listInsertOnEnd(L, NULL);
	listInsertOnEnd(L, NULL);
	listInsertOnEnd(L, NULL);
	listInsertOnEnd(L, 7);
	listInsertOnEnd(L, 8);
	listInsertOnEnd(L, 9);
	listInsertOnEnd(L, 10);
	listInsertOnEnd(L, NULL);
	listInsertOnEnd(L, NULL);
	listInsertOnEnd(L, 11);
	listInsertOnEnd(L, 12);
	cout << "length=" << getLength(L) << endl;
	printList(L);
	// child
	// 值为3的node
	Node* nodeOf3 = L->next->next->next;
	// 值为7的node
	Node* nodeOf7 = nodeOf3->next->next->next->next->next->next->next;
	// 值为8的node
	Node* nodeOf8 = nodeOf7->next;
	// 值为11的node
	Node* nodeOf11 = nodeOf8->next->next->next->next->next;
	nodeOf3->child = nodeOf7;
	nodeOf8->child = nodeOf11;
	//输出：[1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6]
	Node* temp = flatten(L);
	printList(temp);

	return 0;
}

