package pl.ociepa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreaturesCharactersTest {

    @Test
    void shouldCreateCreaturesNewName(){
        CreaturesCharacters creature1 = new CreaturesCharacters("dupa");



        assertEquals("dupa", creature1.getName());

    }

}