package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BeatModelTest {
    private RockModel R;
    private JazzModel J;
    private ElectroModel E;
    private HipHopModel H;

    @BeforeEach
    void RunBefore(){
        R = new RockModel();
        E = new ElectroModel();
        J = new JazzModel();
        H = new HipHopModel();
    }

    @Test
    void testConstructor(){
        R = new RockModel();
        assertEquals("````+````````+```", R.getTopLayer());
        assertEquals("..S...S...S...S.", R.getSnareLayer());
        assertEquals("O.ooO...O.ooO...", R.getBassLayer());
        assertEquals(Beat.ROCK, R.getGenre());
        assertEquals("S", R.insString);
    }

    @Test
    void testRockCreate(){
        assertEquals(
                "S...Ss.....S.s.S",
                R.createStress(new ArrayList<Integer>(){
            {
            add(1);
            add(1);
            add(4);
            add(4);
            }
        }));
    }

    @Test
    void testElectroCreate(){
        assertEquals(
                "E...E......EEXEX",
                E.createStress(new ArrayList<Integer>(){
                    {
                        add(1);
                        add(1);
                        add(4);
                        add(4);
                    }
                }));
    }

    @Test
    void testJazzCreate(){
        assertEquals(
                ".S.sS...Ss.S",
                J.createStress(new ArrayList<Integer>(){
                    {
                        add(2);
                        add(2);
                        add(3);
                        add(3);
                    }
                }));
    }

    @Test
    void testHipHopCreate(){
        assertEquals(
                ".s..S...s.Ss",
                H.createStress(new ArrayList<Integer>(){
                    {
                        add(2);
                        add(2);
                        add(3);
                        add(3);
                    }
                }));
    }
}