package linkedlist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListUtils {

    /**
     * It splits the passed list into a sequence of sublists with a predefined size
     */
    public static <T> List<List<T>> splitListIntoSubLists(List<T> list, int subListSize) {
        List<List<T>> sublists = new ArrayList<>();

        // write your code here
        while (list.size() != 0) {
            List<T> newSubList = new ArrayList<>();
            for (int i = 0; i < subListSize; i++) {
                try {
                    newSubList.add(list.remove(0));
                } catch (Exception e) {
                    break;
                }
            }
            sublists.add(newSubList);
        }
        return sublists;
    }
}
