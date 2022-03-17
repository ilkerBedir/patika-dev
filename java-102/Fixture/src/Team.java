import java.util.ArrayList;

public class Team {
  private String name;
  private ArrayList<Team> unplayedOpponent;

  public Team(String name){
    this.name=name;
    this.unplayedOpponent=new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Team> getUnplayedOpponent() {
    return unplayedOpponent;
  }

  public void addTeam(Team team){
    this.unplayedOpponent.add(team);
  }

  public void removeTeam(Team team){
    this.unplayedOpponent.remove(team);
  }
  public boolean isPlayed(Team team){
    boolean contains = this.unplayedOpponent.contains(team);
    return contains;
  }

  public void setUnplayedOpponent(ArrayList<Team> unplayedOpponent) {
    this.unplayedOpponent = unplayedOpponent;
  }
}
