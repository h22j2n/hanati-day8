/**
 * 다중구현을 이용한 클래스 정의
 * @author 조희진
 *
 */
public class SamsongTV implements RemoteControl, Browsable {
	
	private int currentChannel;
	private int currentVolumn;

	public SamsongTV() {
		super();
	}

	public SamsongTV(int currentChannel, int currentVolumn) {
//		super();
		this.currentChannel = currentChannel;
		this.currentVolumn = currentVolumn;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrentVolumn() {
		return currentVolumn;
	}

	public void setCurrentVolumn(int currentVolumn) {
		this.currentVolumn = currentVolumn;
	}

	@Override
	public void surfing(String url) {
		System.out.println(url + "을 화면에 렌더링합니다.");

	}

	@Override
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}

	@Override
	public void volumnUp() {
		if(!(currentVolumn >= MAX_VOLUMN)) {
			currentVolumn++;
			
		}
	}

	@Override
	public void volumnDown() {
		if(!(currentVolumn <= MIN_VOLUMN)) {
			currentVolumn--;
			
		}
	}

	@Override
	public void setVolumn(int volume) {
		currentVolumn = volume;

	}

	@Override
	public void setChannel(int channel) {
		currentChannel = channel;
	}
	
	
	
	public static void main(String[] args) {
		RemoteControl tv = new SamsongTV();
		tv.turnOn();
		tv.setChannel(10);
		
		System.out.println(((SamsongTV) tv).getCurrentChannel());
		
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		System.out.println(((SamsongTV) tv).getCurrentVolumn());
		
		System.out.println(RemoteControl.MAX_CHANNEL);
		//SamsongTV.MAX_CHANNEL 해도 됨
		
		tv.turnOff();
	}

}
