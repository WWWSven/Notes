#include<stdio.h>

/*
	栈：只允许在一端插入&删除的线性表。
	顺序栈：以顺序存储方式实现的栈。
	? 思考在初始化栈操作中，栈顶指针指向下一个可以插入的位置，相关操作如何改动
	  既：S.top = 0;
*/

const int MaxSize = 10; // 定义栈中元素的最大个数
typedef struct {
	int data[MaxSize]; // 静态数组存放栈中的元素
	int top; // 栈顶指针（int占4个Byte）：指向栈顶元素的位置（数组下标）
}sequenceStack;

/*
	初始化栈
*/
void initStack(sequenceStack& S) {
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
bool push(sequenceStack& S, int x) {
	if (S.top == MaxSize - 1) // 栈满 
		return false;
	S.top = S.top + 1; // 指针加一
	S.data[S.top] = x; // 新元素入栈
	// S.data[++S.top] = x; // 指针自增一 + 新元素入栈（与上两句分开写的方式等价）
	return true;
}

/*
	出栈
	- 逻辑上删除了元素，实际上元素还在内存里。
*/
bool pop(sequenceStack& S, int& x) {
	if (S.top == -1) return false; // 空栈，报错
	x = S.data[S.top]; // 栈顶元素先出栈
	S.top = S.top - 1; // 指针减一
	// x = S.data[S.top--];
	return true;
}

/*
	读取栈顶元素
*/
bool getTop(sequenceStack S, int& x) {
	if (S.top == -1) return false;
	x = S.data[S.top];
	return true;
}

int main() {
	// 声明顺序栈
	sequenceStack S;
	
	// 初始化栈
	initStack(S);
	printf("initStack 执行！\n");

	// 打印当前栈是否为空
	if (stackEmpth(S))
		printf("当前栈为空！\n");
	else
		printf("当前栈非空！\n");
	
	/*
		元素入栈并打印出刚刚入栈的元素
	*/
	int x = 0; // 记录getTop出来的栈顶元素的值
	if (push(S, 1)) {
		getTop(S, x);
		printf("新元素 %d 入栈！\n", x);
	}
	if (push(S, 2)) {
		getTop(S, x);
		printf("新元素 %d 入栈！\n", x);
	}
	if (push(S, 2333)) {
		getTop(S, x);
		printf("新元素 %d 入栈！\n", x);
	}

	// 打印当前栈是否为空
	if (stackEmpth(S))
		printf("当前栈为空！\n");
	else
		printf("当前栈非空！\n");

	/*
		打印栈中的全部元素
		- 副作用：栈元素最终全部出栈
	*/
	printf("----- 栈元素如下 ----- \n");
	while (getTop(S, x)) {
		printf("%d \n",x);
		pop(S,x);
	}

	return 0;
}

