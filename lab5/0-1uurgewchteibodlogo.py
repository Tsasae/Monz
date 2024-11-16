
def knapsack(W, weights, values, n  ):
    dp = [[0 for x in range(W + 1)] for y in range(n + 1)]
    for i in range(n + 1):
        for w in range(W + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0  
            elif weights[i-1] <= w:
                dp[i][w] = max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w])
            else:
                dp[i][w] = dp[i-1][w]

    return dp[n][W]

values = [60, 100, 120]  # Бараануудын үнэлгээ (Ui)
weights = [10, 20, 30]  # Бараануудын жин (Wi)
W = 50  
n = len(values) 

max_value = knapsack(W, weights, values, n)
print(f"Үүргэвчинд багтах хамгийн их үнэ цэнэ: {max_value}")
