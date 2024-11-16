import unittest
def fibonacci(n, cache=None):
    if cache is None:
        cache = {}
        
    if n in cache:
        return cache[n]
    
    if n == 0:
        return 0
    elif n == 1:
        return 1
    
    cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache)
    return cache[n]

# Unit test
def test_fibonacci():
    assert fibonacci(0) == 0
    assert fibonacci(1) == 1
    assert fibonacci(2) == 1
    assert fibonacci(3) == 2
    assert fibonacci(4) == 3
    assert fibonacci(5) == 5
    assert fibonacci(10) == 55
    print("All tests passed.")


test_fibonacci()
if __name__=="__main__":
    unittest.main()