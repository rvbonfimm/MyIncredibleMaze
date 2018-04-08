package Classes;

import java.awt.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.MouseButtonControl;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class TestSlick extends BasicGame implements InputProviderListener
{
        private InputProvider provider;
	private Command click = new BasicCommand("click");
        private String msg = "";
        private Circle c = new Circle(10, 10, 10);
        
        private Board board;
        private Search search;
        
        private ArrayList<Shape> figs;
        private ArrayList<Shape> blocks;
        
        public TestSlick(String gamename){
            super(gamename);
            
            
            // 0 + 1
            // 10 + i + 1
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
            board = new Board((byte)10);
            search = new Bfs();
            
            board.set(search.run(board));
            
            figs = new ArrayList<>();
            blocks = new ArrayList<>();
            
            for(int i = 0; i < board.getSize(); i++) {
                for(int j = 0; j < board.getSize(); j++) {
            //        if(board.get((byte)i, (byte)j) == Board.PATH)
              //          blocks.add(new Rectangle(i * 20, j * 20, 10, 10));
                    figs.add(new Rectangle(i * 20, j * 20, 10, 10));
                }
            }
            
            
            provider = new InputProvider(gc.getInput());
            provider.addListener(this);
            
            provider.bindCommand(new MouseButtonControl(0), click);
        }
        
        public void controlPressed(Command command) {
            for(int i = 0; i < board.getSize(); i++) {
                for(int j = 0; j < board.getSize(); j++) {
                    if(board.get((byte)i, (byte)j) == Board.PATH)
                        blocks.add(new Rectangle(i * 20, j * 20, 10, 10));
                }
            }
            
	}

        @Override
        public void controlReleased(Command cmnd) {
            
        }
        
	@Override
	public void update(GameContainer gc, int index) throws SlickException {
            Input input = gc.getInput();
            int xpos = input.getMouseX();
            int ypos = input.getMouseY();
        
            for(int i = 0; i < figs.size(); i++) {
                if(figs.get(i).contains(xpos, ypos))
                    msg = "ok";
            }
                
        }

        @Override
        public void render(GameContainer container, Graphics g) throws SlickException {
            g.setColor(Color.white);
            for(int i = 0; i < figs.size(); i++)
                g.draw(figs.get(i));
            
            g.setColor(Color.red);
            for(int i = 0; i < blocks.size(); i++) {
                g.draw(blocks.get(i));
                g.drawString("" + i, 30, 20);
            }
            
            
           // g.drawString(msg, 10, 20);
        }

	public static void main(String[] args)
	{
            try
            {
                    AppGameContainer appgc;
                    appgc = new AppGameContainer(new TestSlick("Simple Slick Game"));
                    appgc.setDisplayMode(800, 600, false);
                    appgc.start();
            }
            catch (SlickException ex)
            {
                    Logger.getLogger(TestSlick.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}