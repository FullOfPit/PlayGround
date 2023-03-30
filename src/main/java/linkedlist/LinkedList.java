package linkedlist;

import datamodels.GenericListNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedList {

    private GenericListNode headNode;
    private GenericListNode tailNode;

    public LinkedList(GenericListNode firstNode) {
        this.headNode = firstNode;
        this.tailNode = firstNode;
    }

    public void addNewNodeToBeginning (GenericListNode newHeadNode) {
        newHeadNode.setNextNode(this.headNode);
        this.headNode = newHeadNode;
    }

    public void addNewNodeToEnd (GenericListNode newTailNode) {
        this.tailNode.setNextNode(newTailNode);
        this.tailNode = newTailNode;
    }

    public GenericListNode removeNode (GenericListNode nodeToTestAgainst) {
        GenericListNode currentNode = this.headNode;

        if (this.headNode.equals(nodeToTestAgainst)) {
            GenericListNode oldHeadNode = this.headNode;
            this.headNode = this.headNode.getNextNode();
            oldHeadNode.setNextNode(null);
            return oldHeadNode;
        }

        while (currentNode.getNextNode() != null) {

            if (currentNode.getNextNode().equals(nodeToTestAgainst)) {
                GenericListNode nodeToBeRemoved = currentNode.getNextNode();
                currentNode.setNextNode(nodeToBeRemoved.getNextNode());
                nodeToBeRemoved.setNextNode(null);
                return nodeToBeRemoved;
            }

            currentNode = currentNode.getNextNode();
        }
        return null;
    }
}
