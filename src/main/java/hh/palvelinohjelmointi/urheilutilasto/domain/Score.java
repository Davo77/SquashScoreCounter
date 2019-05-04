package hh.palvelinohjelmointi.urheilutilasto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  gameid;
	String sportstype;
	String winner;
	int player1score;
	int player2score;
	int finalscore;
	
	public Score() {}

	public Score(String sportstype, String winner, int player1score, int player2score, int finalscore) {
		
			super();
			this.sportstype = sportstype;
			this.winner = winner;
			this.player1score = player1score;
			this.player2score = player2score;
			this.finalscore = finalscore;
		}

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

	public int getPlayer1score() {
		return player1score;
	}

	public void setPlayer1score(int player1score) {
		this.player1score = player1score;
	}

	public int getPlayer2score() {
		return player2score;
	}

	public void setPlayer2score(int player2score) {
		this.player2score = player2score;
	}

	public int getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(int finalscore) {
		this.finalscore = finalscore;
	}

	@Override
	public String toString() {
		return "Score [gameid=" + gameid + ", sportstype=" + sportstype + ", winner=" + winner + ", player1score="
				+ player1score + ", player2score=" + player2score + ", finalscore=" + finalscore + "]";
	}




	}
