package OutCO;

import java.util.*;

class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int value) {
    // YOUR WORK HERE
	  value = value;
	  left = null;
	  right = null;
  }

}

class BinarySearchTree {
  public TreeNode root;
  public int size;

  public BinarySearchTree() {
    // YOUR WORK HERE
  }


  // Time Complexity:
  // Auxiliary Space Complexity:
  public void insert(int value) {
    // YOUR WORK HERE
	  insertUtil(root, value);
  }
  
  public TreeNode insertUtil(TreeNode node, int value) {
	  if(root==null) {
		  root = new TreeNode(value);
		  return root;
	  }
	  if(node == null) {
		  return new TreeNode(value);
	  }
		  
	  if(node.value < value) {
		  node.left = insertUtil(node.left,value);
	  }else {
		  node.right = insertUtil(node.right,value);
	  }
	  return node;
  }


  public boolean search(int value) {
	    // YOUR WORK HERE
	    searchUtil(root,value);
	    return false;
	  }
  
  public boolean searchUtil(TreeNode node, int value) {
	  if(node == null)
		  return false;
	  if(value == node.value)
		  return true;
	  if(value < node.value)
		  searchUtil(node.left,value);
	  else
		  searchUtil(node.right,value);
	 
	  
	  return false;
  }
}


////////////////////////////////////////////////////////////
///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
////////////////////////////////////////////////////////////

// use the Main class to run the test cases
class Main {
  private int[] testCount;

  // an interface to perform tests
  public interface Test {
    public boolean execute();
  }

  public static void main(String[] args) {

    int[] testCount = {0, 0};
    System.out.println("TreeNode Class");

    // tests are in the form as shown
    assertTest(testCount, "able to create an instance", new Test() {
      public boolean execute() {
        TreeNode node = new TreeNode(0);
        return node instanceof TreeNode;
      }
    });

    assertTest(testCount, "has value field", new Test() {
      public boolean execute() {
        TreeNode node = new TreeNode(0);
        try {
          node.getClass().getField("value");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "has left field", new Test() {
      public boolean execute() {
        TreeNode node = new TreeNode(0);
        try {
          node.getClass().getField("left");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "has right field", new Test() {
      public boolean execute() {
        TreeNode node = new TreeNode(0);
        try {
          node.getClass().getField("right");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "able to assign a value upon instantiation", new Test() {
      public boolean execute() {
        TreeNode node = new TreeNode(5);
        return node.value == 5;
      }
    });

    assertTest(testCount, "able to reassign a value", new Test() {
      public boolean execute() {
        TreeNode node = new TreeNode(5);
        node.value = 0;
        return node.value == 0;
      }
    });

    assertTest(testCount, "able to point to left child node", new Test() {
      public boolean execute() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(10);
        node1.left = node2;
        return node1.left.value == 10;
      }
    });

    assertTest(testCount, "able to point to right child node", new Test() {
      public boolean execute() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(10);
        node1.right = node2;
        return node1.right.value == 10;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Binary Search Tree Class");

    assertTest(testCount, "able to create an instance", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        return bst instanceof BinarySearchTree;
      }
    });

    assertTest(testCount, "has root field", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        try {
          bst.getClass().getField("root");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "has size field", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        try {
          bst.getClass().getField("size");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "default root set to null", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        return bst.root == null;
      }
    });

    assertTest(testCount, "default size set to zero", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        return bst.size == 0;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("BinarySearchTree Insert Method");

    assertTest(testCount, "has insert method", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();

        try {
          bst.getClass().getMethod("insert", new Class[] { int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "able to insert a node into empty binary search tree", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        return bst.size == 1 && bst.root.value == 5;
      }
    });

    assertTest(testCount, "able to insert node to left of root node", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        return bst.size == 2 && bst.root.value == 5 && bst.root.left.value == 3;
      }
    });

    assertTest(testCount, "able to insert node to right of node left of root node", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        return bst.size == 3 && bst.root.value == 5 && bst.root.left.value == 3 && bst.root.left.right.value == 4;
      }
    });

    assertTest(testCount, "able to insert node to right of root node", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(8);
        return bst.size == 2 && bst.root.value == 5 && bst.root.right.value == 8;
      }
    });

    assertTest(testCount, "able to insert node to left of node right of root node", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(8);
        bst.insert(7);
        return bst.size == 3 && bst.root.value == 5 && bst.root.right.value == 8 && bst.root.right.left.value == 7;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");

    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("BinarySearchTree Search Method");

    assertTest(testCount, "has search method", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();

        try {
          bst.getClass().getMethod("search", new Class[] { int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "returns true when element exists in binary search tree", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(4);
        bst.insert(7);
        return bst.search(4);
      }
    });

    assertTest(testCount, "returns true when element does not exist in binary search tree", new Test() {
      public boolean execute() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(4);
        bst.insert(7);
        return bst.search(10) == false;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");
  }

  private static void assertTest(int[] count, String name, Test test) {
    String pass = "false";
    count[1]++;

    try {
      if (test.execute()) {
        pass = " true";
        count[0]++;
      }
    } catch(Exception e) {}
    String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
    System.out.println(result);
  }
}