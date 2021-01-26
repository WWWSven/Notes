#include<stdio.h>
#define MaxSize 10 // 定义最大长度

class 顺序表（静态分配）
{
	typedef struct {
		int data[MaxSize]; // 用静态的“数组”存放数据元素
		int length; // 顺序表的当前长度
	}SequenceList; // 顺序表的类型定义

	void InitList(SequenceList& L) {
		/*
		可省略初始化时把所有元素都赋值为0这一步
		不初始化为0，按maxsize遍历会读到内存遗留的脏数据，
		但是正常操作是按SequenceList.Length遍历，这时候就遍历不到脏数据，
		因为不应该访问顺序表当前长度的元素
		*/
		for (int i = 0; i < MaxSize; i++)
		{
			L.data[i] = 0;
		}

		// 问：int 类型默认初始化为0把，为啥还要赋值？答：初始化工作由编译器来做的，不一定初始化为0；
		L.length = 0;
	}

	int main() {
		SequenceList L;
		InitList(L);
		/*
		遍历0-MaxSize个元素是不正常的操作
		应该使用0-L.length，
		*/
		for (int i = 0; i < MaxSize; i++)
		{
			printf("data [%d]=%d \n", i, L.data[i]);
		}
		return 0;
	}
};

