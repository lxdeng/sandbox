# a closure is a record storing a function together with an environment
# see the following two examples:

# "anonymous closure"
# lambda here defines an anonymous function
# it can access the "x" from the enclosing function startAt()
def startAt(x):
  return (lambda y: x + y)

# the value of s1 is closure: the nested function with a free variable from the enclosing function
s1 = startAt(1)
s2 = startAt(10)
print("s1(1): ", s1(1))
print("s2(1): ", s2(1))


# the nested function has a name
# golang does not support defining nested functions of s name, but supports anonymous function
def startAt2(x):
  def increment(y):
    return x + y
  return increment

# closures need not be assigned to a variable, and can be used directly, like the following,
print("startAt2(1)(1): ", startAt2(1)(1))

t1 = startAt2(1)
print("t1(1): ", t1(1))
