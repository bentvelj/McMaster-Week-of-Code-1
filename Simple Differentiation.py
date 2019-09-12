import sys

n = int(input());

input = sys.stdin.readline;
for i in range(n):

    nums = list(map(int, input().split()))
    a = nums[0];
    b = nums[1];
    x = nums[2];
    
    print(a*b*x**(b-1));

