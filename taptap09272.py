n, k = map(int, input().split())
arr = list(map(int, input().split()))

def longest_cake():
    low = 0
    high = max(arr)

    while low <= high:
        mid = low + (high - low) // 2

        count = 0
        for a in arr:
            count += a // mid

        if count < k:
            high = mid - 1
        else:
            low = mid + 1
    return high

print(longest_cake())