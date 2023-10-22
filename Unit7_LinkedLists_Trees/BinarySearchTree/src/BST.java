
public class BST<E extends Comparable> implements BST_Interface<E>{

    BSTNode<E> root;

    public BST(){
        root = null;
    }

    public BST(E data){
        root = new BSTNode<E>(data);
    }

    @Override
    public String preOrder() {
        if(root == null)
            return "[]";
        
        String ret = preOrderHelper(root);
        
        return "[" + ret.substring(0, ret.length() - 2) + "]";
    }

    public String preOrderHelper(BSTNode<E> temp){
        if(temp == null)
            return "";
        String ret = "";
            if(temp.getLeft() != null){
                ret += preOrderHelper(temp.getLeft());
            }
            if(temp.getRight() != null){
                ret += preOrderHelper(temp.getRight());
            }
        return temp.getData()+ ", " + ret;
    }

    @Override
    public String inOrder() {
        if(root == null)
            return "[]";
        
        String ret = "[" + inOrderHelper(root) + "]";
        return ret;
    }
    
    public String inOrderHelper(BSTNode<E> node){
        if(node == null)
            return "";
        String ret = "";
        String left = "";
        String right = "";
        if(node.getLeft() != null){
            left = inOrderHelper(node.getLeft());
        }
        ret += node.getData();
        if(node.getRight() != null){
            right = inOrderHelper(node.getRight());
        }
        return left + ((left == "")?"":(", ")) + ret + ((right == "")?"":(", " + right));
    }

    @Override
    public String postOrder() {
        if(root == null)
        return "[]";
        
        String ret = postOrderHelper(root);
        return "[" + ret.substring(0, ret.length() - 2) + "]";
    }

    public String postOrderHelper(BSTNode<E> node){
        if(node == null)
            return "";
        String ret = "";
        String left = "";
        String right = "";
        
        if(node.getLeft() != null){
            left = postOrderHelper(node.getLeft());
        }
        ret += node.getData();
        if(node.getRight() != null){
            right = postOrderHelper(node.getRight());
        }
        return left + right + ret + ", ";
    }
        

    @Override
    public E minValue() {
        if(root == null){
            return null;
        }
        BSTNode<E> temp = root;
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp.getData();
    }

    @Override
    public E maxValue() {
        
        BSTNode<E> temp = root;
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp.getData();    }

    @Override
    public int maxDepth() {
        if(root == null)
            return -1;
        return maxDepthHelper(root);
    }

    public int maxDepthHelper(BSTNode<E> node){
        if(node.getLeft() == null && node.getRight() == null)
            return 0;
        else if(node.getLeft() == null){
            return 1 + maxDepthHelper(node.getRight());
        }
        else if(node.getRight() == null){
            return 1 + maxDepthHelper(node.getLeft());
        }
        int left = maxDepthHelper(node.getLeft());
        int right = maxDepthHelper(node.getRight());

        return 1 + ((left > right)?left:right);
    }


    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int size() {
        return (root == null)?0:sizeHelper(root);
    }

    public int sizeHelper(BSTNode<E> node){
        int ret = 0;
        if(node == null)
            return 0;
        if(root.getLeft() != null){
            ret += sizeHelper(node.getLeft());
        }
        else if(root.getRight() != null){
            ret += sizeHelper(node.getRight());
        }
        return 1 + ret;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(E data) {
        return containsHelper(root, data);
    }

    public boolean containsHelper(BSTNode<E> node, E data){
        if(node == null){
            return false;
        }
        return node.getData().equals(data) || containsHelper(node.getLeft(), data) || containsHelper(node.getRight(), data);
    }

    @Override
    public boolean insert(E data) {
        return add(data);
    }

    @Override
    public boolean add(E data) {
        if(root == null){
            root = new BSTNode<E>(data);
            return true;
        }

        return addHelper(root, data);
    }

    public boolean addHelper(BSTNode<E> node, E data){
        if(data.equals(node.getData()))
            return false;
        
        if(data.compareTo(node.getData()) == -1){
            System.out.println("left");
            if(node.getLeft() == null){
                System.out.println("place");
                node.setLeft(new BSTNode<E>(data));
                return true;
            }
            return addHelper(node.getLeft(), data);
        }
        if(data.compareTo(node.getData()) == 1){
            System.out.println("right");
            if(node.getRight() == null){
                System.out.println("place");
                node.setRight(new BSTNode<E>(data));
                return true;
            }
            return addHelper(node.getRight(), data);
        }

        return false;
    }

    @Override
    public boolean remove(E data) {
        if(!contains(data)){
            System.out.println("test");
            return false;
        }
        if(root.getData() == data && root.getLeft() == null && root.getRight() == null){
            root = null;
            return true;
        }
        removeHelper(data, root);
        return true;
    }
    public boolean removeHelper(E data, BSTNode<E> node){
        System.out.println(data);
        
        if(node.getData().equals(data)){
            if(node.getLeft() != null && node.getRight() != null){
                System.out.println("2 Children");
                BSTNode<E> temp = node.getRight();
                while(temp.getLeft() != null){
                    temp = temp.getLeft();
                }
                node.setData(temp.getData());
                
                if(temp.getRight() != null){
                    temp.setData(temp.getRight().getData());
                    temp.setRight(null);
                }
                else{
                    temp = node.getRight();
                    while(temp.getLeft() != null && temp.getLeft().getLeft() != null){
                        temp = temp.getLeft();
                    }
                    if(node.getRight().getLeft() == null)
                    node.setRight(node.getRight().getRight());
                    else
                        temp.setLeft(null);
                }
            }
            else if(node.getRight() != null){
                System.out.println("1 Child on Right");
                node.setData(node.getRight().getData());
                node.setLeft(node.getRight().getLeft());
                node.setRight(node.getRight().getRight());
            }
            else if(node.getLeft() != null){
                System.out.println("1 Child on Left");
                node.setData(node.getLeft().getData());
                node.setLeft(node.getLeft().getLeft());
                // node.setLeft(node.getLeft().getLeft());            
            }
            
        }
        else if(node.getLeft() != null && node.getLeft().getData().equals(data) && node.getLeft().getLeft() == null && node.getLeft().getRight() == null){
            node.setLeft(null);
        }
        else if(node.getRight() != null && node.getRight().getData().equals(data) && node.getRight().getLeft() == null && node.getRight().getRight() == null){
            node.setRight(null);
        }

        else{
            if(node.getLeft() != null){
                removeHelper(data, node.getLeft());
            }
            if(node.getRight() != null){
                removeHelper(data, node.getRight());
            }
        }
        return true;
    }
    
}
