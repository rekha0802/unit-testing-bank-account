package com.rekha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    private final StudentGrade student = new StudentGrade();

    // ==========================================
    // TESTING METHOD: calculateGrade()
    // ==========================================

    @Test
    public void testCalculateGrade_ScoreUnderMin_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            student.calculateGrade(-5);
        }, "Score must be between 0 and 100");
    }

    @Test
    public void testCalculateGrade_ScoreOverMax_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            student.calculateGrade(105);
        }, "Score must be between 0 and 100");
    }

    @Test
    public void testCalculateGrade_GradeA() {
        assertEquals("A", student.calculateGrade(85));
        assertEquals("A", student.calculateGrade(80)); // batas bawah A
    }

    @Test
    public void testCalculateGrade_GradeB() {
        assertEquals("B", student.calculateGrade(75));
        assertEquals("B", student.calculateGrade(70)); // batas bawah B
    }

    @Test
    public void testCalculateGrade_GradeC() {
        assertEquals("C", student.calculateGrade(65));
        assertEquals("C", student.calculateGrade(60)); // batas bawah C
    }

    @Test
    public void testCalculateGrade_GradeD() {
        assertEquals("D", student.calculateGrade(55));
        assertEquals("D", student.calculateGrade(50)); // batas bawah D
    }

    @Test
    public void testCalculateGrade_GradeE() {
        assertEquals("E", student.calculateGrade(40));
        assertEquals("E", student.calculateGrade(0));  // batas bawah E
    }

    // ==========================================
    // TESTING METHOD: isPassed()
    // ==========================================

    @Test
    public void testIsPassed_ScoreUnderMin_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            student.isPassed(-10);
        });
    }

    @Test
    public void testIsPassed_ScoreOverMax_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            student.isPassed(120);
        });
    }

    @Test
    public void testIsPassed_True_WhenScoreIsSixtyOrAbove() {
        assertTrue(student.isPassed(60)); // tepat di batas lulus
        assertTrue(student.isPassed(75)); // di atas batas lulus
    }

    @Test
    public void testIsPassed_False_WhenScoreIsUnderSixty() {
        assertFalse(student.isPassed(59)); // tepat di bawah batas lulus
        assertFalse(student.isPassed(30)); // jauh di bawah batas lulus
    }
}
