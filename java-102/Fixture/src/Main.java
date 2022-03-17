import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//*2 tane koleksiyon kullanacağım, 1-) Takım isimlerini tutan ArrayList , 2-)Müsabakaları Haftaları Tutan HashSet;
public class Main {
  public static void main(String[] args) {
    ArrayList<Team> teams = new ArrayList<>();
    createTeamList(teams);
//    teams.add(new Team("GALATASARAY"));
//    teams.add(new Team("Bursaspor"));
//    teams.add(new Team("Fenerbahçe"));
//    teams.add(new Team("Beşiktaş"));
//    teams.add(new Team("Başakşehir"));
//    teams.add(new Team("Boluspor"));
//    teams.add(new Team("TRABZONSPOR"));
    int weekCount = 0,attempCount=0 ;
    ArrayList<String> firstHalfFixture = new ArrayList<>();
    ArrayList<String> secondHalfFixture = new ArrayList<>();
    while (weekCount < teams.size() - 1) {
      ArrayList<Team> tmpTeams = (ArrayList<Team>) teams.clone();
      ArrayList<Match> weeklyMacthes = new ArrayList<>();
      while (!tmpTeams.isEmpty()) {
        attempCount=0;
        int homeIndex = (int) (Math.random() * tmpTeams.size());
        Team home = tmpTeams.get(homeIndex);
        int awayIndex = (int) ( tmpTeams.size() * Math.random());
        Team away = tmpTeams.get(awayIndex);
        while (!home.isPlayed(away) && attempCount<=tmpTeams.size()) {
          awayIndex++;
          awayIndex = (awayIndex % tmpTeams.size());
          attempCount++;
          away = tmpTeams.get(awayIndex);
        }
        if(attempCount>tmpTeams.size()){
          weekCount--;
          break;
        }
        weeklyMacthes.add(new Match(home,away));
        tmpTeams.remove(away);
        tmpTeams.remove(home);
        attempCount=0;
      }
      if (attempCount==0){
        for (Match match:weeklyMacthes) {
          match.getHome().removeTeam(match.getAway());
          match.getAway().removeTeam(match.getHome());
          firstHalfFixture.add(match.getHome().getName() + " vs " + match.getAway().getName());
          secondHalfFixture.add(match.getAway().getName() + " vs " + match.getHome().getName());
        }
      }
      weekCount++;
    }
    firstHalfFixture.addAll(secondHalfFixture);

    writeFixture(firstHalfFixture,teams);

  }
  private static void createTeamList(ArrayList<Team> teams){
    Scanner input = new Scanner(System.in);
    System.out.println("Lütfen Takım Sayısını Giriniz");
    boolean flag = true;
    int countTeams = 0;
    while (flag) {
      try {
        countTeams = Integer.parseInt(input.nextLine());
        flag = false;
      } catch (NumberFormatException exception) {
        System.out.println("Lütfen Sayı Gir");
      }
    }
    for (int i = 0; i < countTeams; i++) {
      System.out.println((i + 1) + ".takım ismini giriniz.");
      String teamName = input.nextLine();
      teams.add(new Team(teamName));
    }
    if (teams.size() % 2 == 1) {
      teams.add(new Team("Bay"));
    }
    for (int i = 0; i < teams.size(); i++) {
      ArrayList<Team> tmpTeams = (ArrayList<Team>) teams.clone();
      tmpTeams.remove(i);
      teams.get(i).setUnplayedOpponent(tmpTeams);
    }
  }
  private static void writeFixture(ArrayList<String> fixture,ArrayList<Team> teams){
    int weekNumber = 1 ;
    Iterator<String> iterator = fixture.iterator();
    while (iterator.hasNext()){
      System.out.println(weekNumber+".HAFTA");
      for (int i = 0; i < teams.size()/2; i++) {
        System.out.println(iterator.next());
      }
      System.out.println("------------------------");
      weekNumber++;
    }
  }
}
