package tests;

import mydeque.DequeCollection;
import mydeque.MyDeque;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;


public class MyDequeTests {
    DequeCollection<String> deque = new MyDeque<>();

  @Test()
  public void addFirstTestCase() {

      deque.addFirst("first");
      deque.addFirst("first1");
      Assert.assertSame(deque.getFirst(), "first1");
      Assert.assertEquals(2, deque.size());
  }

  @Test
  public void addLastTestCase() {
      deque.addFirst("first");
      deque.addLast("last");
      Assert.assertSame(deque.getLast(), "last");
      Assert.assertEquals(2, deque.size());
  }

  @Test
  public void peekFirstTestCase() {
      deque.addLast("first");
      deque.addLast("last");
      Assert.assertEquals(deque.peekFirst(), "first");
      Assert.assertEquals(2, deque.size());
  }

  @Test
  public void peekLastTestCase() {
      deque.addLast("first");
      deque.addLast("last");
      Assert.assertEquals(deque.peekLast(), "last");
      Assert.assertEquals(2, deque.size());
  }

  @Test
  public void pollFirstTestCase() {
      deque.addLast("first");
      deque.addLast("last");
      Assert.assertEquals(deque.pollFirst(), "first");
      Assert.assertEquals(deque.getFirst(), "last");
      Assert.assertEquals(1, deque.size());
  }

  @Test
  public void pollLastTestCase() {
      deque.addFirst("first");
      deque.addLast("last");
      Assert.assertEquals(deque.pollLast(), "last");
      Assert.assertEquals(deque.getLast(), "first");
      Assert.assertEquals(1, deque.size());
  }

  @Test
  public void pollNullTestCase() {
      Assert.assertNull(deque.pollLast());
      Assert.assertNull(deque.pollFirst());
  }

  @Test
  public void peekNullTestCase() {
      Assert.assertNull(deque.peekLast());
      Assert.assertNull(deque.peekFirst());
  }

  @Test
  public void getMethodExceptionTestCase() {
      try {
          deque.getFirst();
          deque.getLast();
      } catch (NoSuchElementException e) {
          Assert.assertEquals(e.getClass().getSimpleName(),NoSuchElementException.class.getSimpleName());
      }

  }
}
