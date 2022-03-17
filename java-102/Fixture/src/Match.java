public class Match {
  private Team home;
  private Team away;
  public Match(Team home, Team away){
    this.home=home;
    this.away=away;
  }

  public Team getHome() {
    return home;
  }

  public Team getAway() {
    return away;
  }
}
