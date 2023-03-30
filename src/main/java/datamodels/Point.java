package datamodels;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Point {
    List<Integer> coordinates;
}
