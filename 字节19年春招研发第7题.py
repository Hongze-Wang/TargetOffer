n = int(input())
H = list(map(int, input().split()))

# greedy: last poition with energe 0
# E + E - h = 0  则E = ceil(0+h/2)
# 从后往前倒推
# E+h+1 +1是为了向上取整
def least_init_energe1(H, n):
    E = 0
    H.reverse()
    for h in H:
        E = (E+h+1) >> 1
    return E

print(least_init_energe1(H, n))

# math
# E_k = E_{k-1} -H_k
# E_k = 2^kE_0 - \sum{2^{k-i}H_i}
# E_0 >= \sum_i^N \frac{H_i}{2^i}
# E_0 = ceil(\sum_i^N \frac{H_i}{2^i})

import math
n = int(input())
H = list(int, input().split())

def least_init_energe2(H):
    E0 = 0
    for i in range(n):
        E0 += H[i] / 2**(i+1)
    return math.ceil(E0)

print(least_init_energe2(H))
