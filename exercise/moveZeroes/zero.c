#include <stdio.h>

/*
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/

void moveZeroes(int* nums, int numsSize) {
    int i = 0;
    int j;

    while (1) {
        while (i < numsSize && nums[i] != 0) ++i;
        if (i >= numsSize) break;

        j = i + 1;
        while (j < numsSize && nums[j] == 0) ++j;
        if (j >= numsSize) break;

        nums[i] = nums[j];
        nums[j] = 0;
        ++i;
    }
}

int main() {
	int a[] = {0, 1, 0, 3, 12};
	int numsSize = 5;
	moveZeroes(a, numsSize);
	for(int i = 0; i < numsSize; i++) {
		printf("%d\n", a[i]);
	}
}
