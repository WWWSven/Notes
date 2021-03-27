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
	// ��λ��i�����Ԫ��e
	int j = 0; // ��ǰɨ�赽�ڼ���Ԫ��
	LNode *p;
	p = L;
	while (p != NULL && j < i) {
		p = p->next;
		j++;
	}
	if (p == NULL) return false;
	LNode *foo = (LNode*)malloc(sizeof(LNode));
	foo->data = e;

}
// �ϲ���������������Ϊһ������������
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
	Pc->next = Pa ? Pa : Pb;
	free(Lb);
}

void main() {
	LinkList La; InitList(La);

	LinkList Lb; InitList(Lb);
	LinkList Lc; InitList(Lc);
	MergeList(La, Lb, Lc);

}