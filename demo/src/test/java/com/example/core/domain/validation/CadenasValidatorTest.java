package com.example.core.domain.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CadenasValidatorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@ValueSource(strings = {"12345678z", "4G"})
	void testIsNIFOK(String caso) {
		assertTrue(CadenasValidator.isNIF(caso));
	}
	@ParameterizedTest
	@ValueSource(strings = {"12345678", "G", "G4"})
	@EmptySource
	@NullSource
	void testIsNIFKO(String caso) {
		assertFalse(CadenasValidator.isNIF(caso));
	}

	@Test
	void testIsNotNIF() {
		assertTrue(CadenasValidator.isNotNIF(null));
	}


	@ParameterizedTest
	@ValueSource(strings = {"PEPE", "PIÑÓN", "JUAN DE LA COSA"})
	@EmptySource
	void testIsMayusculasOK(String caso) {
		// Arrange
		// CadenasValidator
		// var caso = "PEPE";
		
		// Act
		var actual = CadenasValidator.isMayusculas(caso);
		
		// Assert
		assertTrue(actual);
	}

	@Test
	void testIsMayusculasNull() {
		var ex = assertThrows(IllegalArgumentException.class, () -> CadenasValidator.isMayusculas(null));
		assertEquals("Value vacio", ex.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"pepe"})
//	@NullSource
	void testIsMayusculasKO(String caso) {
		// Arrange
		// CadenasValidator
//		var caso = "pepe";
		// Act
		boolean actual = true;
		assertDoesNotThrow(() -> CadenasValidator.isMayusculas(caso));

		// Assert
		assertFalse(CadenasValidator.isMayusculas(caso));
	}

	@Test
	void testIsNotMayusculas() {
		assertTrue(CadenasValidator.isNotMayusculas("kk"));
	}

}
