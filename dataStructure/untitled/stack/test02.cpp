//
// Created by yh on 2021/4/11.
//

#include "./test01.cpp" // 定义了栈的push pop init struct 等基本操作

struct LNode{
    int data;
    struct LNode *next;
};
typedef struct LNode LNode;
typedef struct LNode *LinkList;

bool InitLinkList(LinkList &L){
    L = (LNode*) malloc(sizeof(LNode));
    if(!L) return false;
    L->next = NULL;
    return true;
}
bool ListInsert(LinkList &L, int i, int e){
    // 在带头节点的单链线性表L中第i个位置之前插入元素e
    LNode* p = L;
    int j = 0; // j表示当前结点位序
    while (p && j<i-1){ // 寻找第i-1个结点
        p = p->next;
        j++;
    }
    if(!p) return false;
    LNode* foo = (LNode*) malloc(sizeof(LNode));
    foo->data = e;
    foo->next = p->next;
    p->next = foo;
    return true;
}
void bar(sqStack &S, LinkList &L){
    // 设计一个算法，利用顺序栈的基本操作逆输出单链表L中的所有元素。
    if(InitStack(S)) printf("\n初始化顺序栈S成功！ \n");
    while (L->next){
        L = L->next;
        if(Push(S, L->data)) printf("%d已push到顺序栈S! \n", L->data);
    }
    printf("单链表L的结点数据全部入栈！");
    int temp;
    while (S.base != S.top){
        Pop(S, temp);
        printf("%d, ", temp);
    }
}
int main(){
    LinkList L;
    if(InitLinkList(L)) printf("初始化链式线性表L成功！\n");
    for (int i = 0; i < 5; ++i) {
        if(ListInsert(L, i+1, i+1)) printf("单链表L插入位置i:%d,数据:%d! \n",i+1,i+1);
    }
    printf("L的元素：");
    LinkList t = L->next;
    while (t){
        printf("%d ,", t->data);
        t = t->next;
    }
    sqStack S;
    bar(S,L);
}
