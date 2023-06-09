public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            int len = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<len; i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);

                temp.add(q.poll().val);
            }

            res.add(temp);
        }

        return res;
    }
