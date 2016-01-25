public interface PlayerInt{

    public void update(int exp);

    public void gainEXP(int exp);

    public String levelUp();

    public void CheckUseItem(String item);

    public void useItem(String item);

    public String itemResponse(String item, int num);

    public String bag();

    public String info();

    public String viewStats();
    

} //end
