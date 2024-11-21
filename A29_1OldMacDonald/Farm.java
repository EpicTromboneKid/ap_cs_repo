import java.util.*;

/**
   This emulates a farm
   it represents, and how to use it.
  
   @author  Chaaruhaas Kandregula
   @version 11/6/2024

   Period - 3
   Assignment - A29.1 Old MacDonald

   Sources - None
 */
public class Farm
{
   private Animal[] a = new Animal[3];
  Farm()
  {
    a[0] = new NamedCow("cow","Elsie","moo");
    a[1] = new Chick("chick","cheep","cluck");
    a[2] = new Pig("pig","oink");
  }

  public void animalSounds()
  {
    for (int i = 0; i < a.length; i++)
    {
      System.out.println(a[i].getType() + " goes " + a[i].getSound());
    }
    System.out.println("The cow is known as " +
                      ((NamedCow)a[0]).getName());
  }
}

