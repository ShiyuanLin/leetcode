package amazonOA;

import java.util.*;

public class FindCountriesWithTheLargestDeficit {
  static class debtRecord{
    String borrower = ""; // importer
    String lender = ""; //exporter
    int amount = 0;

    debtRecord (String borrower, String lender, int amount) {
      this.borrower = borrower;
      this.lender = lender;
      this.amount = amount;
    }
  }

  static List<String> minimumDebtMembers(List<debtRecord> records){
    Map<String, Integer> balances = new HashMap<>();

    Integer curMin = Integer.MAX_VALUE;
    List<String> result = new ArrayList<>();

    for (debtRecord record: records) {
      balances.put(record.borrower, balances.getOrDefault(record.borrower, 0) - record.amount);
      balances.put(record.lender, balances.getOrDefault(record.lender, 0) + record.amount);
    }

    for (String country: balances.keySet()) {
      if (balances.get(country) < curMin) {
        curMin = balances.get(country);
        result.clear();
        result.add(country);
      } else if (balances.get(country).equals(curMin)) {
        result.add(country);
      }
    }

    if (curMin >= 0) {
      result.clear();
      result.add("None");
      return result;
    }
    Collections.sort(result);
    return result;
  }

  public static void main(String[] args) {
    List<debtRecord>records = new ArrayList<>();
    records.add(new debtRecord("alex", "blake", 2));
    records.add(new debtRecord("blake", "alex", 2));
    records.add(new debtRecord("casey", "alex", 5));
    records.add(new debtRecord("blake", "casey", 7));
    records.add(new debtRecord("alex", "blake", 4));
    records.add(new debtRecord("alex", "casey", 4));

    System.out.println(minimumDebtMembers(records));
  }
}
