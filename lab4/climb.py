def climbStairs(n):
    def generate_combinations(n):
        if n == 0:
            return [[]]  
        if n == 1:
            return [[1]]  
        
        one_step_ways = generate_combinations(n - 1)  
        two_step_ways = generate_combinations(n - 2)  
        
        result = []
        for way in one_step_ways:
            result.append(way + [1])  
    
        for way in two_step_ways:
            result.append(way + [2])  
        
        return result

    if n == 0:
        print("No steps to climb.")
        return 0
    elif n == 1:
        print("Only 1 step to climb. There's 1 way to climb it:")
        print("1. 1 step")
        return 1
    elif n == 2:
        print("2 steps to climb. There are 2 ways to climb to the top:")
        print("1. 1 step + 1 step")
        print("2. 2 steps")
        return 2
    
    combinations = generate_combinations(n)
    print("{} steps to climb. There are {} ways to climb to the top:".format(n, len(combinations)))
    
    for idx, combination in enumerate(combinations, 1):
        steps = " + ".join("{} step".format(step) for step in combination)
        print("{}. {}".format(idx, steps))
    
    return len(combinations)

n = int(input("Enter the number of steps: "))
climbStairs(n)

def one_step_solution(n):
    return ' + '.join(['1 step' for _ in range(n)])

n = int(input("Enter the number of steps (n): "))
print("{} steps to climb using only 1-step increments:".format(n))
print(one_step_solution(n))