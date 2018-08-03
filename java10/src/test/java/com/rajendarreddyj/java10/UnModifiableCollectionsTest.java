package com.rajendarreddyj.java10;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class UnModifiableCollectionsTest {
	
	List<Integer> list = List.of(1, 2, 3);;
	@Test(expected = UnsupportedOperationException.class)
	public void whenModifyCopyOfList_thenThrowsException() {
	    var copyList = List.copyOf(list);
	    copyList.add(4);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void whenModifyStreamList_thenThrowsException() {
		var result = Arrays.asList(1, 2, 3, 4)
				  .stream()
				  .collect(Collectors.toUnmodifiableList());

		result.add(4);
	}
	
	
	@Test
	public void whenModifyList() {
		var vegetables = new ArrayList<>(List.of("Brocolli", "Celery", "Carrot"));
		var unmodifiable = Collections.unmodifiableList(vegetables);
		vegetables.set(0, "Radish");
		Assert.assertSame(unmodifiable.get(0),"Radish");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void whenModifyList_thenThrowsException() {
		var vegetables = new ArrayList<>(List.of("Brocolli", "Celery", "Carrot"));
		var unmodifiable = Collections.unmodifiableList(vegetables);
		vegetables.set(0, "Radish");
		vegetables.add("Radish3");
		Assert.assertSame(unmodifiable.get(0),"Radish");
		Assert.assertSame(unmodifiable.size(),4);
		var unmodifiableList = List.copyOf(vegetables);
		unmodifiableList.add("Radish1");
	}
	@Test(expected = UnsupportedOperationException.class)
	public void whenModifyToUnmodifiableList_thenThrowsException() {
	    List<Integer> evenList = list.stream()
	      .filter(i -> i % 2 == 0)
	      .collect(Collectors.toUnmodifiableList());
	    evenList.add(4);
	}
	
	@Test
	public void whenListContainsInteger_OrElseThrowReturnsInteger() {
	    Integer firstEven = list.stream()
	      .filter(i -> i % 2 == 0)
	      .findFirst()
	      .orElseThrow();
	    is(firstEven).equals(Integer.valueOf(2));
	}
}
