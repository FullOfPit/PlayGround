package datamodels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class GenericListNodeTest {

    //  -- Aux --
    String testString1 = "Test One";
    String testString2 = "Test Two";

    @Test
    void instantiatingNodeWithStringAsNodeContent() {
        //Given
        String testString = "Test Node Name";
        //When
        GenericListNode actual = new GenericListNode(testString);
        //Then
        Assertions.assertEquals("Test Node Name", actual.getNodeContent());
        Assertions.assertEquals(testString, actual.getNodeContent());
        Assertions.assertNull(actual.getNextNode());
    }

    @Test
    void setNextNode_RetrieveNextNode_GivesBackCorrectNode() {
        //Given
        GenericListNode firstNode = new GenericListNode(testString1);
        GenericListNode secondNode = new GenericListNode(testString2);
        //When
        firstNode.setNextNode(secondNode);
        //Then
        Assertions.assertEquals(secondNode, firstNode.getNextNode());
        Assertions.assertEquals(testString2, firstNode.getNextNode().getNodeContent());
    }

    @ParameterizedTest
    @MethodSource("generateDifferentObjectsForNodeContent")
    void setDifferentObjectAsNodeContent_RetrievalOfSameObjectsPossible(Object nodeContent) {
        //Given
        GenericListNode testNode = new GenericListNode(nodeContent);
        //When
        Object actual = testNode.getNodeContent();
        //Then
        Assertions.assertEquals(nodeContent, actual);
    }

    private static Stream<Arguments> generateDifferentObjectsForNodeContent() {
        return Stream.of(
                Arguments.arguments("Test String"),
                Arguments.arguments(1),
                Arguments.arguments(1.0),
                Arguments.arguments(List.of(1.0))
        );
    }

}