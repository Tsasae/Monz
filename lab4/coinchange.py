class Solution:
    def coinChange(self, coins, amount):
        # dp массивыг эхэлж хязгааргүйгээр дүүргэх (∞)
        dp = [float('inf')] * (amount + 1)
        
        # 0 хэмжээтэй мөнгө хийхэд 0 зоос хэрэгтэй
        dp[0] = 0

        # Бүх зоосыг ашиглан dp массивыг шинэчилнэ
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)
        
        # Хэрэв dp[amount] нь хязгааргүй хэвээр байгаа бол -1 буцаана
        return dp[amount] if dp[amount] != float('inf') else -1

def get_input_and_run():
    coins = list(map(int, input("Зооснуудыг хооронд нь зайгаар тусгаарлан оруулна уу: ").split()))
    amount = int(input("Шаардлагатай нийт мөнгөний хэмжээг оруулна уу: "))
    sol = Solution()
    result = sol.coinChange(coins, amount)
    print(f"Хамгийн бага зоосны тоо: {result}")

get_input_and_run()
