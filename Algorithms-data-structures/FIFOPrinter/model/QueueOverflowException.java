package model;

public class QueueOverflowException extends RuntimeException
{
  public QueueOverflowException(String message)
  {
    super(message);
  }
}