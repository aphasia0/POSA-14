package edu.vuum.mocca;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleSemaphoreUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleSemaphore() {
		SimpleSemaphore simpleSemaphore = new SimpleSemaphore(2, true);
		assertNotNull(simpleSemaphore);
	}

	@Test
	public void testAcquire() throws InterruptedException {
		SimpleSemaphore simpleSemaphore = new SimpleSemaphore(2, true);
		assertEquals(simpleSemaphore.mAvailablePermits, 2);
		simpleSemaphore.acquire();
		assertEquals(simpleSemaphore.mAvailablePermits, 1);
		simpleSemaphore.acquire();
		assertEquals(simpleSemaphore.mAvailablePermits, 0);
	}

	@Test
	public void testAcquireUninterruptibly() throws InterruptedException {
		SimpleSemaphore simpleSemaphore = new SimpleSemaphore(2, true);
		assertEquals(simpleSemaphore.mAvailablePermits, 2);
		simpleSemaphore.acquireUninterruptibly();
		assertEquals(simpleSemaphore.mAvailablePermits, 1);
		simpleSemaphore.acquireUninterruptibly();
		assertEquals(simpleSemaphore.mAvailablePermits, 0);
	}

	@Test
	public void testRelease() throws InterruptedException {
		SimpleSemaphore simpleSemaphore = new SimpleSemaphore(2, true);
		assertEquals(simpleSemaphore.mAvailablePermits, 2);
		simpleSemaphore.acquire();
		assertEquals(simpleSemaphore.mAvailablePermits, 1);
		simpleSemaphore.acquire();
		assertEquals(simpleSemaphore.mAvailablePermits, 0);
		simpleSemaphore.release();
		assertEquals(simpleSemaphore.mAvailablePermits, 1);
		simpleSemaphore.release();
		assertEquals(simpleSemaphore.mAvailablePermits, 2);
		// Test to see if release allows you to go 'above' resource count
		simpleSemaphore.release();
		assertEquals(simpleSemaphore.mAvailablePermits, 2);
	}

}
