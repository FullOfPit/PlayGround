package linkedlist;

import datamodels.GenericListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


class LinkedListTest {

    //  -- Aux --
    String testString1 = "Test String One";
    String testString2 = "Test String Two";

    static GenericListNode firstTestNode = new GenericListNode("1");
    static GenericListNode secondTestNode = new GenericListNode("2");
    static GenericListNode thirdTestNode = new GenericListNode("3");
    @Test
    void setHeadNode_HeadNodeIsReturned_WhenHeadNodeRetrieved() {
        //Given
        LinkedList testLinkedList = new LinkedList();
        GenericListNode testNode = new GenericListNode(testString1);
        //When
        testLinkedList.setHeadNode(testNode);
        GenericListNode actual = testLinkedList.getHeadNode();
        //Then
        Assertions.assertEquals(testNode, actual);
        Assertions.assertEquals(testString1, actual.getNodeContent());
    }

    @Test
    void setNewHeadNode_NewHeadNodeIsReturned_WhenHeadNodeRetrieved() {
        //Given
        LinkedList testLinkedList = new LinkedList();
        GenericListNode firstTestNode = new GenericListNode(testString1);
        GenericListNode secondTestNode = new GenericListNode(testString2);

        //When
        testLinkedList.setHeadNode(firstTestNode);
        testLinkedList.addNewNodeToBeginning(secondTestNode);
        GenericListNode actual = testLinkedList.getHeadNode();

        //Then
        Assertions.assertEquals(secondTestNode, actual);
        Assertions.assertEquals(testString2, actual.getNodeContent());
    }

    @Test
    void setNewTailNode_NewTailNodeIsReturned_WhenTailNodeRetrieved() {
        //Given
        LinkedList testLinkedList = new LinkedList(firstTestNode);

        //When
        testLinkedList.addNewNodeToEnd(secondTestNode);

        //Then
        Assertions.assertEquals(firstTestNode, testLinkedList.getHeadNode());
        Assertions.assertEquals(secondTestNode, testLinkedList.getTailNode());
    }

    @Test
    void traverseLinkedList_TraversesListInCorrectWay_ReturnsCorrectValues_WhenTraversedThroughNodes() {
        //Given
        LinkedList testLinkedList = new LinkedList(firstTestNode);
        testLinkedList.addNewNodeToEnd(secondTestNode);
        testLinkedList.addNewNodeToEnd(thirdTestNode);

        //When
        List<Object> actual = new ArrayList<>();
        GenericListNode currentNode = testLinkedList.getHeadNode();

        while (currentNode != null) {
            actual.add(currentNode.getNodeContent());
            currentNode = currentNode.getNextNode();
        }

        //Then
        Assertions.assertEquals(List.of("1", "2", "3"), actual);
    }

    @Test
    void traverseLinkedList_WhenNodesAddedToBeginning_TraversesListInCorrectWay_ReturnsCorrectValues_WhenTraversedThroughNodes() {
        //Given
        GenericListNode firstTestNode = new GenericListNode("1");
        GenericListNode secondTestNode = new GenericListNode("2");
        GenericListNode thirdTestNode = new GenericListNode("3");

        LinkedList testLinkedList = new LinkedList(firstTestNode);

        testLinkedList.addNewNodeToBeginning(secondTestNode);
        testLinkedList.addNewNodeToBeginning(thirdTestNode);
        //When

        List<Object> actual = new ArrayList<>();
        GenericListNode currentNode = testLinkedList.getHeadNode();

        while (currentNode != null) {
            actual.add(currentNode.getNodeContent());
            currentNode = currentNode.getNextNode();
        }

        //Then
        Assertions.assertEquals(List.of("3", "2", "1"), actual);
    }

    @ParameterizedTest
    @MethodSource("nodeRemovalArgumentGenerator")
    void removeNode_ReturnsCorrectNode_OrNull_AndNodeRemoved(
            GenericListNode firstTestNode,
            GenericListNode secondTestNode,
            GenericListNode thirdTestNode,
            GenericListNode nodeToBeTestedAgainst
    ) {
        //Given
        LinkedList testLinkedList = new LinkedList(firstTestNode);

        testLinkedList.addNewNodeToBeginning(secondTestNode);
        testLinkedList.addNewNodeToBeginning(thirdTestNode);
        //When
        GenericListNode actual = testLinkedList.removeNode(nodeToBeTestedAgainst);
        //Then
        Assertions.assertEquals(nodeToBeTestedAgainst, actual);
        Assertions.assertNull(testLinkedList.removeNode(new GenericListNode("4")));
    }
    private static Stream<Arguments> nodeRemovalArgumentGenerator() {
        return Stream.of(
                Arguments.arguments(firstTestNode, secondTestNode, thirdTestNode, firstTestNode),
                Arguments.arguments(firstTestNode, secondTestNode, thirdTestNode, secondTestNode),
                Arguments.arguments(firstTestNode, secondTestNode, thirdTestNode, thirdTestNode)
        );
    }

    @ParameterizedTest
    @MethodSource("nodeRemovalArgumentGeneratorWithContentList")
    void removeNode_ReturnsCorrectListOfValuesWhenListTraversed_AndNodeRemoved(
            GenericListNode firstTestNode,
            GenericListNode secondTestNode,
            GenericListNode thirdTestNode,
            GenericListNode nodeToBeTestedAgainst,
            List<String> resultList
    ) {
        //Given
        LinkedList testLinkedList = new LinkedList(firstTestNode);

        testLinkedList.addNewNodeToBeginning(secondTestNode);
        testLinkedList.addNewNodeToBeginning(thirdTestNode);
        //When
        testLinkedList.removeNode(nodeToBeTestedAgainst);

        List<Object> actual = new ArrayList<>();
        GenericListNode currentNode = testLinkedList.getHeadNode();

        while (currentNode != null) {
            actual.add(currentNode.getNodeContent());
            currentNode = currentNode.getNextNode();
        }
        //Then
        Assertions.assertEquals(resultList, actual);
    }
    private static Stream<Arguments> nodeRemovalArgumentGeneratorWithContentList() {
        return Stream.of(
                Arguments.arguments(firstTestNode, secondTestNode, thirdTestNode, firstTestNode, List.of("3", "2")),
                Arguments.arguments(firstTestNode, secondTestNode, thirdTestNode, secondTestNode, List.of("3", "1")),
                Arguments.arguments(firstTestNode, secondTestNode, thirdTestNode, thirdTestNode, List.of("2", "1"))
        );
    }

}