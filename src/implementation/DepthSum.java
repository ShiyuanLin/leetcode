package implementation;

import model.NestedInteger;

import java.util.List;

public class DepthSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumHelper(nestedList, 1);
    }

    public int depthSumHelper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger nested: nestedList) {
            if (nested.isInteger()) {
                sum += nested.getInteger() * depth;
            } else {
                sum += depthSumHelper(nested.getList(), depth + 1);
            }
        }
        return sum;
    }
}
