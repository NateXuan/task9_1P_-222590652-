package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	@Test
    public void testAdditionWithValidNumbers() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.01);
    }
	
	@Test(expected = NumberFormatException.class)
    public void testAdditionWithEmptyString() {
        MathQuestionService.q1Addition("", "2");
    }
	
	@Test(expected = NumberFormatException.class)
    public void testAdditionWithNonNumericString() {
        MathQuestionService.q1Addition("a", "2");
    }
}
