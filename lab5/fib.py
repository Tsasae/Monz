class Solution:
    def __init__(self):
        self.cache = {}

    def fibonacci(self, n):
        if n in self.cache:
            return self.cache[n]

        if n == 0:
            return 0
        if n == 1:
            return 1

        result = self.fibonacci(n - 1) + self.fibonacci(n - 2)

    
        self.cache[n] = result
        return result

solution = Solution()
n = 10
print(f"Fibonacci({n}) = {solution.fibonacci(n)}")
