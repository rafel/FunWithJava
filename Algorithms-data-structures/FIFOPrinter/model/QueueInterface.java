package model;

public interface QueueInterface
{
	public void push(Document item) throws QueueOverflowException;
	public void pop() throws QueueUnderflowException;
	public Document top() throws QueueUnderflowException;
	public boolean isEmpty();
	public boolean isFull();
}