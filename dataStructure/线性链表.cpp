#include <stdio.h>
#include <stdlib.h>
struct LNode
{
	int data;
	struct LNode *next;
};
typedef struct LNode LNode;
typedef struct LNode *LinkList;

bool InitList(LinkList &L) {
	L = (LNode*)malloc(sizeof(LinkList));
	if (L == NULL) return false;
	L->next = NULL;
	return true;
}
bool Insert(LinkList &L,int i,int e) {
	// 在位序i后插入元素e
	int j = 0; // 当前扫描到第几个元素
	LNode *p;
	p = L;
	while (p != NULL && j < i) {
		p = p->next;
		j++;
	}
	if (p == NULL) return false;
	LNode *foo = (LNode*)malloc(sizeof(LNode));
	foo->data = e;
	foo->next = p->next;
	p->next = foo;
	return true;
}
// 合并两个递增单链表为一个递增单链表。
void MergeList(LinkList &La, LinkList &Lb, LinkList &Lc) {
	LNode *Pa = La->next;
	LNode *Pb = Lb->next;
	LNode *Pc = La;
	Lc = Pc;
	while (Pa != NULL && Pb != NULL) {
		if (Pa->data <= Pb->data) {
			Pc->next = Pa;
			Pc = Pa;
			Pa = Pa->next;
		}
		else{
			Pc->next = Pb;
			Pc = Pb;
			Pb = Pb->next;
		}
	}
	Pc->next = Pa ? Pa : Pb; // Pa = null 就next指向Pa，否则指向Pb；
	// free Lb
	/*LNode *TempLb;
	while (Lb->next) {
		 TempLb = Lb->next;
		 Lb->next = TempLb->next;
		 free(TempLb);
	}*/
}

void InsertBySort(LinkList L, LNode *elem) {
	LNode *p = L->next;
	while (p->data < elem->data){
		p = p->next;
	}
	int foo = p->data;
	p->data = elem->data;
	elem->data = foo;
	elem->next = p->next;
	p->next = elem;
}
void main() {
	LinkList La; InitList(La);
	int j0 = 1;
	for (int i = 0; i < 5; i++){
		if (Insert(La, i, i + j0)) printf("La 插入 位序=%d 成功！\n", i + 1);
		else printf("La 插入 位序=%d 失败！\n", i + 1);
		j0++;
	}
	LinkList Lb; InitList(Lb);
	int j1 = 2;
	for (int i = 0; i < 10; i++) {
		if (Insert(Lb, i, i + j1)) printf("Lb 插入 位序=%d 成功！\n", i + 1);
		else printf("Lb 插入 位序=%d 失败！\n", i + 1);
		j1++;
	}
	LinkList Lc; InitList(Lc);
	MergeList(La, Lb, Lc);
	LinkList LcTemp = Lc; // 复制一个lc出来给insertBySort使用。
	for (int i = 0; i < 15; i++) {
		Lc = Lc->next;
		printf("第%d个结点的元素：%d！\n", i, Lc->data);
	}

	LNode *p=(LNode*)malloc(sizeof(LNode));
	p->data = 11;
	p->next = NULL;
	InsertBySort(LcTemp, p);
	for (int i = 0; i < 16; i++) {
		LcTemp = LcTemp->next;
		printf("第%d个结点的元素：%d！\n", i, LcTemp->data);
	}
}