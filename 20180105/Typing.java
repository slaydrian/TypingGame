import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Typing extends JLabel implements KeyListener, ActionListener {
	private Variable v;
    private Randomword rw;
    private int n=0;
    private String word="Let's hang out!";
    private JLabel label;
    private JLabel scoreLabel;

    private static final int INIT_DELAY = 10000;
    private static final int SPEED = 10;
    private static final int NUM_RANKING = 5;

    private boolean isPlaying;
    private int delay;
    private int score;
    private ArrayList<Integer> ranking;
    private long prevTime;
    private javax.swing.Timer timer;

    public Typing(Variable vo) {
		//super(title);
		this.setLayout(new GridLayout(3,1));
		v = vo;
		label = new JLabel(" ");
		label.setFont(new Font(null, Font.PLAIN, 30));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		this.add(label);

		addKeyListener(this);
		setFocusable(true);

		scoreLabel = new JLabel();
		scoreLabel.setHorizontalAlignment(JLabel.LEFT);

		ranking = new ArrayList<Integer>(NUM_RANKING);
		for (int i = 0; i < NUM_RANKING; i++) {
		    ranking.add(0);
		}

		isPlaying = false;
		timer = new javax.swing.Timer(0, this);
		timer.setRepeats(false);
		showTitle();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
		if (!isPlaying&&e.getKeyChar()==KeyEvent.VK_SPACE) {
		    n = 0;
		    v.setScene(1);
		    if(v.getHP_player()==0) {
		    	v.setScene(-1);
		    	v.setHP_player(10); 
		    }
		    newGame();
		   
		} else {
		    String text = label.getText();
		    if (text.charAt(0) == e.getKeyChar()) {
				if (text.length() > 1) {
				    label.setText(text.substring(1));
				} else {
				    success();
				}
		    } else {
				//System.out.println("miss");
		    	v.setHP_player(1);
		    	if(v.getHP_player()==0) {
		    		gameOver(); 
		    	}
	    	}
		}
    }

	public void actionPerformed(ActionEvent e) {
		if (!isPlaying) {
		    return;
		}
		if (label.getText().length() > 0) {
		    gameOver();
		}
    }

    protected String getLabelText() {
    	return label.getText();
    }

    private void refreshScore() {
    	scoreLabel.setText("Point:" + score + " SPEED:" + delay);
    }

    private void newGame() {
		isPlaying = true;
		score = 0;
		delay = INIT_DELAY;
		refreshScore();
		newWord();
    }

    private void gameOver() {
    	n=1;
		isPlaying = false;
		timer.stop();
		label.setForeground(Color.white);
		showTitle();
    }

    private void success() {
		long time = System.currentTimeMillis();
		score += INIT_DELAY - (time - prevTime);
		delay -= SPEED;
		delay = Math.max(delay, 0);
		newWord();
		refreshScore();
    }

    private void newWord() {
		label.setForeground(Color.black);
		//ramdomword
		rw = new Randomword(v.getScene()*2+5);
		label.setText(rw.getWord());
		setWord(rw.getWord());

		timer.setInitialDelay(delay);
		timer.restart();
		prevTime = System.currentTimeMillis();
    }

    private void showTitle() {
    	label.setText("Press Space Button.");
    }
    private void setWord(String s) {
    	word = s;
    }
    public String getWord() {
    	return word;
    }
    public int getn() {
    	return n;
    }


}
