package recipeproject.cookbook.converters;

import org.junit.Before;
import org.junit.Test;
import recipeproject.cookbook.commands.NotesCommand;
import recipeproject.cookbook.domain.Notes;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {
    public static  final Long LONG_VALUE = 1L;
    public static final String RECIPE_NOTES = "recipe notes";

    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }



    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new NotesCommand()));
    }
    @Test
    public void convert() throws Exception {
        NotesCommand notesCmd = new NotesCommand();
        notesCmd.setId(LONG_VALUE);
        notesCmd.setRecipeNotes(RECIPE_NOTES);

        Notes notes = converter.convert(notesCmd);

        assertEquals(LONG_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }

}