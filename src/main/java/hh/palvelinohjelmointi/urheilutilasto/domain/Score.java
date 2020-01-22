package hh.palvelinohjelmointi.urheilutilasto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Attributes
	private long  gameid;
	String sportstype;
	String winner;
	String player1name;
	String player2name;
	String[] player1score; // = {"0","0","0","0","0"};
	String[] player2score; // = {"0","0","0","0","0"};
	String finalscore;
	
	//public static final String[] SET_VALUES1 = new String[] { "0" };
	//public static final String[] SET_VALUES2 = new String[] { "0" };
	
	public Score() {}
	

	public Score(String sportstype, String winner, String player1name, String player2name, String finalscore, String player1score[], String player2score[]) {
		
		//Constructors
			super();
			this.sportstype = sportstype;
			this.winner = winner;
			this.player1name = player1name;
			this.player2name = player2name;
			this.finalscore = finalscore;
			this.player1score = player1score;
			this.player2score = player2score;
		}
	//get/set methods
	public long getGameid() {
		return gameid;
	}

	public void setGameid(long gameid) {
		this.gameid = gameid;
	}

	public String getSportstype() {
		return sportstype;
	}

	public void setSportstype(String sportstype) {
		this.sportstype = sportstype;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getPlayer1name() {
		return player1name;
	}

	public void setPlayer1name(String player1name) {
		this.player1name = player1name;
	}

	public String getPlayer2name() {
		return player2name;
	}

	public void setPlayer2name(String player2name) {
		this.player2name = player2name;
	}

	public String getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(String finalscore) {
		this.finalscore = finalscore;
	}
	
	public void setPlayer1score(String[] player1score) {
		this.player1score = player1score;
	}

	public String[] getPlayer1score() {
		return player1score;
	}

	public String[] getPlayer2score() {
		return player2score;
	}

	public void setPlayer2score(String[] player2score) {
		this.player2score = player2score;
	}
	//Function to add playerscores to a list
	public List<String> getRoundScores() {
		List<String> rounds = new ArrayList<>();
		for (int i=0; i<player1score.length; i++) {
			rounds.add(player1score[i] + " - " + player2score[i]);
		}
		return rounds;
	}
	
	//Function to determine winner
	 public String getWinningScore() {
		  //Lambda Expressions to convert String array to Int array and calculate sums
		 int sumOfscore1 = Arrays.stream(player1score).mapToInt(Integer::parseInt).sum();
		 int sumOfscore2 = Arrays.stream(player2score).mapToInt(Integer::parseInt).sum();
	        if(sumOfscore1 > sumOfscore2) {
	            winner = player1name;
	        } else if(sumOfscore2 > sumOfscore1) {
	            winner = player2name;
	        } 
	            return winner;
	        }
	    
	   
	

	
	@Override
	public String toString() {
		return "Score [gameid=" + gameid + ", sportstype=" + sportstype + ", winner=" + winner + ", player1name="
				+ player1name + ", player2name=" + player2name + ", player1score=" + player1score + ", player2score="
				+ player2score + ", finalscore=" + finalscore + "]";
	}




	}

