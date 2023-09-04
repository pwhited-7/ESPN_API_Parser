import java.util.ArrayList;

public class MLB {
    private String homeTeam;
    private int homeTeamScore;
    private String awayTeam;
    private int awayTeamScore;

    static ArrayList<MLB> mlbArrayList = new ArrayList<>();

    public MLB(String homeTeam, int homeTeamScore, String awayTeam, int awayTeamScore) {
        this.homeTeam = homeTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeam = awayTeam;
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    @Override
    public String toString() {
        return "MLB{" +
                "homeTeam='" + homeTeam + '\'' +
                ", homeTeamScore=" + homeTeamScore +
                ", awayTeam='" + awayTeam + '\'' +
                ", awayTeamScore=" + awayTeamScore +
                '}';
    }
}
