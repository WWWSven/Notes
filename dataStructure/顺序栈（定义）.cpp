#include<stdio.h>

const int MaxSize = 10; // ����ջ��Ԫ�ص�������
typedef struct {
	int data[MaxSize]; // ��̬������ջ�е�Ԫ��
	int top; // ջ��ָ�루intռ4��Byte����ָ��ջ��Ԫ�ص�λ�ã������±꣩
}sequenceStack;

/*
	��ʼ��ջ
*/
void InitStack(sequenceStack& S) {
	S.top = -1; // ��ʼ��ջ��ָ��
}

/*
	�ж�ջ��
*/
bool stackEmpth(sequenceStack S) {
	if (S.top == -1)
		return true;
	else
		return false;
}

/*
	��Ԫ����ջ
*/
bool push(sequenceStack &S,int x){
	if (S.top == MaxSize - 1) // ջ�� 
		return false;
	S.top = S.top + 1; // ָ���һ
	S.data[S.top] = x; // ��Ԫ����ջ
	// S.data[++S.top] = x; // ָ������һ + ��Ԫ����ջ����������ֿ�д�ķ�ʽ�ȼۣ�
	return true;
}

