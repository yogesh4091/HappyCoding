package designpatterns.observerpattern;

/** Created by 611217002 on 2/13/2017. */
public class Score {

  private int runs;
  private int wickets;
  private double overs;
  private String teamName;

  public Score(String teamName) {
    this.teamName = teamName;
    wickets = 0;
    runs = 0;
    overs = 0;
  }

  public int getRuns() {
    return runs;
  }

  public void setRuns(int runs) {
    this.runs = runs;
  }

  public int getWickets() {
    return wickets;
  }

  public void setWickets(int wickets) {
    this.wickets = wickets;
  }

  public double getOvers() {
    return overs;
  }

  public void setOvers(double overs) {
    this.overs = overs;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }
}
