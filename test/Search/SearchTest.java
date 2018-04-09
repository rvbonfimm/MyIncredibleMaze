/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import Classes.Bfs;
import Classes.Board;
import Classes.Position;
import Classes.Search;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author EngComp
 */
public class SearchTest {
    
    private Board board;
    private Search search;
    
    
    public SearchTest() {
    }

    
    @Before
    public void init() {
        board = new Board((byte)10, (byte)1);
        search = new Bfs(board);
    
    }
    
    @Test
    public void posicaoDiferenteDeFinalTest() {
        assertFalse(search.isTarget(new Position((byte)1, (byte)1)));
    }
    
    @Test
    public void posicaoIgualFinalTest() {
        assertTrue(search.isTarget(new Position((byte)9, (byte)9)));
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
