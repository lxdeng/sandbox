#! /usr/bin/python

def merge_sort_count(alist):
    print("Splitting ", alist)
 
    count = 0

    if len(alist)>1:
        mid = len(alist)/2
        left_half = alist[:mid]
        right_half = alist[mid:]

        n1 = merge_sort_count(left_half)
        n2 = merge_sort_count(right_half)
        count = n1 + n2

        print("Merging", left_half, right_half)
        i=0
        j=0
        k=0
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                alist[k]=left_half[i]
                i=i+1
            else:
                #uncomment the following to print out the reverse pairs
                #temp = i
                #while temp < len(left_half):
                #    print("reverse pair:", left_half[temp], right_half[j])
                #    temp = temp + 1
                count = count + (len(left_half) - i)
                alist[k]=right_half[j]
                j=j+1
            k=k+1

        while i < len(left_half):
            alist[k]=left_half[i]
            i=i+1
            k=k+1

        while j < len(right_half):
            alist[k]=right_half[j]
            j=j+1
            k=k+1

    return count

def brutal_reverse_pairs(alist):
    count = 0
    i = 0
    while i < len(alist):
        j = i + 1
        while j < len(alist):
            if alist[i] > alist[j]:
                print("brutal_reverse_pair: ", alist[i], alist[j])
                count = count + 1
            j = j + 1
        i = i + 1

    return count

alist = [2, 5, 3, 1]
n1 = brutal_reverse_pairs(alist)
print("brutal pairs=", n1)

n2 = merge_sort_count(alist)
print(alist)
print("pairs=", n2)
if n1 == n2:
    print("passed\n")
else:
    print("failed\n")

alist = [2, 5, 3, 1, 77, 4, 6]
n1 = brutal_reverse_pairs(alist)
print("brutal pairs=", n1)

n2 = merge_sort_count(alist)
print(alist)
print("pairs=", n2)

if n1 == n2:
    print("passed\n")
else:
    print("failed\n")

