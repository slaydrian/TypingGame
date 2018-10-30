//import java.awt.*;
//import java.awt.event.*;
import java.util.*;
//import javax.swing.*;

public class Variable extends Observable{
	public static int Scene=-1;
	public static int HP_player=10;
	public static int HP_enemy=100;
	public static int HP_enemy_MAX=100;
	public static int Score=0;

	Variable() { }

	public void setScore(int n) {
		Score += n;
	}
	public int getScore() {
		return Score;
	}

	public void setScene(int n) {
		Scene += 1;
		if(Scene>1) Scene=0;
		if(n<0) Scene=0;
	}
	public int getScene() {
		return Scene;
	}

	public void setHP_player(int n) {
		if(n==10) HP_player = 10;
		else HP_player -= 1;
		if(HP_player<0) HP_player = 0;
		setChanged();
	    notifyObservers();
	}
	public int getHP_player() {
		return HP_player;
	}

	public void setHP_enemy(int n) {
		HP_enemy -= n*2;
		if(HP_enemy<0) HP_enemy=0;
		if(n==-1) HP_enemy = 100;
	}
	public int getHP_enemy() {
		return HP_enemy;
	}
	public int getHP_enemy_MAX() {
	    return HP_enemy_MAX;
	 }


}
