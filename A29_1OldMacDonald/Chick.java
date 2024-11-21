class Chick implements Animal
{
    private String myType;
    private String mySound;
    private String secondSound;
    
    /**
        Initializes a newly created Chick object so that it represents an Animal
        of the specified type that makes the specified sound.
      
        @param  type       the type of Chick
        @param  sound      the sound the Chick makes
     */
    public Chick(String type, String sound)
    {
      myType = type;
      mySound = sound;
      this.secondSound =  sound;
    }
    
    public Chick(String type, String sound, String secondSound)
    {
      myType = type;
      mySound = sound;
      this.secondSound = secondSound;
    }

    public String getSound()
    {
      if (Math.random() < 0.5) {
        return mySound;
      } else {
        return secondSound;
      }
    }
    
    public String getType()
    {
      return myType;
    }
}