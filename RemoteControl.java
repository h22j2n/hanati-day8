public interface RemoteControl {
	public static final int MAX_VOLUMN = 50;
	public static final int MIN_VOLUMN = 0;
	public static final int MAX_CHANNEL = 100;
	public static final int MIN_CHANNEL = 1;
	
	public void turnOn();
	public void turnOff();
	public void volumnUp();
	public void volumnDown();
	public void setVolumn(int volume);
	public void setChannel(int channel);
	

}
