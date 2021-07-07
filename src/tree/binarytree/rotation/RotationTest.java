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
        assertEquals(initialNode.rotateRight(initialNode), (resultNode));
                           
    }

    @Test
    public void rotateLeft_shouldReturnRotatedNode() throws Exception {
        Node resultNode = new Node(8)
                          .setLeft(new Node(5)
                                      .setLeft(new Node(2))
                                      .setRight(new Node(7)))
                          .setRight(new Node(12));                                      
        assertEquals(initialNode.rotateLeft(initialNode), (resultNode));
    }
}