#! /usr/bin/python

#list=[2, 1]
#list=[2,4,3,5,1]
list=[4, 6, 7, 10, 1, 9, 2, 3, 5]

def merge_sort(x):
  print "merge_sort: " + str(x)

  length = len(x)
  if length <= 1:
    return x 
  else:
    first_half = merge_sort(x[:length/2])
    second_half = merge_sort(x[length/2:])
    return merge(first_half, second_half)

def merge(list1, list2):
  print "merge: " + str(list1) + str(list2)

  l = []
  i = 0
  j = 0
  while (i < len(list1) and j < len(list2)):
    if (list1[i] <= list2[j]):
       print "append " + str(list1[i])
       l.append(list1[i])
       i = i + 1
    else:
       print "append2 " + str(list2[j])
       l.append(list2[j])
       j = j + 1

  l = l + list1[i:]
  l = l + list2[j:]
  return l

print(merge_sort(list))
