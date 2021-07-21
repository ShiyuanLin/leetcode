package amazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretFruitList {
  public static boolean matchSecretLists(List<List<String>> secretFruitLists, List<String> customerPurchasedList) {
    int idx = 0;
    while (idx < customerPurchasedList.size()) {
      for (List<String> secretFruits: secretFruitLists) {
        if (secretFruits.get(0).equals("anything") || secretFruits.get(0).equals(customerPurchasedList.get(idx))) {
          int subIdx = 1;
          while (subIdx < secretFruits.size() && subIdx + idx < customerPurchasedList.size()) {
            if (!secretFruits.get(subIdx).equals("anything")
                    && !secretFruits.get(subIdx).equals(customerPurchasedList.get(idx + subIdx))) {
              break;
            }
            subIdx++;
          }
          if (subIdx == secretFruits.size()) {
            return true;
          }
        }
      }
      idx++;
    }
    return false;
  }

  public static void main(String[] args) {
    List<List<String>> secretFruitLists = new ArrayList<>();
//    secretFruitLists.add(new ArrayList<>(Arrays.asList("orange", "mongo")));
//    secretFruitLists.add(new ArrayList<>(Arrays.asList("watermelon", "mongo")));
    secretFruitLists.add(new ArrayList<>(Arrays.asList("watermelon","anything", "mongo")));
    System.out.println(secretFruitLists);
//    System.out.println(matchSecretLists(secretFruitLists, Arrays.asList("orange", "mongo", "strawberry", "watermelon", "mongo")));
//    System.out.println(matchSecretLists(secretFruitLists, Arrays.asList("watermelon", "orange", "mongo")));
    System.out.println(matchSecretLists(secretFruitLists, Arrays.asList("watermelon", "apple", "orange", "mongo")));
  }
}
