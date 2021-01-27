#include<stdio.h>

const int MaxSize = 10; // 定义栈中元素的最大个数
typedef struct {
	int data[MaxSize]; // 静态数组存放栈中的元素
	int top; // 栈顶指针（int占4个Byte）：指向栈顶元素的位置（数组下标）
}sequenceStack;

/*
	初始化栈
*/
void InitStack(sequenceStack& S) {
	S.top = -1; // 初始化栈顶指针
}

/*
	判断栈空
*/
bool stackEmpth(sequenceStack S) {
	if (S.top == -1)
		return true;
	else
		return false;
}

/*
	新元素入栈
*/
bool push(sequenceStack &S,int x){
	if (S.top == MaxSize - 1) // 栈满 
		return false;
	S.top = S.top + 1; // 指针加一
	S.data[S.top] = x; // 新元素入栈
	// S.data[++S.top] = x; // 指针自增一 + 新元素入栈（与上两句分开写的方式等价）
	return true;
}

