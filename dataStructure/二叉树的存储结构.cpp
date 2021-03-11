#include <stdio.h>
#include <stdlib.h>

/*
	二叉树的顺序存储结构，只适合存储完全二叉树。
*/
#define MaxSize 100
struct TreeNode{
	int value;
	bool isEmpty;
};

void InitTree(TreeNode* &T) {
	for (int i = 0; i < MaxSize; i++)
	{
		T[i].isEmpty = true; // 初始化时所有节点标记为空。
	}
}
TreeNode t[MaxSize];

/*
	二叉树的链式存储
*/
typedef struct BiTNode {
	int data;
	struct BiTNode* lchild;
	struct BiTNode* rchild;
	//父节点指针：用于找到指定结点p的父结点。
	//struct BiTNode* parent;
}BiTNode, *BiTree;
void visit(BiTNode* T) {
	printf("%d \n", T->data);
}
//先序遍历
void PreOrder(BiTree T) {
	if (T!=NULL){
		visit(T); //访问根节点
		PreOrder(T->lchild); //递归遍历左子树
		PreOrder(T->rchild); //递归遍历右子树
	}
}
//求树的深度 = Max(左子树深度,右子树深度) + 1
int treeDepth(BiTree T) {
	if (T == NULL)
		return 0;
	int l = treeDepth(T->lchild);
	int r = treeDepth(T->rchild);
	return l > r ? l + 1 : r + 1;
}
//二叉树的层序遍历
/*
	初始化一个队列
	根结点入队
	若队列非空，队头结点出队，访问该节点，并将其左右孩子插入队尾（如果有的话）
	重复第三步，直到队列空。
*/
//链式队列结点
typedef struct LinkNode {
	BiTNode* data;
	struct LinkNode* next;
}LinkNode;
typedef struct {
	LinkNode* front; //队头
	LinkNode* rear; //队尾
}LinkQueue;
//初始化辅助队列
void InitQueue(LinkQueue& Q) {
	Q.front = (LinkNode*)malloc(sizeof(LinkNode));
	Q.rear = (LinkNode*)malloc(sizeof(LinkNode));
}
//根结点入队
void EnQueue(LinkQueue& Q, BiTree T) {

}
//队头结点出队
void DeQueue(LinkQueue& Q, BiTree& p) {

}
// 队列判空
bool IsEmpty(LinkQueue Q) {

}
//层序遍历
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
	//空树
	BiTree root = NULL;
	//插入根结点
	root = (BiTree)malloc(sizeof(BiTNode));
	root->data = 1;
	root->lchild = NULL;
	root->rchild = NULL;
	//插入新结点
	BiTNode* p = (BiTNode*)malloc(sizeof(BiTNode));
	p->data = 2;
	p->lchild = NULL;
	p->rchild = NULL;
	//作为根节点的左孩子
	root->lchild = p; 

	PreOrder(root);

}