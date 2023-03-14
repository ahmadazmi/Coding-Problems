# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode | None) -> int:
        return self.traverse(root, 0)
    
    def traverse(self, node: TreeNode | None, sum: int) -> int:
        sum = (sum*10)+node.val
        if (node.left is None and node.right is None):
            return sum
        left = 0 if node.left is None else self.traverse(node.left, sum)
        right = 0 if node.right is None else self.traverse(node.right, sum)
        return left + right