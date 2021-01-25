//#include<stdio.h>
//const int maxSize = 10; // 定义最大长度
//struct sequenceList
//{
//	int data[maxSize]; // 用静态的“数组”存放数据元素（静态分配方式）
//	int length; // 顺序表的当前长度
//};
//
//int getElem(sequenceList L,int i) {
//	if (i>1&&i<L.length)
//	{
//		return L.data[i - 1];
//	}
//	return -1;
//}
//
//int main() {
//	sequenceList L;
//	L.data[0] = 1;
//	L.data[1] = 2;
//	L.data[2] = 3;
//	L.data[3] = 4;
//	L.data[4] = 5;
//	L.length = 5;
//	printf("getElem: %d", getElem(L, 5));
//	return 0;
//}
