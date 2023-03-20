package amazonOA;

import java.util.*;

public class TopKFrequentWords {
  static class GameSpecs implements  Comparable<GameSpecs> {
    String game;
    int numReview;
    int numOccur;

    GameSpecs (String game, int numReview, int numOccur) {
      this.game = game;
      this.numOccur = numOccur;
      this.numReview = numReview;
    }

    @Override
    public int compareTo(GameSpecs o) {
      if (this.numOccur == o.numOccur) {
        return Integer.compare(this.numReview, o.numReview);
      } else {
        return Integer.compare(this.numOccur, o.numOccur);
      }
    }
  }
  public List<String> getTopGames(int num, int topKGames, String[] games, int numReviews, String[] reviews) {
    Map<String, GameSpecs> nameSpecs = new HashMap<>();
    for (String game: games) {
      nameSpecs.put(game.toLowerCase(), new GameSpecs(game, 0, 0));
    }

    for (String review: reviews) {
      for(String word: review.split("\\s+")) {
        Set<String> appeared = new HashSet<>();
        if (nameSpecs.containsKey(word.toLowerCase())) {
          GameSpecs game = nameSpecs.get(word.toLowerCase());
          game.numOccur++;
          appeared.add(word.toLowerCase());
        }
        for (String game: appeared) {
          nameSpecs.get(game).numReview++;
        }
      }
    }

    List<GameSpecs> gameSpecs = new ArrayList<>(nameSpecs.values());
    gameSpecs.sort(Collections.reverseOrder());
    List<String> res = new ArrayList<>();
    for (int i = 0; i < Math.min(topKGames, gameSpecs.size()); i++) {
      res.add(gameSpecs.get(i).game);
    }
    return res;
  }
}
