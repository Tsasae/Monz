#include <vector>
#include <unordered_map>
#include <fstream>
#include <iostream>
#include <sstream>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::unordered_map<int, int> num_map; 
        
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];  
            
            if (num_map.find(complement) != num_map.end()) {
                return {num_map[complement], i};
            }
            num_map[nums[i]] = i;
        }
        
        return {};  
    }
};

int main() {
    std::ifstream inputFile("input.txt");
    std::ofstream outputFile("output1.txt");

    if (!inputFile.is_open()) {
        std::cerr << "Neehed aldaa garsn!" << std::endl;
        return 1;
    }
    
    if (!outputFile.is_open()) {
        std::cerr << "Haahad aldaa garsan!" << std::endl;
        return 1;
    }
    
    std::vector<int> nums;
    int target;
    
    std::string line;
    
    if (std::getline(inputFile, line)) {
        std::istringstream iss(line);
        int num;
        while (iss >> num) {
            nums.push_back(num);
        }
    }

    if (std::getline(inputFile, line)) {
        std::istringstream iss(line);
        iss >> target;
    }
    
    Solution solution;
    std::vector<int> result = solution.twoSum(nums, target);
    
    if (result.empty()) {
        outputFile << "Hariult oldoogui." << std::endl;
    } else {
        outputFile << result[0] << " " << result[1] << std::endl;
    }
    
    inputFile.close();
    outputFile.close();
    
    return 0;
}
