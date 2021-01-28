#include<stdio.h>

/*
	ջ��ֻ������һ�˲���&ɾ�������Ա�
	˳��ջ����˳��洢��ʽʵ�ֵ�ջ��
	? ˼���ڳ�ʼ��ջ�����У�ջ��ָ��ָ����һ�����Բ����λ�ã���ز�����θĶ�
	  �ȣ�S.top = 0;
*/

const int MaxSize = 10; // ����ջ��Ԫ�ص�������
typedef struct {
	int data[MaxSize]; // ��̬������ջ�е�Ԫ��
	int top; // ջ��ָ�루intռ4��Byte����ָ��ջ��Ԫ�ص�λ�ã������±꣩
}sequenceStack;

/*
	��ʼ��ջ
*/
void initStack(sequenceStack& S) {
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
bool push(sequenceStack& S, int x) {
	if (S.top == MaxSize - 1) // ջ�� 
		return false;
	S.top = S.top + 1; // ָ���һ
	S.data[S.top] = x; // ��Ԫ����ջ
	// S.data[++S.top] = x; // ָ������һ + ��Ԫ����ջ����������ֿ�д�ķ�ʽ�ȼۣ�
	return true;
}

/*
	��ջ
	- �߼���ɾ����Ԫ�أ�ʵ����Ԫ�ػ����ڴ��
*/
bool pop(sequenceStack& S, int& x) {
	if (S.top == -1) return false; // ��ջ������
	x = S.data[S.top]; // ջ��Ԫ���ȳ�ջ
	S.top = S.top - 1; // ָ���һ
	// x = S.data[S.top--];
	return true;
}

/*
	��ȡջ��Ԫ��
*/
bool getTop(sequenceStack S, int& x) {
	if (S.top == -1) return false;
	x = S.data[S.top];
	return true;
}

int main() {
	// ����˳��ջ
	sequenceStack S;
	
	// ��ʼ��ջ
	initStack(S);
	printf("initStack ִ�У�\n");

	// ��ӡ��ǰջ�Ƿ�Ϊ��
	if (stackEmpth(S))
		printf("��ǰջΪ�գ�\n");
	else
		printf("��ǰջ�ǿգ�\n");
	
	/*
		Ԫ����ջ����ӡ���ո���ջ��Ԫ��
	*/
	int x = 0; // ��¼getTop������ջ��Ԫ�ص�ֵ
	if (push(S, 1)) {
		getTop(S, x);
		printf("��Ԫ�� %d ��ջ��\n", x);
	}
	if (push(S, 2)) {
		getTop(S, x);
		printf("��Ԫ�� %d ��ջ��\n", x);
	}
	if (push(S, 2333)) {
		getTop(S, x);
		printf("��Ԫ�� %d ��ջ��\n", x);
	}

	// ��ӡ��ǰջ�Ƿ�Ϊ��
	if (stackEmpth(S))
		printf("��ǰջΪ�գ�\n");
	else
		printf("��ǰջ�ǿգ�\n");

	/*
		��ӡջ�е�ȫ��Ԫ��
		- �����ã�ջԪ������ȫ����ջ
	*/
	printf("----- ջԪ������ ----- \n");
	while (getTop(S, x)) {
		printf("%d \n",x);
		pop(S,x);
	}

	return 0;
}

