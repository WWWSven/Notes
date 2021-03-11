#include <stdio.h>
#include <stdlib.h>

/*
	��������˳��洢�ṹ��ֻ�ʺϴ洢��ȫ��������
*/
#define MaxSize 100
struct TreeNode{
	int value;
	bool isEmpty;
};

void InitTree(TreeNode* &T) {
	for (int i = 0; i < MaxSize; i++)
	{
		T[i].isEmpty = true; // ��ʼ��ʱ���нڵ���Ϊ�ա�
	}
}
TreeNode t[MaxSize];

/*
	����������ʽ�洢
*/
typedef struct BiTNode {
	int data;
	struct BiTNode* lchild;
	struct BiTNode* rchild;
	//���ڵ�ָ�룺�����ҵ�ָ�����p�ĸ���㡣
	//struct BiTNode* parent;
}BiTNode, *BiTree;
void visit(BiTNode* T) {
	printf("%d \n", T->data);
}
//�������
void PreOrder(BiTree T) {
	if (T!=NULL){
		visit(T); //���ʸ��ڵ�
		PreOrder(T->lchild); //�ݹ����������
		PreOrder(T->rchild); //�ݹ����������
	}
}
//��������� = Max(���������,���������) + 1
int treeDepth(BiTree T) {
	if (T == NULL)
		return 0;
	int l = treeDepth(T->lchild);
	int r = treeDepth(T->rchild);
	return l > r ? l + 1 : r + 1;
}
//�������Ĳ������
/*
	��ʼ��һ������
	��������
	�����зǿգ���ͷ�����ӣ����ʸýڵ㣬���������Һ��Ӳ����β������еĻ���
	�ظ���������ֱ�����пա�
*/
//��ʽ���н��
typedef struct LinkNode {
	BiTNode* data;
	struct LinkNode* next;
}LinkNode;
typedef struct {
	LinkNode* front; //��ͷ
	LinkNode* rear; //��β
}LinkQueue;
//��ʼ����������
void InitQueue(LinkQueue& Q) {
	Q.front = (LinkNode*)malloc(sizeof(LinkNode));
	Q.rear = (LinkNode*)malloc(sizeof(LinkNode));
}
//��������
void EnQueue(LinkQueue& Q, BiTree T) {

}
//��ͷ������
void DeQueue(LinkQueue& Q, BiTree& p) {

}
// �����п�
bool IsEmpty(LinkQueue Q) {

}
//�������
void LevelOrder(BiTree T) {
	LinkQueue Q;
	InitQueue(Q);
	BiTree p;
	EnQueue(Q, T);
	while (!IsEmpty(Q)){
		DeQueue(Q, p);
		visit(p);
		if (p->lchild != NULL)
			EnQueue(Q, p->lchild);
		else if (p->rchild != NULL)
			EnQueue(Q, p->rchild);
	}
}
void main() {
	//����
	BiTree root = NULL;
	//��������
	root = (BiTree)malloc(sizeof(BiTNode));
	root->data = 1;
	root->lchild = NULL;
	root->rchild = NULL;
	//�����½��
	BiTNode* p = (BiTNode*)malloc(sizeof(BiTNode));
	p->data = 2;
	p->lchild = NULL;
	p->rchild = NULL;
	//��Ϊ���ڵ������
	root->lchild = p; 

	PreOrder(root);

}