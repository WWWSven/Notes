//#include<stdio.h>
//#define MaxSize 10 // 定义数组最大长度
//
//struct SequenceList
//{
//	int data[MaxSize]; // 用静态的“数组”存放数据元素
//	int length; // 顺序表当前的长度
//};
//
//void InitList(SequenceList & L) {
//	L.length = 0;
//}
//
//bool ListInsert(SequenceList & L, int i, int e) {
//	if (i<1 || i>L.length + 1) { // 判断插入的位置是否有效		
//		return false;
//	}
//	if (L.length >= MaxSize) { // 存储空间满了，不能插入
//		return false;
//	}
//	/*
//	 下面是一种我的经典错误
//	*/
//	//for (int j = i - 1; j < L.length; j++)
//		//L.data[j + 1] = L.data[j];
//	for (int j = L.length; j >= i; j--) 
//		L.data[j] = L.data[j - 1];
//	L.data[i - 1] = e;
//	L.length++;
//	return true;
//}
//
//int main() {
//	SequenceList L;
//	InitList(L);
//	L.data[0] = 1;
//	L.data[1] = 2;
//	L.data[2] = 4;
//	L.data[3] = 5;
//	L.length = 4;
//	ListInsert(L,3,3);
//	for (int i = 0; i < L.length; i++)
//	{
//		printf("第%d个元素：%d \n", i+1, L.data[i]);
//	}
//	return 0;
//}