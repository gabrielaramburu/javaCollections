package tree.binarytree.rotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RotationTest {


    private Node initialNode = new Node(5)
    							.setLeft(new Node(2))
                               .setRight(new Node(8)
                                            .setLeft(new Node(7))
                                            .setRight(new Node(12)));

   

    @Test
    public void rotateRight_shouldReturnRotatedNode() throws Exception {
        Node resultNode = new Node(2)
                         .setRight(new Node(5)
                                      .setRight(new Node(8)
                                                .setLeft(new Node(7))
                                                .setRight(new Node(12))));
        
        
        System.out.println("Before right rotate:");
        Node.showPreOrder(initialNode);
        System.out.println(" ");
        
        Node result = Node.rotateRight(initialNode);
        
        System.out.println("After right rotate:");
        Node.showPreOrder(result);
        System.out.println(" ");
        assertEquals(result, (resultNode));
                           
    }

    @Test
    public void rotateLeft_shouldReturnRotatedNode() throws Exception {
        Node resultNode = new Node(8)
                          .setLeft(new Node(5)
                                      .setLeft(new Node(2))
                                      .setRight(new Node(7)))
                          .setRight(new Node(12));               
        
        System.out.println("Before left rotate:");
        Node.showPreOrder(initialNode);
        System.out.println(" ");
        Node result = Node.rotateLeft(initialNode);
        
        System.out.println("After left rotate:");
        Node.showPreOrder(result);
        System.out.println(" ");
        assertEquals(result, (resultNode));
    }
    
    @Test
    public void unrotatableNodeRight() throws Exception {
    	  Node unrotableNode = new Node(5)
                  .			setRight(new Node(6)
                              .setRight(new Node(7)));

                                      
        
        System.out.println("unrotable, before right rotate:");
        Node.showPreOrder(unrotableNode);
        System.out.println("");
        Node result = Node.rotateRight(unrotableNode);
        System.out.println("unrotable, after right rotate:");
        Node.showPreOrder(result);
        
        assertEquals(result, (unrotableNode));
    }
    
    @Test
    public void unrotatableNodeLeft() throws Exception {
        Node unrotableNode = new Node(5)
                          .setLeft(new Node(4)
                                      .setLeft(new Node(3)));
        
       
        Node result = Node.rotateLeft(unrotableNode);
        assertEquals(result, (unrotableNode));
    }
}