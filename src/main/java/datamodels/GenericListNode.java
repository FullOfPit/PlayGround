package datamodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericListNode {

    private Object nodeContent;
    private GenericListNode nextNode;

    public GenericListNode(Object nodeContent) {
        this.nodeContent = nodeContent;
        this.nextNode = null;
    }
}
