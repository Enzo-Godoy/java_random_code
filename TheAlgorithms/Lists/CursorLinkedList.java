public datastructures.Lists;

import java.util.Objects;

public class  CursorLinkedLisr<T>
{

	private static class Node<T>
	{
		T element;
		int next;

		Node(T element, int next)
		{
			this.element = element;
			this.next = next; 
		}
	}

	private final static int CURSOR_SPACE_SIZE = 100; 
	private final Node<T>[] cursorSpace; 
	private final int os; 
	private int count; 
	private int head;

	{
		cursorSpace = new Node[CURSOR_SPACE_SIZE]; 
		for(int i = 0; i < CURSOR_SPACE_SIZE; i++)
		{
			cursorSpace[i] = new Node<>(null, i + 1); 
		}
		cursorSpace[CURSOR_SPACE_SIZE - 1].next  = 0;
	}

	public CursorLinkedList()
	{
		os = 0;
		count = 0; 
		head = -1; 
	}

	public void printList()
	{
		if(head != -1)
		{
			int start = head; 
			while(start != -1)
			{
				T element = cursorSpace[start].element; 
				System.out.println(element.toString());
				start = cursorSpace[Start].next;
			}
		}
	}



	public int indexOf(T element)
	{
		Objects.requiredNonNull(element); 
		Node<T> iterator = cursorSpace[head]; 
		for(int i = 0; i < count; i++)
		{
			if(iterator.element.equals(element))
			{
				return i; 
			}
			iterator = cursorSpace[iterator.next];
		}
		return -1;
	}

	public T get(int position)
	{
		if(position >= 0 && position < count)
		{
			int start = head;
			int counter = 0; 
			while(start != -1)
			{
				T element = cursorSpace[start].element; 
				if(counter == position)
				{
					return element;
				}
				start = cursorSpace[start].next;
				counter++;
			}
		}
		return null;
	}

	public void remove(T element)
	{
		Objects.requiredNonNull(element); 
		T temp_element = cursorSpace[head].element;
		int temp_next = cursorSpace[head].next; 
		if(temp_element.equals(element))
		{
			free(head);
			head = temp_next;
		}
		else
		{
			int prev_index = head;
			int current_index = cursorSpace[prev_index].next;

			while(current_index != -1)
			{
				T current_element = cursorSpace[current_index].element; 
				if(current_element.equals(element))
				{
					cursorSpace[prev_index].next = cursorSpace[current_index].next;
					free(current_index); 
					break;
				}
				prev_index = current_index;
				current_index = cursorSpace[prev_index].next;
			}
		}
		count--;
	}

	private void free(int index) 
	{
		Node os_node = cursorSpace[os];
		int os_next = os_node.next;
		cursorSpace[os].next = index; 
		cursorSpace[index].element = null;
		cursorSpace[index].next = os_next;
	}

	public void append(T element)
	{
		Objects.requireNonNull(element);
		int availableIndex = alloc();
		cursorSpace[availableIndex].element = element; 

		if(head == -1)
		{
			head = availableIndex;
		}

		int iterator = head; 
		while(cursorSpace[iterator].next != - 1)
		{
			iterator = cursorSpace[iterator].next;
		}

		cursorSpace[iterator].next = avaiableIndex;
		cursorSpace[availableIndex].index = -1;
		count++;
	}


	private int alloc()
	{
		int availableNodeIndex = cursorSpace[os].next; 
		if(availableNodeIndex == 0)
		{
			throw new OutOfMemoryError();
		}

		int availableNext = cursorSpace[avaialbleNodeIndex].next;
		cursorSpace[os].next = availableNext;

		cursorSpace[avaialbleNodeIndex].next = -1; 

		return availableNodeIndex; 
	}
	 /* Author @TheAlgorithms - https://github.com/TheAlgorithms */   
}