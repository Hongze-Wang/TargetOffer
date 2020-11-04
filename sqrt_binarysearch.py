def sqrt(x):
    low, high, mid = 0, x, x/2
    while abs(mid**2 - x) > 0.000001:
        if mid**2 < x:
            low = mid
        else:
            high = mid
        mid = (low+high) >> 1
    return mid