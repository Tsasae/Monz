import matplotlib.pyplot as plt
import networkx as nx

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums):
        if not nums:
            return None
        
        def convertListToBST(left, right):
            if left > right:
                return None
            
            mid = (left + right) // 2
            node = TreeNode(nums[mid])
            node.left = convertListToBST(left, mid - 1)
            node.right = convertListToBST(mid + 1, right)
            return node
        
        return convertListToBST(0, len(nums) - 1)

def add_edges(graph, node, pos=None, x=0, y=0, layer=1):
    if node is not None:
        graph.add_node(node.val, pos=(x, y))
        if node.left:
            graph.add_edge(node.val, node.left.val)
            l = x - 1 / layer
            add_edges(graph, node.left, pos, x=l, y=y-1, layer=layer+1)
        if node.right:
            graph.add_edge(node.val, node.right.val)
            r = x + 1 / layer
            add_edges(graph, node.right, pos, x=r, y=y-1, layer=layer+1)

def draw_tree(root):
    graph = nx.DiGraph()
    add_edges(graph, root)
    pos = nx.get_node_attributes(graph, 'pos')
    labels = {n: n for n in graph.nodes()}
    nx.draw(graph, pos, labels=labels, with_labels=True, arrows=False)
    plt.show()

solution = Solution()
root1 = solution.sortedArrayToBST([-10, -3, 0, 5, 9])
root2 = solution.sortedArrayToBST([1, 3])

draw_tree(root1)
draw_tree(root2)
