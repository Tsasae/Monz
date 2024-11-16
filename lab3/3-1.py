def majorityElement(nums):
    def majority_element_rec(lo, hi):
        # Base case: the only element in an array of size 1 is the majority element.
        if lo == hi:
            return nums[lo]
        
        # Recur for left and right halves of this slice.
        mid = (hi - lo) // 2 + lo
        left = majority_element_rec(lo, mid)
        right = majority_element_rec(mid + 1, hi)
        
        # If the two halves agree on the majority element, return it.
        if left == right:
            return left
        
        # Otherwise, count each element and return the "winner".
        left_count = sum(1 for i in range(lo, hi + 1) if nums[i] == left)
        right_count = sum(1 for i in range(lo, hi + 1) if nums[i] == right)
        
        return left if left_count > right_count else right
    
    return majority_element_rec(0, len(nums) - 1)

# Example usage:
print(majorityElement([3, 2, 3]))  # Output: 3
print(majorityElement([2, 2, 1, 1, 1, 2, 2]))  # Output: 2
