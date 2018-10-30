import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MenuScreen {
    public void render() {
	Graphics g = new Graphics();
	Font font = new Font("Arial", Font.BOLD, 50);
	g.setFont(font);
	g.setColor(Color.RED);
	g.drawString("TYPING GAME", 335, 100);
    }
}