package dev.arcticsoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BSTTests {

	@Test
	public void creation() {
		var bst = new BinarySearchTree();
		assertNotNull(bst);
		assertEquals(Collections.emptyList(), bst.listInOrder());
		assertThrows(NullPointerException.class, () -> bst.findNextInnorder(bst.getRoot()));
	}

	@Test
	public void InsertIsOrderedBST() {
		var insertList = Arrays.asList(20, 15, 7, 283, 534, 1, 45);
		Collections.shuffle(insertList);
		var bst = new BinarySearchTree();
		insertList.forEach(value -> bst.insert(value));
		assertEquals(List.of(1, 7, 15, 20, 45, 283, 534), bst.listInOrder());
	}

	@Test
	public void insertHasNoDuplicates() {
		var bst = new BinarySearchTree();
		var list = Arrays.asList(20, 15, 7, 283, 534, 1, 45);
		list.forEach(value -> bst.insert(value));
		bst.insert(20);
		bst.insert(534);
		bst.insert(1);
		Collections.sort(list);
		assertEquals(list, bst.listInOrder());
	}

	@Test
	public void findNextInOrder() {
		var bst = new BinarySearchTree();
		var list = Arrays.asList(5, 9, 11, 12, 13, 14, 20, 25);
		list.forEach(value -> bst.insert(value));
		var node = bst.insert(6);
		assertEquals(9, bst.findNextInnorder(node));
	}
}