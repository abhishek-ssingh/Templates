public TreeNode findNode(TreeNode root, TreeNode tar){
  if(root==null) return null;
  
  if(root==tar) return root;
  
  TreeNode left = findNode(root.left, tar);
  TreeNode right = findNode(root.right, tar);
  
  return left!=null ? left:right;
}
