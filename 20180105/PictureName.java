//******************************
//Erase "/src" of picture names if you don't use Eclipse
//******************************

//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//import javax.swing.*;

public class PictureName {
    private static String background, character, hukidashi, stframe, gameover;
    private static String[] name;

    PictureName(int scene){
		name = new String [5];
		switch(scene){
			case 1:
			    background = "src/sea.png";
			    character = "src/octopus1.png";
			    stframe = "src/frame1.png";
			    hukidashi = "src/hukidashi1.png";
			    gameover = "src/octopus2.png";
			    break;
			case 2:
			    break;
			default:
			    background = "src/sky.png";
			    character = "src/bear1.png";
			    stframe = "src/frame1.png";
			    hukidashi = "src/hukidashi1.png";
			    gameover = "src/bear2.png";
			    break;
		}
		setName();
    }

    public void setName(){
		name[0]=name[1]=name[2]=name[3]=name[4]="";
		name[0] = background;
		name[1] = character;
		name[2] = stframe;
		name[3] = hukidashi;
		name[4] = gameover;
    }

    public String[] getName(){
    	return name;
    }
}
