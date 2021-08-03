package tree2021;

import java.util.LinkedList;
import java.util.Queue;

public class Tree2021 {

    class Node {

        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    void printMe(Node root) {

        if (root != null) {
            printMe(root.left);
            System.out.print(root.value + " ");
            printMe(root.right);
        }

    }

    Node insert(Node root, int item) {
        if (root == null) {
            Node n = new Node(item);
            return n;
        } else if (root.value > item) {
            root.left = insert(root.left, item);
        } else if (root.value < item) {
            root.right = insert(root.right, item);
        }
        return root;
    }

    void levelOrder(Node root) {

        Queue q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {

            Node temp = (Node) q.poll();

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
            System.out.println(temp.value + " ");

        }

    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    int noOfNodes(Node root) {

        if (root == null) {
            return 0;
        }
        return noOfNodes(root.left) + noOfNodes(root.right) + 1;
    }

    int nonLeafNode(Node root) {

        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        return nonLeafNode(root.left) + nonLeafNode(root.right) + 1;

    }

    int leafNodes(Node root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafNodes(root.left) + leafNodes(root.right);
    }

    void mirror(Node root) {
        Node temp;
        if (root != null) {
            mirror(root.left);
            mirror(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

    }

    int searchInBst(Node root, int item) {

        if (root == null) {
            return 0;
        }

        if (root.value == item) {
            return 1;
        }

        if (item < root.value) {
            return searchInBst(root.left, item);
        } else {
            return searchInBst(root.right, item);
        }
    }

    void searchUsingLevelOrder(Node root, int item) {

        Queue q = new LinkedList<Node>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {

            Node temp = (Node) q.poll();

            if (temp.value == item) {
                flag = true;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        if (flag) {
            System.out.println("found");
        } else {
            System.out.println("Not present");
        }
    }

    int findSmallest(Node root) {

        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return root.value;
        } else {
            return findSmallest(root.left);
        }
    }

    int findLargest(Node root) {
        if (root == null) {
            return 0;
        } else if (root.right == null) {
            return root.value;
        } else {
            return findLargest(root.right);
        }
    }

    Node deleteBst(Node root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.value) {
            root.left = deleteBst(root.left, key);
        } else if (key > root.value) {
            root.right = deleteBst(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {

                int rightMin = findSmallest(root.right);
                root.value = rightMin;
                root = deleteBst(root.right, rightMin);
            }
        }
        return root;
    }

    // Function to delete element in binary tree 
    static void deletion(Node root, int key) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;
        Node key_node = null;

        // Do level order traversal to find deepest 
        // node(temp) and node to be deleted (key_node) 
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.value == key) {
                key_node = temp;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        int x = temp.value;
        deleteDeepest(root, temp);
        key_node.value = x;
    }

    static void deleteDeepest(Node root, Node d_node) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Do level order traversal until last node 
        Node temp;
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.right != null) {
                if (temp.right == d_node) {
                    temp.right = null;
                    d_node = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == d_node) {
                    temp.left = null;
                    d_node = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }

    int LCA(Node root, int n1, int n2) {

        if (root == null) {
            return -1;
        }

        if (isPresent(root.left, n1) && isPresent(root.right, n2)) {
            return root.value;
        }
        int x = LCA(root.left, n1, n2);
        if (x != -1) {
            return x;
        }
        int y = LCA(root.right, n1, n2);
        if (y != -1) {
            return y;
        }

        return -1;
    }

    boolean isPresent(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.value == key) {
            return true;
        }

        return (isPresent(root.left, key) || isPresent(root.right, key));
    }

    //Diameter = maximum(lDiameter, rDiameter, 1 + lHeight + rHeight)
    int diameter(Node root) {

        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(lDiameter, rDiameter));
    }

    //left view using level order traversal...
    void leftView(Node root) {

        Queue q = new LinkedList<Node>();
        q.add(root);

        while (q.size() != 0) {

            int size = q.size();
            System.out.print(" " + ((Node) q.peek()).value);
            while (size-- > 0) {

                Node temp = (Node) q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }

            }

        }

    }

    //right view of a tree
    void rightView(Node root) {

        if (root == null) {
            return;
        }

        Queue q = new LinkedList<>();
        q.add(root);

        System.out.print(root.value + " ");

        while (!q.isEmpty()) {

            int size = q.size();
            Node rightNode = null;

            while (size-- > 0) {

                Node temp = (Node) q.poll();

                if (temp.left != null) {
                    q.add(temp.left);
                    rightNode = temp.left;
                }

                if (temp.right != null) {
                    q.add(temp.right);
                    rightNode = temp.right;
                }
            }
            if (rightNode != null) {
                System.out.println(rightNode.value);
            }

        }
    }
    
    
    
    //for printing bottom view of tree print node only when it is leaf node
    void bottomView(Node root){
      
        if(root==null)
            return;
        
        if(root.left==null&&root.right==null){
         System.out.println(" "+root.value);
         return;
        }
        
        bottomView(root.left);
        bottomView(root.right);
       
    }

    
    //lowest common ancesstor in BST
    int LCSBST(Node root, int n1, int n2){
    
        if(root==null)
            return 0;
        
        if(root.value<n1&&root.value<n2){
            return LCSBST(root.right,n1,n2);
        }
        
        if(root.value>n1&&root.value>n2){
         return LCSBST(root.left,n1,n2);
        }
        
        return root.value;
    }
    
    
    
    
    
    public static void main(String[] args) {

        Node root = null;
        Tree2021 t = new Tree2021();
        root = t.insert(root, 50);
        root = t.insert(root, 40);
        // root = t.insert(root, 60);
        root = t.insert(root, 30);
        root = t.insert(root, 45);
        root = t.insert(root, 55);
        root = t.insert(root, 65);
          root = t.insert(root, 64);
        //   t.mirror(root);

        System.out.print("Left View : ");
        t.leftView(root);

        System.out.print("Right View : ");
        t.rightView(root);
        
        System.out.println("Bottom view");
        t.bottomView(root);

        System.out.println();
        
        
        System.out.println("LCSBST  " + t.LCSBST(root, 30, 45));

        //  t.deleteBst(root, 50);
        // t.deletion(root, 64);
        System.out.println("Diameter " + t.diameter(root));
        System.out.println("Ancesstor " + t.LCA(root, 55, 64));
        t.levelOrder(root);

        t.searchUsingLevelOrder(root, 444);
        System.out.println("Minimum " + t.findSmallest(root));
        System.out.println("Maximum " + t.findLargest(root));
        System.out.println("Search " + t.searchInBst(root, 65));
        System.out.println("height " + t.height(root));
        System.out.println("Total no of nodes " + t.noOfNodes(root));
        System.out.println("No of non leaf " + t.nonLeafNode(root));
        System.out.println("Leaf nodes " + t.leafNodes(root));

    }

}
